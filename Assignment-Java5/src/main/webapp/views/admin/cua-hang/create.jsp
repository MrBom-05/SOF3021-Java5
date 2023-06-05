<%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 3/12/2023
  Time: 8:40 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<h2 class="mt-3 text-center">${name} Cửa Hàng</h2>

<%--@elvariable id="cuaHang" type="java"--%>
<form:form class="col-8 offset-2 mt-5 border p-4" method="POST"
           action="${action}" modelAttribute="cuaHang">

    <div class="row">
        <div class="col-4">
            <div class="input-group mb-3">
                <span class="input-group-text">Mã</span>
                <form:input type="text" class="form-control" path="ma" readonly="true"/>
                <form:errors path="ma" cssClass="text-danger"></form:errors>
            </div>
        </div>

        <div class="col-8">
            <div class="input-group mb-3 col-6">
                <span class="input-group-text">Tên<span class="text-danger">*</span></span>
                <form:input type="text" class="form-control" path="ten"/>
                <div class="text-center mt-1">
                    <form:errors path="ten" cssClass="text-danger"></form:errors>
                </div>
            </div>
        </div>
    </div>

    <div class="input-group mb-3">
        <span class="input-group-text">Địa chỉ<span class="text-danger">*</span></span>
        <form:textarea class="form-control" aria-label="With textarea" path="diaChi"></form:textarea>
        <div class="text-center mt-1">
            <form:errors path="diaChi" cssClass="text-danger"></form:errors>
        </div>
    </div>

    <div class="row">
        <div class="col-8">
            <div class="input-group mb-3">
                <span class="input-group-text">Thành Phố<span class="text-danger">*</span></span>
                <form:input type="text" class="form-control" path="thanhPho"/>
                <div class="text-center mt-1">
                    <form:errors path="thanhPho" cssClass="text-danger"></form:errors>
                </div>
            </div>
        </div>

        <div class="col-4">
            <div class="input-group mb-3 col-6">
                <span class="input-group-text">Quốc Gia<span class="text-danger">*</span></span>
                <form:input type="text" class="form-control" path="quocGia"/>
                <div class="text-center mt-1">
                    <form:errors path="quocGia" cssClass="text-danger"></form:errors>
                </div>
            </div>
        </div>
    </div>

    <div class="col-12 mt-5">
        <button class="btn btn-primary col-2 offset-5" type="submit">${name}</button>
    </div>

</form:form>

