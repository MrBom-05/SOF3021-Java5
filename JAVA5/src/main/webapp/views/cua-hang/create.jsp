<%@ page contentType="text/html; charset=UTF8" language="java" %>
<html>
<head>
    <title>Create</title>
    <link rel="stylesheet" href="../css/bootstrap.min.css"/>
</head>
<body>
<h2 class="mt-3 text-center">Thêm Mới Cửa Hàng</h2>

<form class="col-6 offset-3 mt-5 border p-4" novalidate method="POST"
      action="/cua-hang/store" id="form">

    <div class="row">
        <div class="col-4">
            <div class="input-group mb-3">
                <span class="input-group-text">Mã<span class="text-danger">*</span></span>
                <input type="text" class="form-control" name="ma" required onblur="validateRed(this)">
            </div>
        </div>

        <div class="col-8">
            <div class="input-group mb-3 col-6">
                <span class="input-group-text">Tên<span class="text-danger">*</span></span>
                <input type="text" class="form-control" name="ten" required onblur="validateRed(this)">
            </div>
        </div>
    </div>

    <div class="input-group mb-3">
        <span class="input-group-text">Địa chỉ<span class="text-danger">*</span></span>
        <textarea class="form-control" aria-label="With textarea" name="diaChi"></textarea>
    </div>

    <div class="row">
        <div class="col-8">
            <div class="input-group mb-3">
                <span class="input-group-text">Thành Phố<span class="text-danger">*</span></span>
                <input type="text" class="form-control" name="thanhPho" required onblur="validateRed(this)">
            </div>
        </div>

        <div class="col-4">
            <div class="input-group mb-3 col-6">
                <span class="input-group-text">Quốc Gia<span class="text-danger">*</span></span>
                <input type="text" class="form-control" name="quocGia" required onblur="validateRed(this)">
            </div>
        </div>
    </div>

    <div class="col-12 mt-5">
        <button class="btn btn-primary col-2 offset-5" type="submit">Add</button>
    </div>

</form>


</body>
</html>


