<%--
  Created by IntelliJ IDEA.
  User: mrbom
  Date: 18/06/2023
  Time: 10:03 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="f" uri="jakarta.tags.functions" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<span>${thongBao}</span>

<form method="post" action="/phieu-giam-gia/search">
    <label>Ngay Bat Dau</label>
    <input type="date" name="ngayBatDau">
    <label>Ngay Ket Thuc</label>
    <input type="date" name="ngayKetThuc">
    <label>Khach Hang</label>
    <select name="maKhachHang">
        <option value="">Tat Ca</option>
        <c:forEach items="${listKhachHang}" var="khachHang">
            <option value="${khachHang.id}">${khachHang.id}</option>
        </c:forEach>
    </select>
    <button type="submit">Search</button>
</form>


<table>
    <thead>
    <tr>
        <th>Ma</th>
        <th>Ten</th>
        <th>Ngay Bat Dau</th>
        <th>Ngay Ket Thuc</th>
        <th>Gia Tri Giam</th>
        <th>Trang Thai</th>
        <th>Ten Khach Hang</th>
        <th>Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${list.content}" var="phieuGiamGia">
        <tr>
            <td>${phieuGiamGia.maPhieu}</td>
            <td>${phieuGiamGia.tenPhieu}</td>
            <td>${phieuGiamGia.ngayBatDau}</td>
            <td>${phieuGiamGia.ngayKetThuc}</td>
            <td>${phieuGiamGia.giaTriGiam}</td>
            <td>${phieuGiamGia.trangThai == 1 ? "Dang hoai Dong" : "Ket Thuc"}</td>
            <td>${phieuGiamGia.nguoiSoHuu.tenKhachHang}</td>
            <td>
                <a href="/phieu-giam-gia/edit/${phieuGiamGia.maPhieu}">Edit</a>
                <a href="/phieu-giam-gia/delete/${phieuGiamGia.maPhieu}"
                   onclick="return confirm('Ban co muon xoa khong?')">Delete</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<nav>
    <ul>
        <c:forEach begin="0" end="${list.totalPages - 1}" var="i">
            <li>
                <a href="/phieu-giam-gia/hien-thi?page=${i}">${i}</a>
            </li>
        </c:forEach>
    </ul>
</nav>

</body>
</html>
