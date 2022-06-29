<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 6/29/2022
  Time: 8:57 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table border="1px">
    <tr>
        <td>Họ tên</td>
        <td>${medicalForm.name}</td>
    </tr>
    <tr>
        <td>Năm sinh</td>
        <td>${medicalForm.birthday}</td>
    </tr>
    <tr>
        <td>Giới tính</td>
        <td>${medicalForm.gender}</td>
    </tr>
    <tr>
        <td>Quốc tịch</td>
        <td>${medicalForm.nationality}</td>
    </tr>
    <tr>
        <td>Số hộ chiếu hoặc số CMND hoặc giấy thông hành hợp pháp khác</td>
        <td>${medicalForm.idCard}</td>
    </tr>
    <tr>
        <td>Thông tin đi lại</td>
        <td>${medicalForm.travelInfo}</td>
    </tr>
    <tr>
        <td>Số hiệu phương tiện</td>
        <td>${medicalForm.numberVehicle}</td>
    </tr>
    <tr>
        <td>Số ghế</td>
        <td>${medicalForm.numberSeat}</td>
    </tr>
    <tr>
        <td>Thông tin đi lại</td>
        <td>${medicalForm.extraInfo}</td>
    </tr>
</table>
</body>
</html>
