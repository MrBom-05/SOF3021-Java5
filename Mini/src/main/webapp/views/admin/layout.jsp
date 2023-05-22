<%--
  Created by IntelliJ IDEA.
  User: mrbom
  Date: 21/05/2023
  Time: 10:37 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Admin</title>
    <link rel="stylesheet" href="../css/bootstrap.min.css"/>
</head>
<body class="row">
<div class="col-2 bg-dark">
    <ul class="list-group mt-5 ms-2">
        <a class="list-group-item" href="/cua-hang/index">Cửa Hàng</a>
        <a class="list-group-item">Nhân Viên</a>
        <a class="list-group-item">Khách Hàng</a>
        <a class="list-group-item">Chức Vụ</a>
        <a class="list-group-item">Sản Phẩm</a>
    </ul>
</div>
<div class="col-10">
    <jsp:include page="${ view }"/>
</div>
</body>
</html>
