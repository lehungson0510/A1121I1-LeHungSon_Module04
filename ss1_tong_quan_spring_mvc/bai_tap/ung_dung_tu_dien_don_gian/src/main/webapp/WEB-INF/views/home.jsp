<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 6/20/2022
  Time: 11:37 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="bootstrap4.6.0/css/bootstrap.min.css">
    <script src="jquery/jquery-3.5.1.min.js"></script>
    <script src="bootstrap4.6.0/js/bootstrap.min.js"></script>
</head>
<body>
<form action="/translate" method="post" class="container w-50 mt-5 text-center">
    <h2 class="my-4">Translation</h2>
    <div class="input-group">
        <div class="input-group-prepend">
            <span class="input-group-text">English</span>
        </div>
        <input placeholder="${text}" name="text" type="text" aria-label="First name" class="form-control">
        <div class="input-group-prepend">
            <span class="input-group-text">Vietnamese</span>
        </div>
        <input disabled type="text" aria-label="Last name" placeholder=" ${result}" class="form-control bg-white">
        <button type="submit" class="btn btn-info">Translate</button>
    </div>
    <h3 class="text-danger">${mess}</h3>
</form>
</body>
</html>
