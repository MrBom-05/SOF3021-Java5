<%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 3/12/2023
  Time: 8:40 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<h2 class="mt-3 text-center">Cập Nhật Khách Hàng</h2>

<%--@elvariable id="khachHang" type="java"--%>
<form:form class="row g-3 col-10 offset-1 mt-5 border p-4" method="POST"
           action="/admin/khach-hang/update/${khachHang.id}/${khachHang.ma}" modelAttribute="khachHang">

    <div class="col-md-4">
        <label class="form-label">Tên<span class="text-danger">*</span></label>
        <form:input type="text" class="form-control" path="ten"/>
        <form:errors path="ten" cssClass="text-danger"></form:errors>
    </div>
    <div class="col-md-4">
        <label class="form-label">Tên Đệm<span class="text-danger">*</span></label>
        <form:input type="text" class="form-control" path="tenDem"/>
        <form:errors path="tenDem" cssClass="text-danger"></form:errors>
    </div>
    <div class="col-md-4">
        <label class="form-label">Họ<span class="text-danger">*</span></label>
        <form:input type="text" class="form-control" path="ho"/>
        <form:errors path="ho" cssClass="text-danger"></form:errors>
    </div>
    <div class="col-md-4">
        <label class="form-label">Ngày Sinh<span class="text-danger">*</span></label>
        <form:input type="date" class="form-control" name="ngaySinh" path="ngaySinh"/>
        <form:errors path="ngaySinh" cssClass="text-danger"></form:errors>
    </div>
    <div class="col-md-4">
        <label class="form-label">SDT<span class="text-danger">*</span></label>
        <form:input type="number" class="form-control" path="sdt"/>
        <form:errors path="sdt" cssClass="text-danger"></form:errors>
    </div>
    <div class="col-md-4">
        <label class="form-label">Email<span class="text-danger">*</span></label>
        <form:input type="text" class="form-control" path="email"/>
        <form:errors path="email" cssClass="text-danger"></form:errors>
    </div>
    <div class="col-md-4">
        <label class="form-label">Địa Chỉ<span class="text-danger">*</span></label>
        <form:input type="text" class="form-control" path="diaChi"/>
        <form:errors path="diaChi" cssClass="text-danger"></form:errors>
    </div>
    <div class="col-md-4">
        <label class="form-label">Thành Phố<span class="text-danger">*</span></label>
        <form:input type="text" class="form-control" path="thanhPho"/>
        <form:errors path="thanhPho" cssClass="text-danger"></form:errors>
    </div>
    <div class="col-md-4">
        <label class="form-label">Quốc Gia<span class="text-danger">*</span></label>
        <form:input type="text" class="form-control" path="quocGia"/>
        <form:errors path="quocGia" cssClass="text-danger"></form:errors>
    </div>

    <div class="col-md-6 offset-3">
        <label class="form-label">Mật Khẩu<span class="text-danger">*</span></label>
        <form:input type="password" class="form-control" path="matKhau"/>
        <form:errors path="matKhau" cssClass="text-danger"></form:errors>
    </div>
    <div class="col-12 mt-5">
        <button class="btn btn-primary col-2 offset-5" type="submit">Add
        </button>
    </div>

</form:form>