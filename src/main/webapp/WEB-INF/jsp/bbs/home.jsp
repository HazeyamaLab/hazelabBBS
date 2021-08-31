<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <%@ taglib prefix="c"
uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<!DOCTYPE html>
<html lang="ja">
  <head>
    <!-- CSS -->
    <link rel="stylesheet" href="/hazelabBBS/css/bootstrap.min.css" />
    <link
      rel="stylesheet"
      href="/hazelabBBS/font/css/open-iconic-bootstrap.css"
    />
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>BBS</title>
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
      <h2 class="page-header">新規BBSの作成</h2>
      <hr />
      <form action="/hazelabBBS/bbs" method="post">
        <div class="form-group">
          <label for="title">掲示板タイトル</label>
          <input class="form-control" type="text" name="title" id="title" />
        </div>
        <div class="form-group">
          <label for="description">説明</label>
          <textarea
            class="form-control"
            name="description"
            id="description"
            rows="3"
            cols="60"
          ></textarea>
        </div>
        <div class="form-group">
          <button type="submit" class="btn btn-primary">作成</button>
        </div>
      </form>

      <c:if test="${empty requestScope.bbs}">
        <hr />
        <div class="alert alert-warning">掲示板はありません．</div>
      </c:if>

      <c:if test="${!empty requestScope.bbs}">
        <h2 class="page-header">作成済みBBS: ${fn:length(bbs)}件</h2>
        <hr />
      </c:if>
      <c:forEach var="b" items="${requestScope.bbs}">
        <div class="card mb-3">
          <div class="card-header">
            <h4 class="panel-title">
              <a
                class="text-dark"
                href="/hazelabBBS/bbs/post?id=${b.bbsId}"
                >${b.title}</a
              >
              &nbsp;
              <a
                class="text-info"
                href="/hazelabBBS/bbs/update?id=${b.bbsId}"
                ><span class="oi oi-pencil"></span
              ></a>
            </h4>
          </div>
          <div class="card-body">
            <p>${b.description}</p>
            <div class="text-right">
              <a
                class="btn btn-danger"
                href="/hazelabBBS/bbs/delete?id=${b.bbsId}"
                ><span class="oi oi-trash"></span
              ></a>
            </div>
          </div>
          <div class="card-fotter">
            <div class="text-right">作成日：${b.createdAt}</div>
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
