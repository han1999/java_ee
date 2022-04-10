<%--
  Created by IntelliJ IDEA.
  User: hx
  Date: 2022/4/10
  Time: 21:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>
$END$<br>
<form action="/upload/upload1" enctype="multipart/form-data" method="post">
    <input type="text" name="username"> <br>
    <input type="password" name="password"><br>
    <input type="file" name="image"><br>
    <input type="submit"><br>
</form>

<form action="/upload/upload2" enctype="multipart/form-data" method="post">
    <input type="text" name="username"> <br>
    <input type="password" name="password"><br>
    <input type="file" name="image"><br>
    <input type="submit"><br>
</form>
</body>
</html>
