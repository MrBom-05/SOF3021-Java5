<%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 3/12/2023
  Time: 8:40 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<h2 class="mt-3 text-center">Cập Nhật Sản Phẩm</h2>

<%--@elvariable id="sanPham" type="java"--%>
<form:form class="col-6 offset-3 mt-5 border p-4" method="POST"
           action="/admin/san-pham/update/${sanPham.id}" modelAttribute="sanPham" enctype="multipart/form-data">

    <div class="col-12">
        <label class="form-label">Mã<span class="text-danger">*</span></label>
        <form:input type="text" class="form-control" path="ma"/>
        <form:errors path="ma" cssClass="text-danger"></form:errors>
    </div>

    <div class="col-12 mt-3">
        <label class="form-label">Tên<span class="text-danger">*</span></label>
        <form:input type="text" class="form-control" path="ten"/>
        <form:errors path="ten" cssClass="text-danger"></form:errors>
    </div>

    <div class="col-12 mt-3">
        <label class="form-label">Ảnh<span class="text-danger">*</span></label>
        <form:input type="file" class="form-control" path="anh"/>
        <form:errors path="anh" cssClass="text-danger"></form:errors>
    </div>
    <div class="col-12 mt-5">
        <button class="btn btn-primary col-2 offset-5" type="submit">Update
        </button>
    </div>

</form:form>