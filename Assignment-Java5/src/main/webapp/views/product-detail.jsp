<%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 3/17/2023
  Time: 9:06 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="f" uri="jakarta.tags.functions" %>


<div class="row">
    <div class="col-6">
        <img src="${chiTietSP.sanPham.anh}" alt="" height="500px" width="500px">
    </div>

    <div class="col-6 justify-content-center">

        <h3>${chiTietSP.sanPham.ten}</h3>
        <form novalidate method="POST"
              action="/cart-add/${chiTietSP.idChiTietSP}">
            <div class="input-group mb-5 mt-5">
                <p class="mt-1 fw-bold">Số lượng</p>

                <button onclick="decrease(event)" class="btn btn-success ms-2">-</button>
                <input type="number" class="form-control" id="quantity" name="soLuong" value="1" readonly min="1"
                       max="${chiTietSP.soLuong}">
                <button onclick="increase(event)" class="btn btn-success">+</button>

                <p class="mt-1 text-danger ms-5"> còn ${chiTietSP.soLuong} sản phẩm</p>
            </div>
            <h3 class="fw-bold mb-5 text-center">$${chiTietSP.giaBan}</h3>
            <div class="row">
                <button class="col-6 offset-3 btn text-white btn-success w-50" type="submit">
                    <img src="img/icons8-shopping-cart-30.png" class="img-fluid" alt="">
                    Thêm vào giỏ hàng
                </button>
            </div>
        </form>
    </div>
</div>

<script>
    function increase(event) {
        event.preventDefault();
        var quantity = document.getElementById("quantity");
        var currentValue = parseInt(quantity.value);
        var maxValue = parseInt(quantity.getAttribute("max"));
        if (currentValue < maxValue) {
            quantity.value = currentValue + 1;
        }
    }

    function decrease(event) {
        event.preventDefault();
        var quantity = document.getElementById("quantity");
        if (quantity.value > 1) {
            quantity.value = parseInt(quantity.value) - 1;
        }
    }
</script>