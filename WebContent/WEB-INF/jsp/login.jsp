<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>
<!-- CSS -->
<link rel="stylesheet" href="/hazelabBBS/css/bootstrap.min.css">
<link  rel="stylesheet" href="/hazelabBBS/font/css/open-iconic-bootstrap.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ログイン</title>
</head>
<body>
<!-- ナビゲーションバー -->
<nav class="navbar navbar-dark bg-dark">
		<a class="navbar-brand" href="/hazelabBBS/">HazeLabBBS</a>
</nav>
<br>
<!-- コンテンツ -->
<div class="container">
	<h1 class="page-header">ログイン</h1>
	<form action="/hazelabBBS/login" method ="post">
		<div class="form-group">
			<label for="userId" >ユーザー名</label>
			<input class="form-control" type="text" name="userId" id="userId">
		</div>
		<div class="form-group">
			<label for="password">パスワード</label>
			<input class="form-control" type="password" name="password" id="password" >
		</div>
		<button class="btn btn-primary" type="submit">ログイン</button>
	</form>
</div>
<!-- javascript -->
<script type="text/javascript" src="/hazelabBBS/js/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="/hazelabBBS/js/bootstrap.min.js"></script>
</body>
</html>