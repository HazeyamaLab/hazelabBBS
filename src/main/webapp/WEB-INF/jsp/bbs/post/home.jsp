<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <%@ taglib prefix="c"
uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
  <head>
    <link rel="stylesheet" href="/hazelabBBS/css/bootstrap.min.css" />
    <link
      rel="stylesheet"
      href="/hazelabBBS/font/css/open-iconic-bootstrap.css"
    />
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>${bbs.title}</title>
  </head>
  <body>
    <!-- ナビゲーションバー -->
    <nav class="navbar navbar-dark bg-dark">
      <a class="navbar-brand" href="/hazelabBBS/bbs">HazeLabBBS</a>
      <ul class="navbar-nav mr-auto mt-2 mt-lg-0"></ul>
      <a class="btn btn-warning" href="/hazelabBBS/logout">ログアウト</a>
    </nav>
    <br />
    <!-- コンテンツ -->
    <div class="container">
      <h2 class="page-header">${bbs.title}</h2>
      <hr />
      <h4 class="page-header">新規投稿</h4>
      <form action="/hazelabBBS/bbs/post" method="post">
        <div class="form-group">
          <label for="title">投稿タイトル</label>
          <input class="formcontrol" type="text" name="title" id="title" />
        </div>
        <div class="form-group">
          <label for="body">投稿内容</label>
          <textarea
            class="form-control"
            name="body"
            id="body"
            rows="5"
            cols="60"
          ></textarea>
        </div>
        <div class="form-group">
          <input type="hidden" name="bbsId" value="${bbs.bbsId}" />
          <button type="submit" class="btn btn-primary">投稿</button>
        </div>
      </form>
      <hr />

      <c:if test="${empty posts}">
        <div class="alert alert-warning">投稿はありません．</div>
      </c:if>

      <c:forEach var="post" items="${requestScope.posts}">
        <div class="card mb-3">
          <div class="card-header">${post.contributorId} さんの書き込み</div>
          <div class="card-body">
            <h5 class="card-title">${post.title}</h5>
            <hr />
            <p class="card-text">${post.body}</p>

            <div class="text-right">
              <a
                href="/hazelabBBS/bbs/post/update?id=${post.postId}"
                class="btn btn-secondary"
                ><span class="oi oi-pencil">編集</span></a
              >
              <a
                href="/hazelabBBS/bbs/post/delete?id=${post.postId}&bbsId=${post.bbsId}"
                class="btn btn-danger"
                ><span class="oi oi-trash"></span
              ></a>
            </div>
          </div>
        </div>
      </c:forEach>
    </div>
    <!-- javascript -->
    <script
      type="text/javascript"
      src="/hazelabBBS/js/jquery-3.2.1.min.js"
    ></script>
    <script
      type="text/javascript"
      src="/hazelabBBS/js/bootstrap.min.js"
    ></script>
  </body>
</html>
