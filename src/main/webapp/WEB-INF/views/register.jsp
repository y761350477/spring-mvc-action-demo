<%--
  Created by IntelliJ IDEA.
  User: YC
  Date: 2018/4/18
  Time: 15:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册</title>
</head>
<body>
<form action="register" method="post" enctype="multipart/form-data">
    <input type="text" name="user" id="user"><br>
    <input type="password" name="pwd" id="pwd"><br>
    <input type="file" name="profilePicture" id="profilePicture"><br>
    <input type="submit" value="提交">
</form>
</body>
</html>
