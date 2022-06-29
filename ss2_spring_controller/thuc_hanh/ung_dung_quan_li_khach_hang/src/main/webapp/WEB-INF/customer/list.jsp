<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: linht
  Date: 4/22/2022
  Time: 6:11 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Display all customer</title>
</head>
<body>
    <h1>Display all customer</h1>
    <table border="1">
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Email</th>
            <th>Address</th>
            <th> <a href="${pageContext.request.contextPath}/customer/create">Create</a></th>
        </tr>
        <c:forEach items="${customer}" var="customer">
            <tr>
                <td>${customer.id}</td>
                <td>${customer.name}</td>
                <td>${customer.email}</td>
                <td>${customer.address}</td>
                <td>
                    <a href="${pageContext.request.contextPath}/customer/view/${customer.id}">View</a>
                    <a href="${pageContext.request.contextPath}/customer/delete/${customer.id}">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
