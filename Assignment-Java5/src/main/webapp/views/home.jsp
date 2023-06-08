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
<html>
<head>
    <title>Home</title>
    <link rel="stylesheet" href="/css/bootstrap.min.css"/>
    <style>
        .card {
            border: none;
        }

        footer {
            background-color: #024137;
            color: white;
        }

        .shopping-cart {
            position: relative;
            display: inline-block;
            cursor: pointer;
        }

        .shopping-cart i {
            font-size: 2rem;
            color: blue;
        }

        .shopping-cart .cart-items {
            color: red;
            padding: 0.375rem 0.75rem;
            border-radius: 50%;
            position: absolute;
            top: -8px;
            right: -8px;
            font-size: 1.125rem;
        }

        .shopping-cart .cart-dropdown {
            position: absolute;
            top: 100%;
            right: 0;
            z-index: 1000;
            display: none;
            width: 250px;
            background-color: #fff;
            box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.1);
            padding: 1rem;
        }

        .shopping-cart:hover .cart-dropdown {
            display: block;
        }
    </style>
</head>
<body>

<div class="container">
    <!-- header -->
    <header class="d-flex align-items-center">
        <div class="col-2 mt-4">
            <img class="img-fluid" src="/img/logo_hear.png" alt="Logo">
        </div>
        <form class="ms-3 col-4 mt-4 d-flex" role="search">

            <input class="form-control me-2" type="search" placeholder="Tìm kiếm" aria-label="Search">
            <button class="btn btn-outline-primary" type="submit">
                <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-search"
                     viewBox="0 0 16 16">
                    <path d="M11.742 10.344a6.5 6.5 0 1 0-1.397 1.398h-.001c.03.04.062.078.098.115l3.85 3.85a1 1 0 0 0 1.415-1.414l-3.85-3.85a1.007 1.007 0 0 0-.115-.1zM12 6.5a5.5 5.5 0 1 1-11 0 5.5 5.5 0 0 1 11 0z"/>
                </svg>
            </button>

        </form>
        <nav class="navbar navbar-expand-lg bg-body-tertiary col-6 d-flex justify-content-end mt-4"
             ng-controller="login">
            <a class="nav-link active me-3" href="/sign-in">${nameUser}</a>
            <div class="dropdown">
                <a class="nav-link active me-3" aria-current="page"
                   href="/bill">Đơn Hàng</a>
            </div>
            <div class="shopping-cart d-flex align-items-center">
                <a href="/cart">
                    <img src="/img/icons8-shopping-cart-30.png" alt="Shopping cart">
                    <span class="cart-items ms-2">${index}</span>
                </a>
            </div>
        </nav>
    </header>
    <!-- Navbar -->
    <div class="row mt-3 mb-3 ms-3">
        <nav class="navbar navbar-expand-lg bg-body-tertiary">
            <div class="container-fluid col-12 ">
                <a class="navbar-brand col-2 fw-bold " href="/home">Trang chủ</a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse"
                        data-bs-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false"
                        aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
<%--                    <div class="navbar-nav col-12">--%>
<%--                        <a class="nav-link active col-2" aria-current="page" href="#product">Sản phẩm</a>--%>
<%--                        <a class="nav-link active col-3 " aria-current="page" href="#introduce">Giới thiệu cửa--%>
<%--                            hàng</a>--%>
<%--                        <a class="nav-link active" aria-current="page" href="#event">Sự kiện</a>--%>
<%--                    </div>--%>
                </div>
            </div>
        </nav>
    </div>

    <div>

        <jsp:include page="${ banner }"/>

        <div>
            <jsp:include page="${ view }"/>
        </div>

    </div>
</div>

<!-- Footer -->
<footer class="row mt-5 ">
    <div class="row">
        <div>
            <p class="mt-3 ms-5"><img src="/img/logo_foot.png" alt="innisfree"></p>
            <div class="row col-7 ms-4 ">
                <a href="#" class="facebook col-1">
                    <img src="/img/icons8-facebook-48.png" class="img-fluid" alt="">
                </a>
                <a href="#" class="instagram col-1">
                    <img src="/img/icons8-instagram-48.png" class="img-fluid" alt="">
                </a>
                <a href="#" class="youtube col-1">
                    <img src="/img/icons8-youtube-48.png" class="img-fluid " alt="">
                </a>
                <a href="#" class="zalo col-1">
                    <img src="/img/icons8-zalo-48.png" class="img-fluid " alt="">
                </a>
                <div class="float-end">
                    <p class="float-end">ⓒ 2020 innisfree Inc. <br>All rights reserved.</p>
                </div>
            </div>
            <hr>
            <ul class="row col-11 list-unstyled ms-4">
                <li class="col-3">
                    <a class="text-decoration-none  text-white fs-6">Chính sách giao hàng và
                        thanh toán</a>
                </li>
                <li class="col-3">
                    <a class="text-decoration-none text-white ">|</a>
                    <a href="" class="text-decoration-none background: text-white  ">Chính sách bảo mật thông tin
                        khách hàng</a>
                </li>
                <li class="col-2">
                    <a href="" class="text-decoration-none text-white ">|</a>
                    <a href="" class="text-decoration-none text-white">Chính sách mua hàng</a>
                </li>
                <li class="col-2">
                    <a class="text-decoration-none text-white ">|</a>
                    <a href="" class="text-decoration-none  text-white">Chính sách trả hàng</a>
                </li>
            </ul>
            <ul class="row list-unstyled ms-4">
                <li>
                    Thời gian làm việc
                    <span>: Thứ 2 ~ Thứ 6 09:00 ~ 17:00 (trừ Thứ 7, Chủ Nhật và ngày lễ)</span>
                </li>
                <li>
                    Tư vấn khách hàng
                    <a href="tel:02838279777" class="text-decoration-none text-white">: 028 3827 9777</a>
                </li>
                <li>
                    Email
                    <span><a href="mailto:cs_vn@innisfree.com" class="text-decoration-none text-white">:
                        cs_vn@innisfree.com</a></span>
                </li>
                <li>CÔNG TY TNHH AMOREPACIFIC VIỆT NAM</li>
                <li>GIẤY CNĐKDN: 0309984165 - Ngày cấp: 05/05/2010, được sửa đổi lần thứ 21, ngày 04/04/2022</li>
                <li>Địa chỉ đăng ký kinh doanh: Lầu 4A, Toà nhà Vincom, 72 Lê Thánh Tôn, Phường Bến Nghé, Quận 1,
                    Tp. Hồ Chí Minh, Việt Nam.
                </li>
            </ul>
        </div>
    </div>
</footer>

<script src="/js/bootstrap.min.js"></script>
<script src="/js/jquery.min.js"></script>
<script src="/js/popper.js"></script>
</body>
</html>
