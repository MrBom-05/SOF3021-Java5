<%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 3/12/2023
  Time: 8:39 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="f" uri="jakarta.tags.functions" %>


<h2 class="mt-3">Quản Lý Cửa Hàng</h2>

<a href="/Assignment_war_exploded/admin/cua-hang/create" class="btn btn-success mt-3">Add</a>
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
                    <a href="/admin/cua-hang/update/${ cuaHang.id }" class="btn btn-primary">Update</a>
                    <a href="/admin/cua-hang/delete/${ cuaHang.id }" class="btn btn-danger"
                       onclick="return confirm('Bạn có muốn xóa không ?')">Delete</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</c:if>

