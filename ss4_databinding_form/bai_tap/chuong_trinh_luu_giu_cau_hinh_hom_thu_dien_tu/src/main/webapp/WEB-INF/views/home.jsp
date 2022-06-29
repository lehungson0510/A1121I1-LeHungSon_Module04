<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 6/28/2022
  Time: 1:48 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form:form action="${pageContext.request.contextPath}/update" method="post" modelAttribute="boxEmail">
    <table>
        <tr>
            <td><form:label path="language">Languages</form:label></td>
            <td><form:select cssStyle="width: 250px" path="language" items="${language}"/></td>
        </tr>
        <tr>
            <td><form:label path="pageSize">Page Size </form:label></td>
            <td><form:label path="pageSize">Show</form:label>
                <form:select path="pageSize" items="${pageSize}"/>
                <form:label path="pageSize">emails per page</form:label></td>
        </tr>
        <tr>
            <td style="padding-right: 50px"><form:label path="spamFilter">Spam filter</form:label></td>
            <td><form:checkbox path="spamFilter"/>
                <form:label path="spamFilter">Enable spams filter</form:label></td>
        </tr>
        <tr>
            <td><form:label path="signature">Signature </form:label></td>
            <td><form:textarea cssStyle="width: 250px"  path="signature" rows="5"/></td>
        </tr>
        <tr>
            <td></td>
            <td><input type="submit" style="background-color:#4694b6" value="Update">
                <button type="button"><a href="/display">Cancel</a></button>
            </td>
        </tr>
    </table>
</form:form>
</body>
</html>
