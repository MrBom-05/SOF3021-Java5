<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="f" uri="jakarta.tags.functions" %>
<html>
<head>
    <title>Index</title>
    <link rel="stylesheet" href="../css/bootstrap.min.css"/>

</head>
<body class="col-10 offset-1">

<h2 class="mt-3">Quản Lý Cửa Hàng</h2>

<a href="/cua-hang/create" class="btn btn-success mt-3">Add</a>
<c:if test="${ f:length(list) == 0 }">
    <h4 class="text-center">Không có dữ liệu</h4>
</c:if>

<c:if test="${ f:length(list) != 0 }">
    <table class="table table-bordered mt-5">
        <thead>
        <tr>
            <th>STT</th>
            <th>Mã</th>
            <th>Tên</th>
            <th>Địa Chỉ</th>
            <th>Thành Phố</th>
            <th>Quốc Gia</th>
            <th class="col-2 text-center">Action</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="cuaHang" items="${ list }" varStatus="status">
            <tr>
                <td>${ status.index + 1 }</td>
                <td>${ cuaHang.ma }</td>
                <td>${ cuaHang.ten }</td>
                <td>${ cuaHang.diaChi }</td>
                <td>${ cuaHang.thanhPho }</td>
                <td>${ cuaHang.quocGia }</td>

                <td class="text-center">
                    <a href="/cua-hang/edit/${ cuaHang.ma }" class="btn btn-primary">Update</a>
                    <a href="/cua-hang/delete/${ cuaHang.ma }" class="btn btn-danger"
                       onclick="return confirm('Bạn có muốn xóa không ?')">Delete</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</c:if>

</body>
</html>

