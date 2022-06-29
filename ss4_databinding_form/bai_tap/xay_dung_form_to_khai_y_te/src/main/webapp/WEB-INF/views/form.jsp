<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 6/29/2022
  Time: 6:02 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        span .red {
            color: red;
        }
        h3 h4{
            font-weight: bolder;
        }
        /*span::after {*/
        /*    clear: both;*/
        /*    content: "";*/
        /*}*/
    </style>
</head>
<body>
<center>
    <h3>TỜ KHAI Y TẾ</h3>
    <h3>ĐÂY LÀ TÀI LIỆU QUAN TRỌNG, THÔNG TIN CỦA ANH/CHỊ SẼ GIÚP CƠ QUAN Y TẾ LIÊN LẠC KHI CẦN THIẾT ĐỂ PHÒNG CHỐNG
        DỊCH BỆNH TRUYỀN NHIỄM</h3>
    <h4 style="color: red">Khuyến cáo: Khai báo thông tin sai là vi phạm pháp luật Việt Nam và có thể xử lí hình sự</h4>
</center>
<%--<a href="${pageContext.request.contextPath}/customer/list">Back to list</a>--%>
<form:form action="${pageContext.request.contextPath}/save" method="post" modelAttribute="medicalForm">
    <table style="width: 100%">
        <tr>
            <td colspan="6">Họ tên (ghi chữ IN HOA)<span class="red">(*)</span></td>
        </tr>
        <tr>
            <td colspan="6"><form:input cssStyle="width: 100%" path="name"/></td>
        </tr>
        <tr>
            <td colspan="2">Năm sinh<span class="red">(*)</span></td>
            <td colspan="2">Giới tính<span class="red">(*)</span></td>
            <td colspan="2">Quốc tịch<span class="red">(*)</span></td>
        </tr>
        <tr>
            <td colspan="2">
                <form:input cssStyle="width: 100%" path="birthday"/>
            </td>
            <td colspan="2">
                <form:select cssStyle="width: 100%" path="gender" items="${gender}"/>
            </td>
            <td colspan="2">
                <form:select cssStyle="width: 100%" path="nationality" items="${nationality}"/>
            </td>
        </tr>
        <tr>
            <td colspan="6">Số hộ chiếu hoặc số CMND hoặc giấy thông hành hợp pháp khác<span>(*)</span></td>
        </tr>
        <tr>
            <td colspan="6">
                <form:input cssStyle="width: 100%" path="idCard"/>
            </td>
        </tr>
        <tr>
            <td colspan="6">
                Thông tin đi lại<span class="red">(*)</span>
            </td>
        </tr>
        <tr>
            <td>
                <form:radiobuttons cssStyle="color: black"  path="travelInfo" items="${travelInfo}"/>
            </td>
        </tr>
        <tr>
            <td colspan="3">
                Số hiệu phương tiện<span class="red">(*)</span>
            </td>
            <td colspan="3">
                Số ghế<span>(*)</span>
            </td>
        </tr>
        <tr>
            <td colspan="3">
                <form:input cssStyle="width: 100%" path="numberVehicle"/>
            </td>
            <td colspan="3">
                <form:input cssStyle="width: 100%" path="numberSeat"/>
            </td>
        </tr>
        <tr>
            <td colspan="3">
                Ngày khởi hành<span class="red">(*)</span>
            </td>
            <td colspan="3">
                Ngày kết thúc<span class="red">(*)</span>
            </td>
        </tr>
        <tr>
            <td colspan="3">
                <form:input cssStyle="width: 100%" path="dateStart"/>
            </td>
            <td colspan="3">
                <form:input cssStyle="width: 100%" path="dateEnd"/>
            </td>
        </tr>
        <tr>
            <td colspan="6">
                Trong vòng 14 ngày qua, Anh/Chị có đến tỉnh thành phố nào?<span class="red">(*)</span>
            </td>
        </tr>
        <tr>
            <td colspan="6">
                <form:textarea cssStyle="width: 100%" rows="3" path="extraInfo"/>
            </td>
        </tr>
    </table>
    <center>
        <input style="text-align: center" type="submit" value="Gửi tờ khai"/>
    </center>
</form:form>
</body>
</html>
