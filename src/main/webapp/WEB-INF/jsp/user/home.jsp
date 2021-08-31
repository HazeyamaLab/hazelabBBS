<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>
<meta charset=UTF-8>
<!-- CSS -->
<link rel="stylesheet" href="/hazelabBBS/css/bootstrap.min.css">
<link  rel="stylesheet" href="/hazelabBBS/font/css/open-iconic-bootstrap.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ユーザー登録</title>
</head>
<body>
<!-- ナビゲーションバー -->
<nav class="navbar navbar-dark bg-dark">
		<a class="navbar-brand" href="/hazelabBBS/bbs">HazeLabBBS</a>
		<ul class="navbar-nav mr-auto mt-2 mt-lg-0">
		</ul>
</nav>
<br>
<!-- コンテンツ -->
<div class="container">
<h2>新規ユーザー登録</h2>
<hr>
	<form action="/hazelabBBS/user" method="post">
		<div class="form-group">
			<label for="userName">名前</label>
			<input class="form-control" type="text" name="userName" id="userName" value="${param.userName}">
		</div>
		<div class="form-group">
			<label for="userId">ユーザーID</label>
			<input class="form-control" type="text" name="userId" id="userId" value="${param.userId}">
		</div>
		<div class="form-group">
			<label for="password">パスワード</label>
			<input class="form-control" type="password" name="password" id="password">
		</div>
		<div class="form-group">
			<button type="submit" class="btn btn-primary">登録</button>
		</div>
	</form>
</div>
</body>
</html>
