<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 6/20/2022
  Time: 10:44 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="bootstrap4.6.0/css/bootstrap.min.css">
    <script src="jquery/jquery-3.5.1.min.js"></script>
    <script src="bootstrap4.6.0/js/bootstrap.min.js"></script>
</head>
<body>
<form action="/convert" method="post" class="container w-50 mt-5 text-center">
    <h2 class="my-4">Convert USD to VND</h2>
    <div class="input-group">
        <div class="input-group-prepend">
            <span class="input-group-text">$</span>
        </div>
        <input required name="number" value="${number}" type="text" aria-label="First name" class="form-control">
        <input disabled type="text" aria-label="Last name" placeholder=" ${result} VNĐ" class="form-control">
        <button type="submit" class="btn btn-info">Convert</button>
    </div>
</form>

</body>
</html>
