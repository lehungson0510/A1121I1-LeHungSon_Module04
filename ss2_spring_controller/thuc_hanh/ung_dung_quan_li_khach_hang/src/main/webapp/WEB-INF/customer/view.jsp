<%--
  Created by IntelliJ IDEA.
  User: linht
  Date: 4/25/2022
  Time: 6:34 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Student detail</title>
</head>
<body>
    <h1>Student detail</h1>
    <table border="1">
        <tr>
            <td>ID</td>
            <td>${customer.id}</td>
        </tr>
        <tr>
            <td>Name</td>
            <td>${customer.name}</td>
        </tr>
        <tr>
            <td>Email</td>
            <td>${customer.email}</td>
        </tr>
        <tr>
            <td>Address</td>
            <td>${customer.address}</td>
        </tr>
    </table>
    <a href="${pageContext.request.contextPath}/customer/list">Back to list</a>
</body>
</html>
