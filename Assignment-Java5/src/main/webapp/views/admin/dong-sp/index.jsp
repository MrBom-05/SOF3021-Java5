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


<h2 class="mt-3">Quản Lý Dòng Sản Phẩm</h2>

<a href="/admin/dong-sp/create" class="btn btn-success mt-3">Add</a>

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
            <th class="col-2 text-center">Action</th>
        </tr>
        </thead>
        <tbody>

        <c:forEach var="dongSP" items="${ list }" varStatus="status">
            <tr>
                <td>${status.index + 1}</td>
                <td>${ dongSP.ma }</td>
                <td>${ dongSP.ten }</td>

                <td class="text-center">
                    <a href="/admin/dong-sp/update/${ dongSP.id }"
                       class="btn btn-primary">Update</a>
                    <a href="/admin/dong-sp/delete/${ dongSP.id }"
                       class="btn btn-danger" onclick="return confirm('Bạn có muốn xóa không ?')">Delete</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</c:if>

