<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 6/27/2022
  Time: 7:56 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Submitted Employee Information</h2>
<table>
    <tr>
        <td>Name:</td>
        <td>${employee.id}</td>
    </tr>
    <tr>
        <td>ID:</td>
        <td>${employee.name}</td>
    </tr>
    <tr>
        <td>Contact Number:</td>
        <td>${employee.contractNumber}</td>
    </tr>
</table>
</body>
</html>
