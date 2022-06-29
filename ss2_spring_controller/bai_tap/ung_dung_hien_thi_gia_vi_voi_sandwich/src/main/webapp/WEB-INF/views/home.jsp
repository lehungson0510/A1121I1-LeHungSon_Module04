<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 6/24/2022
  Time: 12:25 AM
  To change this template use File | Settings | File Templates.
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--Lettuce: rau diếp--%>
<%--tomato: cà chua--%>
<%--mustard: mù tạt--%>
<%--sprouts: giá--%>
<h1>Sandwich Condiments</h1>
<form action="/spice" method="post">
    <label>
        <input type="checkbox" name="spice" value="Lettuce">Lettuce
    </label>
    <label>
        <input type="checkbox" name="spice" value="Tomato">Tomato
    </label>
    <label>
        <input type="checkbox" name="spice" value="Mustard">Mustard
    </label>
    <label>
        <input type="checkbox" name="spice" value="Sprouts">Sprouts
    </label>
    <hr>
    <button type="submit">save</button>
</form>
    <h3>${spice}</h3>
</body>
</html>
