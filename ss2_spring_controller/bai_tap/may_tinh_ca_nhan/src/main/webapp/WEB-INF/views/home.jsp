<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 6/24/2022
  Time: 1:10 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Calculator</h1>
<form action="/calculator" method="post">
    <div style="margin-bottom: 10px">
        <input required placeholder="${number1}" type="text" name="num1">
        <input required placeholder="${number2}" type="text" name="num2">
    </div>
    <button name="calculation" type="submit" value="+">Addition(+)</button>
    <button name="calculation" type="submit" value="-">Subtraction(-)</button>
    <button name="calculation" type="submit" value="*">Multiplication(X)</button>
    <button name="calculation" type="submit" value="/">Division(/)</button>
</form>
<%--<c:if test="${result != }"></c:if>--%>
<h3 style="color: red">${message}</h3>
<h3>${calculation} ${result}</h3>
<%--<c:if test="${!message.equals('Invalid')}">--%>
<%--    <h3>${calculation} ${result}</h3>--%>
<%--</c:if>--%>
</body>
</html>
