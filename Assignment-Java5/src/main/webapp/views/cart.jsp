<%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 3/17/2023
  Time: 9:07 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="f" uri="jakarta.tags.functions" %>


<div>
    <div>
        <c:if test="${ f:length(list) == 0 }">
            <h4 class="text-center">Không có sản phẩm</h4>
        </c:if>
        <c:if test="${ f:length(list) != 0 }">
            <c:forEach var="ghct" items="${ list }" varStatus="status">
                <div class="card mb-2 border">
                    <div class="card-body">
                        <div class="row align-items-center">
                            <div class="col-1">
                                <img src="${ghct.sanPham.anh}" class="img-fluid d-flex" alt="Ảnh sản phẩm">
                            </div>
                            <div class="col-md-3 col-7">
                                <a href="/product-detail/${ghct.sanPham.id}"
                                   class="text-decoration-none text-black" scroll-to-top>${ghct.sanPham.ten}</a>
                            </div>
                            <div class="col-md-2 col-3">
                                <a class="text-decoration-none text-black">${ghct.mauSac.ten}</a>
                            </div>

                            <div class="col-md-1 col-2">
                                <span class="text-center text-truncate">$${ghct.giaBan}</span>
                            </div>

                            <div class="col-md-2 col-3">
                                <div class="input-group">
                                    <form method="POST"
                                          action="/cart-update/${ghct.id}">
                                        <div class="input-group">
                                            <button onclick="decrease('quantity-${ghct.id}')"
                                                    class="btn btn-success ms-2">-
                                            </button>
                                            <input type="number" class="form-control" id="quantity-${ghct.id}"
                                                   name="soLuong"
                                                   value="${ghct.soLuong}" readonly min="1">
                                            <button onclick="increase('quantity-${ghct.id}')"
                                                    class="btn btn-success">+
                                            </button>
                                        </div>
                                    </form>
                                </div>
                            </div>
                            <div class="col-md-1 col-2">
                                <span class="text-center text-truncate text-danger">$${ghct.giaBan * ghct.soLuong}</span>
                            </div>
                            <div class="col-md-1 col-2">
                                <a class="btn btn-danger border-1"
                                   href="/cart-delete/${ghct.id}" type="button">Xoá</a>
                                <a class="btn btn-success border-1 mt-1"
                                   href="/bill-add/${ghct.id}/${ghct.soLuong}"
                                   type="button">Mua</a>
                            </div>
                        </div>
                    </div>

                </div>
            </c:forEach>
        </c:if>

    </div>
    <div class="row">
        <a type="button" class="col-2 offset-9 btn text-white btn-success float-end"
           href="/bill-all">
            Mua hàng
        </a>
    </div>
</div>
<script>
    function increase(quantityId) {
        var quantity = document.getElementById(quantityId);
        quantity.value = parseInt(quantity.value) + 1;
    }

    function decrease(quantityId) {
        var quantity = document.getElementById(quantityId);
        if (quantity.value > 1) {
            quantity.value = parseInt(quantity.value) - 1;
        }
    }
</script>