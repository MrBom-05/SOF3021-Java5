<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Admin</title>
    <link rel="stylesheet" href="/css/bootstrap.min.css"/>
</head>
<body class="row">
<div class="col-2 bg-dark">
    <ul class="list-group mt-5 ms-2">
        <a class="list-group-item" href="/admin/hoa-don/index">Hoá Đơn</a>
        <a class="list-group-item" href="/admin/chi-tiet-sp/index">Chi Tiết Sản Phẩm</a>
        <a class="list-group-item" href="/admin/san-pham/index">Sản Phẩm</a>
        <a class="list-group-item" href="/admin/mau-sac/index">Màu Sắc</a>
        <a class="list-group-item" href="/admin/dong-sp/index">Dòng Sản Phẩm</a>
        <a class="list-group-item" href="/admin/nsx/index">Nhà Sản Xuất</a>
        <a class="list-group-item" href="/admin/cua-hang/index">Cửa Hàng</a>
        <a class="list-group-item" href="/admin/nhan-vien/index">Nhân Viên</a>
        <a class="list-group-item" href="/admin/khach-hang/index">Khách Hàng</a>
        <a class="list-group-item" href="/admin/chuc-vu/index">Chức Vụ</a>
    </ul>
</div>
<div class="col-10">
    <div class="alert text-center mt-3">
        <p>${thongBao}</p>
    </div>
    <jsp:include page="${ view }"/>
</div>

<script src="/js/jquery.min.js"></script>
<script src="/js/bootstrap.min.js"></script>

</body>
</html>