<%--
  Created by IntelliJ IDEA.
  User: hx
  Date: 2022/4/14
  Time: 21:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>
$END$
<label>/cookie/login</label>
<form action="/session/cookie/login" method="post">
    <input type="text" name="username"><br>
    <input type="password" name="password"><br>
    <input type="submit"><br>
</form>

<label>/login</label>
<form action="/session/login" method="post">
    <input type="text" name="username"><br>
    <input type="password" name="password"><br>
    <input type="submit"><br>
</form>

<label>/user/*</label>
<form action="/session/user/login" method="post">
    <input type="text" name="username"><br>
    <input type="password" name="password"><br>
    <input type="submit"><br>
</form>
</body>
</html>
