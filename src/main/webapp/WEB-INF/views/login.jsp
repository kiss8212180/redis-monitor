<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="/WEB-INF/jsp/taglib/taglibs.jsp" %>
<html>
<head>
    <title>login</title>
    <pubTag:resource/>
</head>
<body>
<h2>Login</h2>
<form method="post">
    <div><label>user:<input name="user" value="" type="text"></label></div>
    <div><label>password:<input name="passwd" type="password" value=""></label></div>
    <div><input type="submit"></div>
</form>
</body>
</html>
