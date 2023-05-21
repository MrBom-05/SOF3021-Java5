<%@ page contentType="text/html; charset=UTF8" language="java" %>
<html>
<head>
    <title>Create</title>
    <link rel="stylesheet" href="../css/bootstrap.min.css"/>

    <%@taglib prefix="springForm" uri="http://www.springframework.org/tags/form"%>
</head>
<body>
<h2 class="mt-3 text-center">Thêm Mới Cửa Hàng</h2>

<%--@elvariable id="cuaHang" type="java"--%>
<springForm:form class="col-6 offset-3 mt-5 border p-4" method="POST"
      action="/cua-hang/create" id="form" modelAttribute="cuaHang">

    <div class="row">
        <div class="col-4">
            <div class="input-group mb-3">
                <span class="input-group-text">Mã<span class="text-danger">*</span></span>
                <springForm:input type="text" class="form-control" required="" path="ma"/>
                <springForm:errors path="ma" cssClass="text-danger"/>
            </div>
        </div>

        <div class="col-8">
            <div class="input-group mb-3 col-6">
                <span class="input-group-text">Tên<span class="text-danger">*</span></span>
                <springForm:input type="text" class="form-control" required="" path="ten"/>
                <springForm:errors path="ten" cssClass="text-danger"/>
            </div>
        </div>
    </div>

    <div class="input-group mb-3">
        <span class="input-group-text">Địa chỉ<span class="text-danger">*</span></span>
        <springForm:textarea class="form-control" aria-label="With textarea" path="diaChi"></springForm:textarea>
        <springForm:errors path="diaChi" cssClass="text-danger"/>
    </div>

    <div class="row">
        <div class="col-8">
            <div class="input-group mb-3">
                <span class="input-group-text">Thành Phố<span class="text-danger">*</span></span>
                <springForm:input type="text" class="form-control" required="" path="thanhPho"/>
                <springForm:errors path="thanhPho" cssClass="text-danger"/>
            </div>
        </div>

        <div class="col-4">
            <div class="input-group mb-3 col-6">
                <span class="input-group-text">Quốc Gia<span class="text-danger">*</span></span>
                <springForm:input type="text" class="form-control" required="" path="quocGia"/>
                <springForm:errors path="quocGia" cssClass="text-danger"/>
            </div>
        </div>
    </div>

    <div class="col-12 mt-5">
        <button class="btn btn-primary col-2 offset-5" type="submit">Add</button>
    </div>

</springForm:form>


</body>
</html>


