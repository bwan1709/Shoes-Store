
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Home Page</title>
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script
	src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<!------ Include the above in your HEAD tag ------>
<link
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"
	rel="stylesheet"
	integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN"
	crossorigin="anonymous">
<link href="css/style.css" rel="stylesheet" type="text/css" />

<!-- Font Awesome -->
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.11.2/css/all.css" />
<!-- Google Fonts Roboto -->
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css2?family=Roboto:wght@300;400;500;700&display=swap" />
<!-- MDB -->
<link rel="stylesheet" href="css/mdb.min.css" />
<!-- Custom styles -->
<link rel="stylesheet" href="css/style.css" />

<!-- Roboto Font -->
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Roboto:100,300,400,500,700&display=swap">
Font Awesome
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.11.2/css/all.css">
Bootstrap core CSS
<link rel="stylesheet"
	href="https://mdbootstrap.com/previews/ecommerce-demo/css/bootstrap.min.css">
Material Design Bootstrap
<link rel="stylesheet"
	href="https://mdbootstrap.com/previews/ecommerce-demo/css/mdb-pro.min.css">
Material Design Bootstrap Ecommerce
<link rel="stylesheet"
	href="https://mdbootstrap.com/previews/ecommerce-demo/css/mdb.ecommerce.min.css">
<!-- Your custom styles (optional) -->
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<style>
/* Carousel styling */
#introCarousel, .carousel-inner, .carousel-item, .carousel-item.active {
	height: 100vh;
}

.carousel-item:nth-child(1) {
	background-image:
		url('https://file.hstatic.net/1000230642/file/banner__1__9831c8de62ca4121b4f3caa18164f352_master.jpg');
	background-repeat: no-repeat;
	background-size: 100% 100%;
	background-position: center center;
}

.carousel-item:nth-child(2) {
	background-image:
		url('https://file.hstatic.net/1000230642/file/web-top-banner_68b9a0c957374772bdf25d1d0f312b11_master.jpg');
	background-repeat: no-repeat;
	background-size: 100% 100%;
	background-position: center center;
}

.carousel-item:nth-child(3) {
	background-image:
		url('https://file.hstatic.net/1000230642/file/banner_central_opt_2_76f1c057c7dc43ee9c8a36c6bee9ac4d_master.jpg');
	background-repeat: no-repeat;
	background-size: 100% 100%;
	background-position: center center;
}

/* Height for devices larger than 576px */
@media ( min-width : 992px) {
	#introCarousel {
		margin-top: -58.59px;
	}
}

.navbar .nav-link {
	color: #fff !important;
}
</style>

</head>
<body class="skin-light" onload="loadAmountCart()">
	<jsp:include page="Menu.jsp"></jsp:include>



	<!-- Carousel wrapper -->
	<div id="introCarousel"
		class="carousel slide carousel-fade shadow-2-strong"
		data-mdb-ride="carousel" style="margin-top: 35px;">
		<!-- Indicators -->
		<ol class="carousel-indicators">
			<li data-mdb-target="#introCarousel" data-mdb-slide-to="0"
				class="active"></li>
			<li data-mdb-target="#introCarousel" data-mdb-slide-to="1"></li>
			<li data-mdb-target="#introCarousel" data-mdb-slide-to="2"></li>
		</ol>

		<!-- Inner -->
		<div class="carousel-inner">
			<!-- Single item -->
			<div class="carousel-item active"></div>

			<!-- Single item -->
			<div class="carousel-item"></div>

			<!-- Single item -->
			<div class="carousel-item"></div>
		</div>
		<!-- Inner -->

		<!-- Controls -->
		<a class="carousel-control-prev" href="#introCarousel" role="button"
			data-mdb-slide="prev"> <span class="carousel-control-prev-icon"
			aria-hidden="true"></span> <span class="sr-only">Previous</span>
		</a> <a class="carousel-control-next" href="#introCarousel" role="button"
			data-mdb-slide="next"> <span class="carousel-control-next-icon"
			aria-hidden="true"></span> <span class="sr-only">Next</span>
		</a>
	</div>
	<!-- Carousel wrapper -->



	<div class="card-group" style="margin-top: 50px;">
		<div class="card" style="border-style: none;">
			<img style="height: 55px; width: 64px; margin: auto;"
				src="https://thethaohaanh.com/files/news/1898/17-12-2018/giaohangtoanquoc_LUUlj2AV.png">
			<div class="card-body">
				<h5 class="card-title" style="text-align: center">GIAO HÀNG
					TOÀN QUỐC</h5>
				<p class="card-text" style="text-align: center">Vận chuyển khắp
					Việt Nam</p>
			</div>
		</div>
		<div class="card" style="border-style: none;">
			<img class="card-img-top"
				style="height: 55px; width: 64px; margin: auto;"
				src="https://voshop.vn/wp-content/uploads/2016/04/ThanhToanTaiNha.jpg"
				alt="Card image cap">
			<div class="card-body">
				<h5 class="card-title" style="text-align: center">THANH TOÁN
					KHI NHẬN HÀNG</h5>
				<p class="card-text" style="text-align: center">Nhận hàng tại
					nhà rồi thanh toán</p>
			</div>
		</div>
		<div class="card" style="border-style: none;">
			<img class="card-img-top"
				style="height: 55px; width: 64px; margin: auto;"
				src="https://png.pngtree.com/png-clipart/20210808/original/pngtree-warranty-line-icon-with-a-tick-png-image_6617095.jpg"
				alt="Card image cap">
			<div class="card-body">
				<h5 class="card-title" style="text-align: center">BẢO HÀNH DÀI
					HẠN</h5>
				<p class="card-text" style="text-align: center">Bảo hàng lên đến
					60 ngày</p>
			</div>
		</div>
		<div class="card" style="border-style: none;">
			<img class="card-img-top"
				style="height: 55px; width: 64px; margin: auto;"
				src="https://vcdn.tikicdn.com/assets/cms/doi-tra-de-dang/img/step-1.jpg"
				alt="Card image cap">
			<div class="card-body">
				<h5 class="card-title" style="text-align: center">ĐỔI HÀNG DỄ
					DÀNG</h5>
				<p class="card-text" style="text-align: center">Đổi hàng thoải
					mái trong 30 ngày</p>
			</div>
		</div>
	</div>


	<div class="container">
		<div class="row" style="margin-top: 25px">
			<h1 style="text-align: center; width: 100%" id="moiNhat">SẢN
				PHẨM MỚI NHẤT</h1>
			<div class="col-sm-12">
				<div id="contentMoiNhat" class="row">
					<c:forEach items="${listPrd}" var="o" varStatus="loop">
						<c:if test="${loop.index < 8}">
							<div class="col-12 col-md-6 col-lg-3">
								<div class="card">
									<div class="view zoom z-depth-2 rounded">
										<img class="img-fluid w-100" src="${o.image}"
											alt="Card image cap">
									</div>
									<div class="card-body">
										<h4 class="card-title show_txt">
											<a href="/single-product/${o.id}" title="View Product">${o.name}</a>
										</h4>
										<p class="card-text show_txt">${o.title}</p>
										<div class="row">
											<div  class="col">
												<p  class="btn btn-success btn-block">${o.price}$</p>
											</div>
										</div>
									</div>
								</div>
							</div>
						</c:if>
					</c:forEach>
				</div>
			</div>
		</div>
		<div class="row" style="margin-top: 50px">
			<div class="col-sm-12">
				<div id="content" class="row">
					<div class=" col-12 col-md-12 col-lg-6">
						<div class="card-body">
							<h4 class="card-title show_txt"
								style="text-align: center; font-size: 18pt; color: #b57b00;">Về
								chúng tôi</h4>
							<h2 class="card-title show_txt"
								style="text-align: center; font-size: 24pt;">Shoes Family</h2>
							<p style="text-align: center;">Uy tín lâu năm chuyên cung cấp
								giày thể thao sneaker nam, nữ hàng Replica 1:1 - Like Auth với
								chất lượng đảm bảo và giá tốt nhất tại Hà Nội, tpHCM.</p>
							<p>Bạn đang cần tìm một đôi giày thể thao sneaker đẹp và hợp
								thời trang và đang hot Trends đến từ các thương hiệu lớn nhưng
								lại không đủ hầu bao để sắm được hàng chính hãng? Hãy đến với
								ShoesFamily – nơi bạn thỏa lòng mong ước mà chỉ phải chi ra 1
								phần nhỏ so với dòng chính hãng ngoài store mà vẫn sắm cho mình
								được một đôi chất lượng từ rep 1:1 đến siêu cấp like auth.</p>
						</div>
					</div>
					<div class=" col-12 col-md-12 col-lg-6">
						<img class="card-img-top"
							src="https://res.cloudinary.com/dmubfrefi/image/private/s--Mu2IBWIv--/c_crop,h_3000,w_3000,x_0,y_0/c_scale,w_828/f_auto/q_auto/v1/dee-about-cms-prod-medias/0940d3bf-537a-4538-a6b9-dcb623bff939/2305-nike-3052-final-02-11.jpg?_a=BAACwmBs"
							alt="Card image cap">
					</div>
				</div>
			</div>
		</div>
	</div>

	<jsp:include page="Footer.jsp"></jsp:include>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>


	<!-- MDB -->
	<script type="text/javascript" src="js/mdb.min.js"></script>
	<!-- Custom scripts -->
	<script type="text/javascript" src="js/script.js"></script>

	<!-- SCRIPTS -->
	<!-- JQuery -->
	<script
		src="https://mdbootstrap.com/previews/ecommerce-demo/js/jquery-3.4.1.min.js"></script>
	<!-- Bootstrap tooltips -->
	<script type="text/javascript"
		src="https://mdbootstrap.com/previews/ecommerce-demo/js/popper.min.js"></script>
	<!-- Bootstrap core JavaScript -->
	<script type="text/javascript"
		src="https://mdbootstrap.com/previews/ecommerce-demo/js/bootstrap.js"></script>
	<!-- MDB core JavaScript -->
	<script type="text/javascript"
		src="https://mdbootstrap.com/previews/ecommerce-demo/js/mdb.min.js"></script>
	<!-- MDB Ecommerce JavaScript -->
	<script type="text/javascript"
		src="https://mdbootstrap.com/previews/ecommerce-demo/js/mdb.ecommerce.min.js"></script>
</body>
</html>

