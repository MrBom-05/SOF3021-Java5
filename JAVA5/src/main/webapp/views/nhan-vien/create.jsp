<%@ page contentType="text/html; charset=UTF8" language="java" %>
<html>
<head>
    <title>Create</title>
    <link rel="stylesheet" href="../css/bootstrap.min.css"/>

    <%@taglib prefix="springForm" uri="http://www.springframework.org/tags/form" %>
</head>
<body>
<h2 class="mt-3 text-center">Thêm Mới Nhân Viên</h2>

<%--@elvariable id="nhanVien" type="java"--%>
<springForm:form class="row g-3 col-10 offset-1 mt-3 border p-4" method="POST"
                 action="/nhan-vien/create" id="form" modelAttribute="nhanVien">

    <div class="col-md-4">
        <label class="form-label">Tên<span class="text-danger">*</span></label>
        <springForm:input type="text" class="form-control" name="ten" path="ten"/>
        <springForm:errors path="ten" cssClass="text-danger"/>
    </div>
    <div class="col-md-4">
        <label class="form-label">Tên Đệm<span class="text-danger">*</span></label>
        <springForm:input type="text" class="form-control" name="tenDem" path="tenDem"/>
        <springForm:errors path="tenDem" cssClass="text-danger"/>
    </div>
    <div class="col-md-4">
        <label class="form-label">Họ<span class="text-danger">*</span></label>
        <springForm:input type="text" class="form-control" name="ho" path="ho"/>
        <springForm:errors path="ho" cssClass="text-danger"/>
    </div>
    <div class="col-md-4">
        <label class="form-label">Ngày Sinh<span class="text-danger">*</span></label>
        <springForm:input type="date" class="form-control" name="ngaySinh" path="ngaySinh"/>
        <springForm:errors path="ngaySinh" cssClass="text-danger"/>
    </div>
    <div class="col-md-4">
        <label class="form-label">SDT<span class="text-danger">*</span></label>
        <springForm:input type="number" class="form-control" name="sdt" path="sdt"/>
        <springForm:errors path="sdt" cssClass="text-danger"/>
    </div>
    <div class="col-md-4">
        <label class="form-label">Email<span class="text-danger">*</span></label>
        <springForm:input type="text" class="form-control" name="email" path="email"/>
        <springForm:errors path="email" cssClass="text-danger"/>
    </div>
    <div class="col-md-4">
        <label class="form-label">Địa Chỉ<span class="text-danger">*</span></label>
        <springForm:input type="text" class="form-control" name="diaChi" path="diaChi"/>
        <springForm:errors path="diaChi" cssClass="text-danger"/>
    </div>
    <div class="col-md-4">
        <label class="form-label">Cửa Hàng<span class="text-danger">*</span></label>
        <springForm:select class="form-select" name="tenCuaHang" path="tenCuaHang">
            <springForm:option value="" disabled="true" selected="true">-- Chọn Của Hàng --</springForm:option>
            <springForm:option value="HaHa">HaHa</springForm:option>
        </springForm:select>
    </div>
    <div class="col-md-4">
        <label class="form-label">Chức Vụ<span class="text-danger">*</span></label>
        <springForm:select class="form-select" name="tenChucVu" path="tenChucVu">
            <springForm:option value="" disabled="true" selected="true">-- Chọn Chức Vụ --</springForm:option>
            <springForm:option value="Giá Đốc">Giám Đốc</springForm:option>
        </springForm:select>
    </div>

    <div class="col-md-4">
        <label class="form-label">Mật Khẩu<span class="text-danger">*</span></label>
        <springForm:input type="password" class="form-control" name="matKhau" path="matKhau"/>
        <springForm:errors path="matKhau" cssClass="text-danger"/>
    </div>

    <div class="col-md-4">
        <label class="form-label">Mã<span class="text-danger">*</span></label>
        <springForm:input type="text" class="form-control" name="ma" path="ma"/>
        <springForm:errors path="ma" cssClass="text-danger"/>
    </div>

    <div class="col-md-4">
        <label class="form-label">Giới Tính</label>
        <div class="row mt-1">
            <div class="form-check col-6">
                <input class="form-check-input ms-5" value="Nam" type="radio" name="gioiTinh" checked
                       required>
                <label class="form-check-label ms-2">Nam</label>
            </div>
            <div class="form-check col-6">
                <input class="form-check-input" value="Nữ" type="radio" name="gioiTinh" required>
                <label class="form-check-label">Nữ</label>
            </div>
        </div>
    </div>

    <div class="col-md-4 offset-4">
        <label class="form-label">Trạng Thái<span class="text-danger">*</span></label>
        <springForm:select class="form-select" name="trangThai" path="trangThai">
            <springForm:option value="false" disabled="true" selected="true">-- Chọn Trạng Thái --</springForm:option>
            <springForm:option value="1">Đang Làm</springForm:option>
            <springForm:option value="0">Đã Nghỉ</springForm:option>
        </springForm:select>
    </div>

    <div class="col-12 mt-5">
        <button class="btn btn-primary col-2 offset-5" type="submit">Add</button>
    </div>

</springForm:form>


</body>
</html>


