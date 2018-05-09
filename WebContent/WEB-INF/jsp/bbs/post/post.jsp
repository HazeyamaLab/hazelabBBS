<%@page import="java.time.format.DateTimeFormatter"%>
<%@page import="java.util.ArrayList"%>
<%@ page import = "model.Post" %>
<%@ page import = "model.Bbs" %>
<%@ page import = "java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% List<Post> posts = (ArrayList<Post>)request.getAttribute("posts"); %>
<% Bbs bbs = (Bbs)request.getAttribute("bbs"); %>
<!DOCTYPE html >
<html>
<head>
<link rel="stylesheet" href="/hazelabBBS/css/bootstrap.min.css">
<link  rel="stylesheet" href="/hazelabBBS/font/css/open-iconic-bootstrap.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><%=bbs.getTitle() %></title>
</head>
<body>
<!-- ナビゲーションバー -->
<nav class="navbar navbar-dark bg-dark">
		<a class="navbar-brand" href="/hazelabBBS/bbs">HazeLabBBS</a>
		<ul class="navbar-nav mr-auto mt-2 mt-lg-0">
		</ul>
		<a class="btn btn-warning" href="/hazelabBBS/logout" >ログアウト</a>
</nav>
<br>
<!-- コンテンツ -->
<div class="container">
<h2 class="page-header"><%=bbs.getTitle() %></h2>
<hr>
<h4 class="page-header">新規投稿</h4>
<form action="/hazelabBBS/bbs/post" method="post" >
	<div class="form-group">
		<label for="title">投稿タイトル</label>
		<input class="formcontrol" type="text" name="title" id="title">
	</div>
	<div class="form-group">
		<label for="body">投稿内容</label>
		<textarea class="form-control" name="body" id="body" rows="5" cols="60"></textarea>
	</div>
	<div class="form-group">
		<input type="hidden" name="bbsId" value="<%=bbs.getBbsId() %>" >
		<button type="submit" class="btn btn-primary">投稿</button>
	</div>
</form>
<hr>
<% if(posts.size() > 0) { %>
<% for(Post post : posts){ %>
<div class="card">
	<div class="card-header">
		<%=post.getContributorId() %> さんの書き込み
	</div>
	<div class="card-body">
	<h5 class="card-title"><%=post.getTitle() %></h5>
	<hr>
	<p class="card-text">
	<%=post.getBody() %>
	</p>
	
	<div class="text-right">
		<a href="/hazelabBBS/bbs/post/update?id=<%=post.getPostId() %>" class="btn btn-secondary"><span class="oi oi-pencil">編集</span></a>
		<a href="/hazelabBBS/bbs/post/delete?id=<%=post.getPostId() %>&bbsId=<%=post.getBbsId() %>" class="btn btn-danger"><span class="oi oi-trash"></span></a>
	</div>
	
	</div>
</div>
<br>
<% } %>
<% }else{ %>
<div class="alert alert-warning">
	投稿はありません．
</div>
<% } %>
</div>
<!-- javascript -->
<script type="text/javascript" src="/hazelabBBS/js/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="/hazelabBBS/js/bootstrap.min.js"></script>
</body>
</body>
</html>