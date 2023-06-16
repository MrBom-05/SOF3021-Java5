<%--
  Created by IntelliJ IDEA.
  User: mrbom
  Date: 17/06/2023
  Time: 12:23 AM
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

<form method="post" action="/khach-hang/search">
    <input type="text" name="search"/>
    <label>Hang Khach Hang</label>
    <select name="maHang">
        <c:forEach items="${listHangKhachHang}" var="hang">
            <option value="${hang.id}">${hang.id}</option>
        </c:forEach>
    </select>
    <button type="submit">Search</button>
</form>


<span>${thongBao}</span>

<form:form action="/khach-hang/add" method="post" modelAttribute="khachHang">
    <div>
        <label>Ten Khach Hang</label>
        <form:input type="text" path="tenKhachHang"/>
        <form:errors path="tenKhachHang" cssClass="error"/>
    </div>
    <div>
        <label>So Dien Thoai</label>
        <form:input type="number" path="soDienThoai"/>
        <form:errors path="soDienThoai" cssClass="error"/>
    </div>
    <div>
        <label>Gioi Tinh</label>
        <input type="checkbox" name="gioiTinh" checked value="true">
        <label>Nam</label>
        <input type="checkbox" name="gioiTinh" value="false">
        <label>Nu</label>
    </div>
    <div>
        <label>Hang Khach Hang</label>
        <form:select path="hangKhachHang" onchange="getTenHang(this)">
            <c:forEach items="${listHangKhachHang}" var="hang">
                <form:option value="${hang.id}">${hang.id}</form:option>
            </c:forEach>
        </form:select>
        <label>Ten Hang: <span id="tenHang"></span></label>
    </div>

    <button type="submit">Add</button>
</form:form>


<script>
    function getTenHang(selectElement) {
        var id = selectElement.value;
        var tenHang = document.getElementById("tenHang");

        <c:forEach items="${listHangKhachHang}" var="hang">
        if (id == ${hang.id}) {
            tenHang.innerHTML = "${hang.tenHang}";
        }
        </c:forEach>
    }
</script>

<table>
    <thead>
    <tr>
        <th>#</th>
        <th>Ten</th>
        <th>SDT</th>
        <th>Gioi Tinh</th>
        <th>Hang</th>
        <th>Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${list.content}" var="khachHang">
        <tr>
            <td>${khachHang.id}</td>
            <td>${khachHang.tenKhachHang}</td>
            <td>${khachHang.soDienThoai}</td>
            <td>${khachHang.gioiTinh == true ? "Nam" : "Nu"}</td>
            <td>${khachHang.hangKhachHang.tenHang}</td>
            <td>
                <a type="button" href="/khach-hang/delete/${khachHang.id}"
                   onclick="return confirm('Ban co muon xoa khong?')">Remove</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<nav>
    <ul>
        <c:forEach begin="0" end="${list.totalPages - 1}" var="i">
            <li><a href="/khach-hang/hien-thi?page=${i}">${i}</a></li>
        </c:forEach>
    </ul>
</nav>
</body>
</html>
