<%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 3/12/2023
  Time: 8:40 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<h2 class="mt-3 text-center">${name} Khách Hàng</h2>

<%--@elvariable id="khachHang" type="java"--%>
<form:form class="row g-3 col-10 offset-1 mt-5 border p-4" method="POST"
           action="${action}" modelAttribute="khachHang">

    <div class="col-md-4">
        <label class="form-label">Tên<span class="text-danger">*</span></label>
        <form:input type="text" class="form-control" path="ten"/>
        <div class="text-center">
            <form:errors path="ten" cssClass="text-danger"></form:errors>
        </div>
    </div>
    <div class="col-md-4">
        <label class="form-label">Tên Đệm<span class="text-danger">*</span></label>
        <form:input type="text" class="form-control" path="tenDem"/>
        <div class="text-center">
            <form:errors path="tenDem" cssClass="text-danger"></form:errors>
        </div>
    </div>
    <div class="col-md-4">
        <label class="form-label">Họ<span class="text-danger">*</span></label>
        <form:input type="text" class="form-control" path="ho"/>
        <div class="text-center">
            <form:errors path="ho" cssClass="text-danger"></form:errors>
        </div>
    </div>
    <div class="col-md-4">
        <label class="form-label">Ngày Sinh<span class="text-danger">*</span></label>
        <form:input type="date" class="form-control" name="ngaySinh" path="ngaySinh"/>
        <div class="text-center">
            <form:errors path="ngaySinh" cssClass="text-danger"></form:errors>
        </div>
    </div>
    <div class="col-md-4">
        <label class="form-label">SDT<span class="text-danger">*</span></label>
        <form:input type="number" class="form-control" path="sdt"/>
        <div class="text-center">
            <form:errors path="sdt" cssClass="text-danger"></form:errors>
        </div>
    </div>
    <div class="col-md-4">
        <label class="form-label">Email<span class="text-danger">*</span></label>
        <form:input type="text" class="form-control" path="email"/>
        <div class="text-center">
            <form:errors path="email" cssClass="text-danger"></form:errors>
        </div>
    </div>
    <div class="col-md-4">
        <label class="form-label">Địa Chỉ<span class="text-danger">*</span></label>
        <form:input type="text" class="form-control" path="diaChi"/>
        <div class="text-center">
            <form:errors path="diaChi" cssClass="text-danger"></form:errors>
        </div>
    </div>
    <div class="col-md-4">
        <label class="form-label">Thành Phố<span class="text-danger">*</span></label>
        <form:input type="text" class="form-control" path="thanhPho"/>
        <div class="text-center">
            <form:errors path="thanhPho" cssClass="text-danger"></form:errors>
        </div>
    </div>
    <div class="col-md-4">
        <label class="form-label">Quốc Gia<span class="text-danger">*</span></label>
        <form:input type="text" class="form-control" path="quocGia"/>
        <div class="text-center">
            <form:errors path="quocGia" cssClass="text-danger"></form:errors>
        </div>
    </div>

    <div class="col-md-6 offset-3">
        <label class="form-label">Mật Khẩu<span class="text-danger">*</span></label>
        <form:input type="password" class="form-control" path="matKhau"/>
        <div class="text-center">
            <form:errors path="matKhau" cssClass="text-danger"></form:errors>
        </div>
    </div>
    <div class="col-12 mt-5">
        <button class="btn btn-primary col-2 offset-5" type="submit">${name}
        </button>
    </div>

</form:form>


