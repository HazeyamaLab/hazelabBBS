<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "model.Post" %>
<% Post post = (Post)request.getAttribute("post"); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="/hazelabBBS/bbs/post/update" method="post">
<label>投稿タイトル</label>
	<br>
	<input type="text" name="title" value="<%=post.getTitle() %>">
	<br>
	<label>投稿内容</label>
	<br>
	<textarea name="body" rows="5" cols="60"><%=post.getBody() %></textarea>
	<br>
	<input type="submit" value="編集" >
	<input type="hidden" name="postId" value="<%=post.getPostId() %>">
	<input type="hidden" name="bbsId" value="<%=post.getBbsId() %>" >
</form>
</body>
</html>