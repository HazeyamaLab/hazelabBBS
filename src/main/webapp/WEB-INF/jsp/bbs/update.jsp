<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <%@ taglib prefix="c"
uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
  <head>
    <!-- CSS -->
    <link rel="stylesheet" href="/hazelabBBS/css/bootstrap.min.css" />
    <link
      rel="stylesheet"
      href="/hazelabBBS/font/css/open-iconic-bootstrap.css"
    />
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>編集</title>
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
      <h2 class="page-header">作成済みBBSの編集</h2>
      <hr />
      <form action="/hazelabBBS/bbs/update" method="post">
        <div class="form-group">
          <label for="title">掲示板タイトル</label>
          <input
            class="formcontrol"
            type="text"
            name="title"
            id="title"
            value="${bbs.title}"
          />
        </div>
        <div class="form-group">
          <label for="description">説明</label>
          <textarea
            class="form-control"
            name="description"
            id="description"
            rows="3"
            cols="60"
          >${bbs.description}</textarea
          >
        </div>
        <div class="form-group">
          <input type="hidden" name="bbsId" value="${bbs.bbsId}" />
          <button type="submit" class="btn btn-primary">編集</button>
        </div>
      </form>
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
