<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script
	src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<!------ Include the above in your HEAD tag ---------->

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
<title>Order</title>
<style>
#logreg-forms.container {
	width: 100%;
	padding-top: 40px;
	margin: auto;
	margin-top: 50px;
}

body {
	padding-top: 100px;
	background-color: #f8f9fa;
}
/* Định dạng form đăng ký */
.form-signin {
	width: 100%;
	max-width: 400px;
	padding: 15px;
	margin: 0 auto;
	background-color: #f1f1f1;
	border: 1px solid #ccc;
	border-radius: 5px;
}
/* Định dạng tiêu đề */
.form-signin h1 {
	margin-bottom: 30px;
}
/* Định dạng input */
.form-signin input[type="text"] {
	margin-bottom: 10px;
	border-radius: 5px;
}
/* Định dạng nút đặt hàng */
.form-signin button {
	margin-top: 20px;
	border-radius: 5px;
}
/* Định dạng alert */
.alert {
	margin-top: 20px;
}
</style>
</head>
<body>
	<jsp:include page="Menu.jsp"></jsp:include>
	<div id="logreg-forms" class="container">
		<form class="form-signin" action="/order" method="post">
			<h1 class="h3 mb-3 font-weight-normal" style="text-align: center">Order</h1>
			<c:if test="${error != null}">
				<div class="alert alert-danger" role="alert">${error}</div>
			</c:if>
			<c:if test="${mess != null}">
				<div class="alert alert-success" role="alert">${mess}</div>
			</c:if>
			<label for="name">Name</label> <input name="name" type="text"
				id="name" class="form-control"
				value="${acc != null ? acc.username : ''}"
				placeholder="Name" required> <label for="phoneNumber">Phone
				number</label> <input name="phoneNumber" type="text" id="phoneNumber"
				class="form-control"
				value="${acc != null ? acc.phoneNumber : ''}"
				placeholder="Phone number" required> <label for="email">Email</label>
			<input name="email" type="email" id="email" class="form-control"
				value="${acc != null ? acc.email : ''}" placeholder="Email"
				required> <label for="address">Delivery Address</label> <input
				name="address" type="text" id="deliveryAddress" class="form-control"
				value="${acc != null ? acc.address : ''}"
				placeholder="Delivery Address" required>

			<button class="btn btn-success btn-block" type="submit">
				<i class="fas fa-american-sign-language-interpreting"></i> Place
				Order
			</button>
		</form>
		<br>
	</div>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
		integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
		crossorigin="anonymous"></script>
</body>
</html>
