<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Edit</title>
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/icon?family=Material+Icons">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link href="css/manager.css" rel="stylesheet" type="text/css" />
<style>
img {
	width: 200px;
	height: 120px;
}
</style>
</head>
<body>
	<div class="container">
		<div class="table-wrapper">
			<div class="table-title">
				<div class="row">
					<div class="col-sm-6">
						<h2>
							Sửa <b>Sản phẩm</b>
						</h2>
					</div>
					<div class="col-sm-6"></div>
				</div>
			</div>
		</div>
		<div id="editEmployeeModal">
			<div class="modal-dialog">
				<div class="modal-content">
					<form
						action="${pageContext.request.contextPath}/admin/updateProduct"
						method="post" modelAttribute="detail">
						<div class="modal-header">
							<h4 class="modal-title">Sửa Sản phẩm</h4>
							<button type="button" class="close" data-dismiss="modal"
								aria-hidden="true">&times;</button>
						</div>
						<div class="modal-body">
							<input type="hidden" name="id" value="${detail.id}" />
							<div class="form-group">
								<label>Tên</label> <input type="text" name="name"
									value="${detail.name}" class="form-control" required="true" />
							</div>
							<div class="form-group">
								<label>Hình ảnh</label> <input type="text" name="image"
									value="${detail.image}" class="form-control" />
							</div>
							<div class="form-group">
								<label>Hình ảnh 2</label> <input type="text" name="image2"
									value="${detail.image2}" class="form-control" />
							</div>
							<div class="form-group">
								<label>Hình ảnh 3</label> <input type="text" name="image3"
									value="${detail.image3}" class="form-control" />
							</div>
							<div class="form-group">
								<label>Hình ảnh 4</label> <input type="text" name="image4"
									value="${detail.image4}" class="form-control" />
							</div>
							<div class="form-group">
								<label>Giá</label> <input type="text" name="price"
									value="${detail.price}" class="form-control" />
							</div>
							<div class="form-group">
								<label>Tiêu đề</label>
								<textarea name="title" class="form-control" required="true">${detail.title}</textarea>
							</div>
							<div class="form-group">
								<label>Model</label>
								<textarea name="model" class="form-control" required="true">${detail.model}</textarea>
							</div>
							<div class="form-group">
								<label>Màu sắc</label>
								<textarea name="color" class="form-control" required="true">${detail.color}</textarea>
							</div>
							<div class="form-group">
								<label>Giao hàng</label>
								<textarea name="delivery" class="form-control" required="true">${detail.delivery}</textarea>
							</div>
							<div class="form-group">
								<label>Mô tả</label>
								<textarea name="description" class="form-control">${detail.description}</textarea>
							</div>
							<div class="form-group">
								<label>Danh mục</label> <select name="cateID"
									class="form-select" aria-label="Default select example">
									<c:forEach items="${listCC}" var="o">
										<option value="${o.cid}"
											${o.cid == detail.category.cid ? 'selected="selected"' : ''}>${o.cname}</option>
									</c:forEach>
								</select>
							</div>
						</div>
						<div class="modal-footer">
							<input type="submit" class="btn btn-success" value="Sửa">
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
	<script src="js/manager.js" type="text/javascript"></script>
</body>
</html>
