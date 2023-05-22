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
    <title>Create</title>
    <%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
</head>
<body>
<%--@elvariable id="khachHang" type="java"--%>
<form:form method="POST" action="/khach-hang/create" modelAttribute="khachHang">
    <div>
        <label>Ma</label>
        <form:input path="ma" type="text"/>
        <form:errors path="ma"/>
    </div>


    <div>
        <label>Ho</label>
        <form:input path="ho" type="text"/>
        <form:errors path="ho"/>
    </div>


    <div>
        <label>Ten Dem</label>
        <form:input path="tenDem" type="text"/>
        <form:errors path="tenDem"/>
    </div>

    <div>
        <label>Ten</label>
        <form:input path="ten" type="text"/>
        <form:errors path="ten"/>
    </div>

    <div>
        <label>Ngay Sinh</label>
        <form:input path="ngaySinh" type="date"/>
        <form:errors path="ngaySinh"/>
    </div>

    <div>
        <label>Dia Chi</label>
        <form:input path="diaChi" type="text"/>
        <form:errors path="diaChi"/>
    </div>

    <div>
        <label>Thanh Pho</label>
        <form:input path="thanhPho" type="text"/>
        <form:errors path="thanhPho"/>
    </div>

    <div>
        <label>Quoc Gia</label>
        <form:input path="quocGia" type="text"/>
        <form:errors path="quocGia"/>
    </div>

    <div>
        <label>SDT</label>
        <form:input path="sdt" type="text"/>
        <form:errors path="sdt"/>
    </div>

    <div>
        <label>Email</label>
        <form:input path="email" type="text"/>
        <form:errors path="email"/>
    </div>


    <button type="submit">Add</button>
</form:form>
</body>
</html>
