<%--
  Created by IntelliJ IDEA.
  User: mrbom
  Date: 21/05/2023
  Time: 10:37 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="f" uri="jakarta.tags.functions" %>
<html>
<head>
    <title>Admin</title>
</head>
<body>
<a type="button" href="/khach-hang/create">Add</a>


<table>
    <thead>
    <tr>
        <th>STT</th>
        <th>Ma</th>
        <th>Ho</th>
        <th>Ten Dem</th>
        <th>Ten</th>
        <th>Ngay Sinh</th>
        <th>Dia Chi</th>
        <th>Thanh Pho</th>
        <th>Quoc Gia</th>
        <th>SDT</th>
        <th>Email</th>
        <th>Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="khachHang" items="${list}" varStatus="status">
        <tr>
            <td>${status.index + 1}</td>
            <td>${khachHang.ma}</td>
            <td>${khachHang.ho}</td>
            <td>${khachHang.tenDem}</td>
            <td>${khachHang.ten}</td>
            <td>${khachHang.ngaySinh}</td>
            <td>${khachHang.diaChi}</td>
            <td>${khachHang.thanhPho}</td>
            <td>${khachHang.quocGia}</td>
            <td>${khachHang.sdt}</td>
            <td>${khachHang.email}</td>
            <td>
                <a type="button" href="/khach-hang/update?ma=${khachHang.ma}">Update</a>
                <a type="button" href="/khach-hang/delete?ma=${khachHang.ma}">Delete</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>

</body>
</html>
