<%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 3/21/2023
  Time: 11:18 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="f" uri="jakarta.tags.functions" %>

<div class="row text-center mt-4 mb-4">
    <h2>Tất cả sản phẩm</h2>
</div>

<div class="row me-3">
    <article class="col-12">
        <div class="row">
            <c:forEach var="chiTietSP" items="${list.content}">
                <div class="col-md-3 col-12">
                    <div class="card ms-3">
                        <img src="${chiTietSP.sanPham.anh}" class="card-img-top img-fluid" alt="...">
                        <div class="card-body text-center">
                            <a href="/product-detail/${chiTietSP.sanPham.id}"
                               class="card-text">${chiTietSP.sanPham.ten}</a>
                            <span class="card text fw-bold">$${chiTietSP.giaBan}</span>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>
    </article>
</div>

<nav aria-label="Page navigation example">
    <ul class="pagination justify-content-end">
        <c:forEach begin="0" end="${list.totalPages - 1}" varStatus="loop">
            <li class="page-item">
                <a class="page-link" href="/home?page=${loop.index}">
                        ${loop.index + 1}
                </a>
            </li>
        </c:forEach>
    </ul>
</nav>


