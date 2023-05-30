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
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<h2 class="mt-3 text-center">Thêm Mới Chi Tiết Sản Phẩm</h2>

<%--@elvariable id="chiTietSP" type="java"--%>
<form:form class="row g-3 col-10 offset-1 mt-3 border p-4" method="POST"
      action="/admin/chi-tiet-sp/create" modelAttribute="chiTietSP">

    <div class="col-md-6">
        <label class="form-label">Sản Phẩm<span class="text-danger">*</span></label>
        <form:select class="form-select" path="idSP">
            <option value="false" disabled selected>-- Chọn Sản Phẩm --</option>
            <c:forEach var="sanPham" items="${listSanPham}">
                <form:option value="${sanPham.id}">${sanPham.ten}</form:option>
            </c:forEach>
        </form:select>
    </div>
    <div class="col-md-6">
        <label class="form-label">Màu Sắc<span class="text-danger">*</span></label>
        <form:select class="form-select" path="idMauSac">
            <option value="false" disabled selected>-- Chọn Màu Sắc --</option>
            <c:forEach var="mauSac" items="${listMauSac}">
                <form:option value="${mauSac.id}">${mauSac.ten}</form:option>
            </c:forEach>
        </form:select>
    </div>

    <div class="col-md-6">
        <label class="form-label">Dòng SP<span class="text-danger">*</span></label>
        <form:select class="form-select" path="idDongSP">
            <option value="false" disabled selected>-- Chọn Dòng SP --</option>
            <c:forEach var="dongSP" items="${listDongSP}">
                <form:option value="${dongSP.id}">${dongSP.ten}</form:option>
            </c:forEach>
        </form:select>
    </div>
    <div class="col-md-6">
        <label class="form-label">Nhà Sản Xuất<span class="text-danger">*</span></label>
        <form:select class="form-select" name="idNSX" path="idNSX">
            <option value="false" disabled selected>-- Chọn Nhà Sản Xuất --</option>
            <c:forEach var="nsx" items="${listNSX}">
                <form:option value="${nsx.id}">${nsx.ten}</form:option>
            </c:forEach>
        </form:select>
    </div>
    <div class="col-md-3">
        <label class="form-label">Năm Sản Xuất<span class="text-danger">*</span></label>
        <form:input type="number" class="form-control" min="1"  path="namSX"/>
        <form:errors path="namSX" cssClass="text-danger"></form:errors>
    </div>
    <div class="col-md-3">
        <label class="form-label">Số Lượng<span class="text-danger">*</span></label>
        <form:input type="number" class="form-control" min="1" path="soLuongTon"/>
        <form:errors path="soLuongTon" cssClass="text-danger"></form:errors>
    </div>
    <div class="col-md-3">
        <label class="form-label">Giá Nhập<span class="text-danger">*</span></label>
        <form:input type="number" class="form-control" min="1" path="giaNhap"/>
        <form:errors path="giaNhap" cssClass="text-danger"></form:errors>
    </div>
    <div class="col-md-3">
        <label class="form-label">Giá Bán<span class="text-danger">*</span></label>
        <form:input type="number" class="form-control" min="1" path="giaBan"/>
        <form:errors path="giaBan" cssClass="text-danger"></form:errors>
    </div>

    <div class="col-12">
        <span class="form-label">Mô Tả<span class="text-danger">*</span></span>
        <form:textarea class="form-control" aria-label="With textarea" path="moTa"></form:textarea>
        <form:errors path="moTa" cssClass="text-danger"></form:errors>
    </div>


    <div class="col-12 mt-5">
        <button class="btn btn-primary col-2 offset-5" type="submit">Add</button>
    </div>

</form:form>

