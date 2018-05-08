<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "model.Bbs" %>
<% Bbs bbs = (Bbs)request.getAttribute("bbs"); %>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>編集</title>
</head>
<body>
<form action="/hazelabBBS/bbs/update" method="post">
	<input type="text" name="bbsTitle" value="<%=bbs.getTitle() %>" />
	<textarea name="description" rows="5" cols="60"><%=bbs.getDescription() %></textarea>
	<input type="hidden" name="bbsId" value="<%=bbs.getBbsId() %>" >
	<input type="submit" value="編集">
</form>
</body>
</html>