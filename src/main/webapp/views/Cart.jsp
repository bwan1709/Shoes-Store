<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Giỏ Hàng</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<link rel="stylesheet" href="styles.css">
<style>
/* Custom CSS */
body {
	font-family: Arial, sans-serif;
}

.shopping-cart {
	padding: 50px 0;
}

.table-responsive {
	margin-top: 20px;
}

.table thead th {
	background-color: #f8f9fa;
	border-top: none;
}

.table tbody tr:hover {
	background-color: #f1f1f1;
}

.table img {
	width: 70px;
	height: auto;
}

.table .btnSub, .table .btnAdd {
	margin: 0 5px;
}

.btn-danger {
	background-color: #dc3545;
	border-color: #dc3545;
}

#contentTotalMoney {
	margin-top: 20px;
}

.btn-dark {
	background-color: #343a40;
	border-color: #343a40;
}

.btn-dark:hover {
	background-color: #23272b;
	border-color: #1d2124;
}

.totalAmount {
	font-size: 40px; /* Kích thước chữ */
	color: #333; /* Màu chữ */
	font-weight: bold; /* Độ đậm của chữ */
	text-align: right; /* Căn lề phải */
	/* Các thuộc tính CSS khác có thể được thêm vào tùy thuộc vào yêu cầu thiết kế của bạn */
}
</style>
</head>

<body>
	<jsp:include page="Menu.jsp"></jsp:include>
	<div class="shopping-cart">

		<div class="px-4 px-lg-0">
			<div class="pb-5">
				<div class="container-fluid">
					<div class="row">
						<div class="col-lg-12 p-5 bg-white rounded shadow-sm mb-5">
							<h5 class="text-secondary">
								Tổng sản phẩm trong giỏ hàng: <strong class="text-danger">${count}</strong>
							</h5>
							<!-- Shopping cart table -->
							<div class="table-responsive">
								<table class="table">
									<thead>
										<c:if test="${error!=null}">
											<div class="alert alert-danger" role="alert">${error}</div>
										</c:if>
										<c:if test="${mess!=null}">
											<div class="alert alert-success" role="alert">${mess}</div>
										</c:if>
										<tr>
											<th scope="col" class="border-0 bg-light">
												<div class="py-2 text-uppercase">Hình ảnh</div>
											</th>
											<th scope="col" class="border-0 bg-light">
												<div class="py-2 text-uppercase">Tên Sản Phẩm</div>
											</th>
											<th scope="col" class="border-0 bg-light">
												<div class="py-2 text-uppercase">Đơn Giá</div>
											</th>
											<th scope="col" class="border-0 bg-light">
												<div class="py-2 text-uppercase">Màu Sắc</div>
											</th>
											<th scope="col" class="border-0 bg-light">
												<div class="py-2 text-uppercase">Phân phối</div>
											</th>
											<th scope="col" class="border-0 bg-light">
												<div class="py-2 text-uppercase">Kích Thước</div>
											</th>
											<th scope="col" class="border-0 bg-light">
												<div class="py-2 text-uppercase">Số Lượng</div>
											</th>
											<th scope="col" class="border-0 bg-light">
												<div class="py-2 text-uppercase">Tổng Tiền</div>
											</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach items="${listCart}" var="o">
											<c:forEach items="${listProduct}" var="p">
												<c:if test="${o.product.id == p.id}">
													<tr>
														<th scope="row">
															<div class="p-2">
																<img src="${p.image}" alt=""
																	class="img-fluid rounded shadow-sm">

															</div>
														</th>
														<td class="align-middle"><strong>${p.name}$</strong></td>
														<td class="align-middle"><strong>${p.price}$</strong></td>
														<td class="align-middle"><strong>${p.color}</strong></td>
														<td class="align-middle"><strong>${p.delivery}</strong></td>
														<td class="align-middle"><strong>${o.size}</strong></td>
														<td class="align-middle"><a
															href="subAmountCart?productID=${o.product.id}&amount=${o.amount}&size=${o.size}">
																<button class="btn btn-sm btn-outline-secondary btnSub">-</button>
														</a> <strong>${o.amount}</strong> <a
															href="addAmountCart?productID=${o.product.id}&amount=${o.amount}&size=${o.size}">
																<button class="btn btn-sm btn-outline-secondary btnAdd">+</button>
														</a></td>

														<td class="align-middle"><strong>${o.total}$</strong></td>
														<td class="align-middle"><a
															href="deleteCart?productID=${o.product.id}&size=${o.size}"
															class="text-dark">
																<button type="button" class="btn btn-danger btn-sm">X</button>
														</a></td>

													</tr>
												</c:if>
											</c:forEach>
										</c:forEach>
									</tbody>
								</table>
							</div>
							<!-- End -->
						</div>
					</div>

					<div class="row  bg-white rounded shadow-sm">
						<div class="col-lg-6">
							<div
								class="bg-light rounded-pill px-4 py-3 text-uppercase font-weight-bold">Thành
								tiền</div>
							<div class="p-4">
								<span class="totalAmount">${totalCartAmount} VND</span> <a
									href="/order"
									class="btn btn-dark rounded-pill py-2 btn-block text-white">Thanh
									Toán</a>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
		integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
		integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7HUIbX39j7fakFPskvXusvfa0b4Q"
		crossorigin="anonymous"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
		integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
		crossorigin="anonymous"></script>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</body>
</html>
