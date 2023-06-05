<%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 3/12/2023
  Time: 8:40 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<h2 class="mt-3 text-center">${name} Sản Phẩm</h2>

<%--@elvariable id="sanPham" type="java"--%>
<form:form class="col-8 offset-2 mt-5 border p-4" method="POST"
           action="${action}" modelAttribute="sanPham" enctype="multipart/form-data">

    <div class="row">
        <div class="col-7">
            <div class="col-12">
                <label class="form-label">Mã</label>
                <form:input type="text" class="form-control" path="ma" readonly="true"/>
                <form:errors path="ma" cssClass="text-danger"></form:errors>
            </div>

            <div class="col-12 mt-3">
                <label class="form-label">Tên<span class="text-danger">*</span></label>
                <form:input type="text" class="form-control" path="ten"/>
                <form:errors path="ten" cssClass="text-danger"></form:errors>
            </div>

            <div class="col-12 mt-3">
                <label class="form-label">Ảnh<span class="text-danger">*</span></label>
                <form:input type="file" class="form-control" path="anh" id="inputFile" accept="image/*"/>
                <form:errors path="anh" cssClass="text-danger"></form:errors>
            </div>
        </div>

        <div class="col-5 mt-3">
            <img id="previewImage" src="#" alt="Preview" width="250px" height="250px">
        </div>
    </div>


    <div class="col-12 mt-5">
        <button class="btn btn-primary col-2 offset-5" type="submit">${name}
        </button>
    </div>

</form:form>

<script>
    function readImage(input) {
        if (input.files && input.files[0]) {
            var reader = new FileReader();

            reader.onload = function (e) {
                // Hiển thị ảnh lên thẻ <img>
                document.getElementById('previewImage').src = e.target.result;
            };

            reader.readAsDataURL(input.files[0]);
        }
    }

    // Gán sự kiện cho input file
    document.getElementById('inputFile').addEventListener('change', function () {
        readImage(this);
    });

</script>

