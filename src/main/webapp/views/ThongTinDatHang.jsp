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
<link href="css/login.css" rel="stylesheet" type="text/css" />
<title>Thong tin dat hang</title>
<style type="text/css">

</style>
</head>
<body>
	<jsp:include page="Menu.jsp"></jsp:include>
	<div class="container mt-5 pt-5">
		<h2 class="mb-5">Thông tin đặt hàng</h2>

		<!-- Hiển thị thông tin khách hàng -->
		<h4>Thông tin khách hàng:</h4>
		<p>
			<strong>Tên:</strong> ${name}
		</p>
		<p>
			<strong>Email:</strong> ${email}
		</p>
		<p>
			<strong>Số điện thoại:</strong> ${phoneNumber}
		</p>
		<p>
			<strong>Địa chỉ:</strong> ${address}
		</p>

		<!-- Hiển thị danh sách sản phẩm đặt -->
		<h4>Danh sách sản phẩm đặt:</h4>
		<table class="table">
			<thead>
				<tr>
					<th scope="col">STT</th>
					<th scope="col">Tên sản phẩm</th>
					<th scope="col">Số lượng</th>
					<th scope="col">Đơn Giá</th>
					<th scope="col">Thành Tiền</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="item" items="${cartItems}" varStatus="loop">
					<tr>
						<td>${loop.index + 1}</td>
						<td>${item.productName}</td>
						<td>${item.quantity}</td>
						<td>${item.price}</td>
						<td>${item.price * item.quantity}</td>
					</tr>
				</c:forEach>

			</tbody>
		</table>
		<div class="row">
			<h4>Tổng giá phải trả: ${totalCartAmount} VND</h4>
			<form action="" method="post">
			<button class="btn mx-5" formaction="/confirmOrder">Xác nhận</button>
			</form>
			
		</div>

	</div>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
		integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
		crossorigin="anonymous"></script>
</body>
</html>