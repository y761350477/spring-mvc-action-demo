<%--
  Created by IntelliJ IDEA.
  User: YC
  Date: 2018/4/17
  Time: 10:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>xml配置的spring-mvc</title>
</head>
<body>
<h1>This is a xml-spring-mvc demo!</h1><br>
<i>映射的方法可以返回对象或者集合的测试(这样的操作可以省去Model的传值步骤,效果是等价的):</i>
<b>${user.name}</b><br>
<i>ModelAndView的使用:</i>
<b>${param1}</b><br>
<i>@ModelAttribute无返回值的情况:</i>
<b>${modelAttribute1}</b><br>
<i>@ModelAttribute有返回值的情况:</i>
<b>${modelAttribute2}</b><br>
<i>@ModelAttribute为参数的情况:</i>
yc1:<b>${user.name}</b>
</body>
</html>
