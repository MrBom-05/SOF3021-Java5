<%--
  Created by IntelliJ IDEA.
  User: mrbom
  Date: 18/06/2023
  Time: 10:11 PM
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

<%--@elvariable id="phieuGiamGia" type="java"--%>
<form:form action="/phieu-giam-gia/update/${phieuGiamGia.maPhieu}" method="post" modelAttribute="phieuGiamGia">

    <div>
        <label>Ten</label>
        <form:input path="tenPhieu" type="text"/>
        <form:errors path="tenPhieu"/>
        <label>Gia Tri Giam</label>
        <form:input path="giaTriGiam" type="number"/>
        <form:errors path="giaTriGiam"/>
        <label>Gia Tri Toi Da</label>
        <form:input path="giaTriGiamToiDa" type="number"/>
        <form:errors path="giaTriGiamToiDa"/>
    </div>
    <div>
        <label>Ngay Bat Dau</label>
        <form:input path="ngayBatDau" type="date"/>
        <form:errors path="ngayBatDau"/>
        <label>Ngay Ket Thuc</label>
        <form:input path="ngayKetThuc" type="date"/>
        <form:errors path="ngayKetThuc"/>
    </div>
    <div>
        <label>Khach Hang</label>
        <form:select path="nguoiSoHuu" onchange="getTenKhachHang(this)">
            <option value="null" label="Chon Khach Hang"/>
            <c:forEach items="${listKhachHang}" var="khachHang">
                <option value="${khachHang.id}" ${phieuGiamGia.nguoiSoHuu.id == khachHang.id ? "selected" : ""}>${khachHang.id}</option>
            </c:forEach>
        </form:select>
        <form:errors path="nguoiSoHuu"/>
        <label>Ten Khach Hang: <span id="tenKhachHang"></span></label>
    </div>
    <button type="submit">Update</button>
</form:form>

<script>
    function getTenKhachHang(selectElement) {
        var id = selectElement.value;
        var tenKhachHang = document.getElementById("tenKhachHang");
        <c:forEach items="${listKhachHang}" var="khachHang">
        if (id == ${khachHang.id}) {
            tenKhachHang.innerHTML = "${khachHang.tenKhachHang}";
        }
        </c:forEach>
    }
</script>

</body>
</html>
