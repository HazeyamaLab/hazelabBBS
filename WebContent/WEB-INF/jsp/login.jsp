<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="/hazelabBBS/css/bootstrap.min.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ログイン</title>
</head>
<body>
<div class="container">
	<h1>ログイン</h1>
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
		<p class="mt-5 mb-3 text-muted">&copy; Hazelab-2018</p>
	</form>
</div>
</body>
</html>