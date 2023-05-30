<%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 3/12/2023
  Time: 8:40 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<h2 class="mt-3 text-center">Cập Nhật Chức Vụ</h2>

<%--@elvariable id="chucVu" type="java"--%>
<form:form class="col-6 offset-3 mt-5 border p-4" method="POST"
           action="/admin/chuc-vu/update/${chucVu.id}" modelAttribute="chucVu">

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
    <div class="col-12 mt-5">
        <button class="btn btn-primary col-2 offset-5" type="submit">Update</button>
    </div>

</form:form>
