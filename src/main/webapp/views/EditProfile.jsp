<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<link
    href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
    rel="stylesheet" id="bootstrap-css">
<script
    src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script
    src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<link rel="stylesheet"
    href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
    integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
    crossorigin="anonymous">
<link rel="stylesheet"
    href="https://use.fontawesome.com/releases/v5.3.1/css/all.css"
    integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU"
    crossorigin="anonymous">
<link href="css/login.css" rel="stylesheet" type="text/css" />
<title>Chỉnh Sửa Hồ Sơ</title>
</head>
<body>
<jsp:include page="Menu.jsp"></jsp:include>
<div id="logreg-forms" class="container mt-5 py-5">
    <form class="form-signin" action="editProfile" method="post">
        <h1 class="h3 mb-3 font-weight-normal" style="text-align: center">Chỉnh Sửa Hồ Sơ</h1>
        <c:if test="${not empty mess}">
            <p class="text-success">${mess}</p>
        </c:if>
        <c:if test="${not empty error}">
            <p class="text-danger">${error}</p>
        </c:if>
        <label for="username">Tên đăng nhập</label>
        <input name="username" type="text" id="username" class="form-control" value="${account.username}" required autofocus>
        <label for="password">Mật khẩu</label>
        <input name="password" type="password" id="password" class="form-control" value="${account.pass}" required>
        <label for="email">Email</label>
        <input name="email" type="text" id="email" class="form-control" value="${account.email}" required>
         <label for="address">Address</label>
        <input name="address" type="text" id="address" class="form-control" value="${account.address}" required>
         <label for="phoneNumber">Phone Number</label>
        <input name="phoneNumber" type="text" id="phoneNumber" class="form-control" value="${account.phoneNumber}" required>
        <button class="btn btn-success btn-block mb-4" type="submit"><i class="fas fa-sign-in-alt"></i> Chỉnh Sửa</button> 
    </form>
</div>

<script
    src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
    src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
    integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
    crossorigin="anonymous"></script>
<script>
    // Thêm mã JavaScript tại đây nếu cần
</script>
</body>
</html>
