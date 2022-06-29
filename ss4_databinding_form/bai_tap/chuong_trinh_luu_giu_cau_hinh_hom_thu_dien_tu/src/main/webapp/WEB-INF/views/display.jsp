<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 6/28/2022
  Time: 6:40 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table>
    <tr>
        <td>Language: </td>
        <td>${boxEmail.language} </td>
    </tr>
    <tr>
        <td>Page Size </td>
        <td>${boxEmail.pageSize} </td>
    </tr>
    <tr>
        <td>Spam Filter: </td>
        <td>${boxEmail.spamFilter} </td>
    </tr>
    <tr>
        <td>Signature: </td>
        <td>${boxEmail.signature} </td>
    </tr>
</table>
</body>
</html>
