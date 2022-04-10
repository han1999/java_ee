<%--
  Created by IntelliJ IDEA.
  User: hx
  Date: 2022/4/9
  Time: 19:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>
$END$<br>

<label>login</label><br>
<form action="/response/login" method="post">
    <input type="text" name="username"><br>
    <input type="password" name="password"><br>
    <input type="submit"><br>
</form>
<br>
<a href="/response/1.JPG">直接访问1.JPG</a><br>
<a href="/response/stream">通过servlet访问1.JPG</a><br>
<a href="/response/down">下载1.JPG</a><br>
<a href="/response/pic?op=view">pic?op=view</a><br>
<a href="/response/pic?op=down">pic?op=down</a><br>
<a href="/response/pic/view">pic/view</a><br>
<a href="/response/pic/down">pic/down</a><br>

</body>
</html>
