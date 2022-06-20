<%--
  Created by IntelliJ IDEA.
  User: LENOVO PC
  Date: 6/20/2022
  Time: 8:25 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/name" method="post">
    <input type="text" name="name" placeholder="Enter name">
    <input type="submit" value="submit">
</form>
<h2>Hello ${text} </h2>
</body>
</html>
