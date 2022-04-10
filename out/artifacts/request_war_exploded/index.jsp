<%--
  Created by IntelliJ IDEA.
  User: hx
  Date: 2022/4/8
  Time: 21:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>
$END$<br>

<label>param1</label><br>
<form action="/request/param1" method="post">
    <input type="text" name="username"><br>
    <input type="password" name="password"><br>
    <input type="submit"><br>
</form>

<label>param2</label><br>
<form action="/request/param2" method="post">
    <input type="text" name="username"><br>
    <input type="password" name="password"><br>
    <input type="radio" name="gender" value="male">男
    <input type="radio" name="gender" value="female">女<br>
    <input type="checkbox" name="hobby" value="java">java
    <input type="checkbox" name="hobby" value="c++">c++
    <input type="checkbox" name="hobby" value="python">python<br>
    <input type="submit"><br>
</form>


<label>toBean1</label><br>
<form action="/request/toBean1" method="post">
    <input type="text" name="username"><br>
    <input type="password" name="password"><br>
    <input type="radio" name="gender" value="male">男
    <input type="radio" name="gender" value="female">女<br>
    <input type="checkbox" name="hobby" value="java">java
    <input type="checkbox" name="hobby" value="c++">c++
    <input type="checkbox" name="hobby" value="python">python<br>
    <input type="submit"><br>
</form>

<label>toBean2</label><br>
<form action="/request/toBean2" method="post">
    <input type="text" name="username"><br>
    <input type="password" name="password"><br>
    <input type="radio" name="gender" value="male">男
    <input type="radio" name="gender" value="female">女<br>
    <input type="checkbox" name="hobby" value="java">java
    <input type="checkbox" name="hobby" value="c++">c++
    <input type="checkbox" name="hobby" value="python">python<br>
    <input type="submit"><br>
</form>

<label>encoding</label><br>
<form action="encoding1" method="post">
    <input type="text" name="username"><br>
    <input type="password" name="password"><br>
    <input type="radio" name="gender" value="male">男
    <input type="radio" name="gender" value="female">女<br>
    <input type="checkbox" name="hobby" value="java">java
    <input type="checkbox" name="hobby" value="c++">c++
    <input type="checkbox" name="hobby" value="python">python<br>
    <input type="submit"><br>
</form>
</body>
</html>
