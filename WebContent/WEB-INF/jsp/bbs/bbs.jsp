<%@page import="java.time.format.DateTimeFormatter"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "model.Bbs" %>
<%@ page import = "java.util.List" %>
<% List<Bbs> bbsList = (ArrayList<Bbs>)request.getAttribute("bbs"); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="ja">
<head>
<link rel="stylesheet" href="/hazelabBBS/css/bootstrap.min.css">
<link  rel="stylesheet" href="/hazelabBBS/font/css/open-iconic-bootstrap.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="container">
<h1 class="page-header">新規BBSの作成</h1>
	<form action="/hazelabBBS/bbs" method="post">
		<div class="form-group">
			<label for="title">掲示板タイトル</label>
			<input class="formcontrol" type="text" name="title" id="title">
		</div>
		<div class="form-group">
			<label for="description">説明</label>
			<textarea class="form-control" name="description" id="description" rows="3" cols="60"></textarea>
		</div>
		<div class="form-group">
			<button type="submit" class="btn btn-primary">投稿</button>
		</div>
	</form>
<h2>作成済みBBS:<%=bbsList.size() %>件</h2>
<hr>
	<% for(Bbs bbs : bbsList) { %>
	<div class="card border-secondary mb-3">
	<div class="card-header">
		<h4 class="panel-title"><a class="text-dark" href="/hazelabBBS/bbs/post?id=<%=bbs.getBbsId()%>"><%=bbs.getTitle() %></a>
		&nbsp;
		<a class="text-info" href="/hazelabBBS/bbs/update?id=<%=bbs.getBbsId() %>"><span class="oi oi-pencil"></span></a></h4>
	</div>
	<div class="card-body">
			<p><%=bbs.getDescription() %></p>
			<div class="text-right"><a class="btn btn-danger" href="/hazelabBBS/bbs/delete?id=<%=bbs.getBbsId() %>"><span class="oi oi-trash"></span></a></div>
	</div>
	<div class="card-fotter">
		<div class=text-right>作成日：<%=bbs.getCreatedAt().format(DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm")) %></div>
	</div>
	</div>
	<% } %>
</div>
<!-- javascript -->
<script type="text/javascript" src="/hazelabBBS/js/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="/hazelabBBS/js/bootstrap.min.js"></script>
</body>
</html>