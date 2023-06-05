<%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 3/12/2023
  Time: 8:40 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="f" uri="jakarta.tags.functions" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<h2 class="mt-3 text-center">${name} Nhân Viên</h2>

<%--@elvariable id="nhanVien" type="java"--%>
<form:form class="row g-3 col-10 offset-1 mt-3 border p-4" method="POST"
           action="${action}" modelAttribute="nhanVien">

    <div class="col-md-4">
        <label class="form-label">Tên<span class="text-danger">*</span></label>
        <form:input type="text" class="form-control" path="ten"/>
        <div class="text-center">
            <form:errors path="ten" cssClass="text-danger"/>
        </div>
    </div>
    <div class="col-md-4">
        <label class="form-label">Tên Đệm<span class="text-danger">*</span></label>
        <form:input type="text" class="form-control" path="tenDem"/>
        <div class="text-center">
            <form:errors path="tenDem" cssClass="text-danger"/>
        </div>
    </div>
    <div class="col-md-4">
        <label class="form-label">Họ<span class="text-danger">*</span></label>
        <form:input type="text" class="form-control" path="ho"/>
        <div class="text-center">
            <form:errors path="ho" cssClass="text-danger"/>
        </div>
    </div>
    <div class="col-md-4">
        <label class="form-label">Ngày Sinh<span class="text-danger">*</span></label>
        <form:input type="date" class="form-control" path="ngaySinh"/>
        <div class="text-center">
            <form:errors path="ngaySinh" cssClass="text-danger"/>
        </div>
    </div>
    <div class="col-md-4">
        <label class="form-label">SDT<span class="text-danger">*</span></label>
        <form:input type="number" class="form-control" path="sdt"/>
        <div class="text-center">
            <form:errors path="sdt" cssClass="text-danger"/>
        </div>
    </div>
    <div class="col-md-4">
        <label class="form-label">Email<span class="text-danger">*</span></label>
        <form:input type="text" class="form-control" path="email"/>
        <div class="text-center">
            <form:errors path="email" cssClass="text-danger"/>
        </div>
    </div>
    <div class="col-md-4">
        <label class="form-label">Địa Chỉ<span class="text-danger">*</span></label>
        <form:input type="text" class="form-control" path="diaChi"/>
        <div class="text-center">
            <form:errors path="diaChi" cssClass="text-danger"/>
        </div>
    </div>
    <div class="col-md-4">
        <label class="form-label">Cửa Hàng<span class="text-danger">*</span></label>
        <form:select class="form-select" path="cuaHang">
            <option value="false" disabled selected>-- Chọn Của Hàng --</option>
            <c:forEach var="cuaHang" items="${listCuaHang}">
                <option value="${cuaHang.id}" ${cuaHang.id == nhanVien.cuaHang.id ? "selected" : ""}>${cuaHang.ten}</option>
            </c:forEach>
        </form:select>
    </div>
    <div class="col-md-4">
        <label class="form-label">Chức Vụ<span class="text-danger">*</span></label>
        <form:select class="form-select" path="chucVu">
            <option value="false" disabled selected>-- Chọn Chức Vụ --</option>
            <c:forEach var="chucVu" items="${listChucVu}">
                <option value="${chucVu.id}" ${chucVu.id == nhanVien.chucVu.id ? "selected" : ""}>${chucVu.ten}</option>
            </c:forEach>
        </form:select>
    </div>

    <div class="col-md-4">
        <label class="form-label">Mật Khẩu<span class="text-danger">*</span></label>
        <form:input type="password" class="form-control" path="matKhau"/>
        <div class="text-center">
            <form:errors path="matKhau" cssClass="text-danger"/>
        </div>
    </div>

    <div class="col-md-4">
        <label class="form-label">Mã</label>
        <form:input type="text" class="form-control" path="ma" readonly="true"/>
        <div>
            <form:errors path="ma" cssClass="text-danger"/>
        </div>
    </div>

    <div class="col-md-4">
        <label class="form-label">Giới Tính</label>
        <div class="row mt-1">
            <div class="form-check col-6">
                <input ${nhanVien.gioiTinh == "Nam" ? "checked" : ""} class="form-check-input ms-5" value="Nam"
                                                                      type="radio" name="gioiTinh" checked
                                                                      required>
                <label class="form-check-label ms-2">Nam</label>
            </div>
            <div class="form-check col-6">
                <input ${nhanVien.gioiTinh == "Nữ" ? "checked" : ""} class="form-check-input" value="Nữ" type="radio"
                                                                     name="gioiTinh" required>
                <label class="form-check-label">Nữ</label>
            </div>
        </div>
    </div>

    <div class="col-md-4 offset-4">
        <label class="form-label">Trạng Thái<span class="text-danger">*</span></label>
        <form:select class="form-select" name="trangThai" path="trangThai">
            <option value="false" disabled selected>-- Chọn Trạng Thái --</option>
            <option value="1" ${nhanVien.trangThai == 1 ? "selected" : ""}>Đang Làm</option>
            <option value="0" ${nhanVien.trangThai == 0 ? "selected" : ""}>Đã Nghỉ</option>
        </form:select>
    </div>

    <div class="col-12 mt-5">
        <button class="btn btn-primary col-2 offset-5" type="submit">${name}</button>
    </div>

</form:form>


