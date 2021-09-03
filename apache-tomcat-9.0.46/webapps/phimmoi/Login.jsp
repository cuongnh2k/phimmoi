<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html lang="vi-VN">
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css"
	integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l"
	crossorigin="anonymous">
<!-- Bootstrap JS -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
	integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-Piv4xVNRyMGpqkS2by6br4gNJ7DXjqk09RmUpJ8jgGtD7zP9yug3goQfGII0yAns"
	crossorigin="anonymous"></script>
<!-- Bootstrap ICON -->
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css">
<!-- font google -->
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Sofia">
<!-- jquery -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<title>Đăng nhập</title>
</head>

<style>
.khung {
	margin: auto;
	margin-top: 200px;
}

@media screen and (max-width: 500px) {
	.khung {
		margin-top: 150px;
	}
}

@media screen and (max-width: 450px) {
	.khung {
		margin-top: 100px;
	}
}

@media screen and (max-width: 400px) {
	.khung {
		margin-top: 50px;
	}
}

@media screen and (max-width: 350px) {
	.khung {
		margin-top: 0px;
	}
}
</style>
<body class="bg-dark" style="font-family: Trirong, serif;">
	<div
		style="width: 350px; border-radius: 5px; background-color: rgb(240, 240, 240);"
		class="khung">
		<form action="login" method="post">
			<div class="row">
				<c:if test="${loi!=null }">
					<div class="col-12">
						<p style="background-color: rgb(255, 200, 50); color: rgb(240, 240, 240); text-align: center;">${loi }</p>
					</div>
				</c:if>
				<div class="col-2"></div>
				<div class="col-8" style="margin-top: 20px;">
					<label for="taiKhoan"><b>Tài khoản:</b></label>
				</div>
				<div class="col-2"></div>
				<div class="col-2"></div>
				<div class="col-8">
					<input class="form-control" id="taiKhoan" name="taiKhoan"
						type="text">
				</div>
				<div class="col-2" style="margin-top: 5px;" id="acc"></div>
				<div class="col-2"></div>
				<div class="col-8" style="margin-top: 20px;">
					<label for="matKhau"><b>Mật khẩu:</b></label>
				</div>
				<div class="col-2"></div>
				<div class="col-2"></div>
				<div class="col-8">
					<input class="form-control" id="matKhau" name="matKhau"
						type="password">
				</div>
				<div class="col-2" style="margin-top: 5px;" id="pass"></div>

				<div class="col-4"></div>
				<div class="col-4" style="margin-top: 20px;">
					<input type="submit" value="Đăng nhập" class="btn btn-secondary">
				</div>
				<div class="col-4"></div>
				<div class="col-12 text-center" style="margin-top: 20px;">
					<a href="home" class="text-center nav-link">Trang chủ</a>
				</div>
				<div class="col-12 text-center"margin-bottom: 20px;">
					<a href="get-password" class="text-center nav-link">Quên mật khẩu</a>
				</div>
			</div>

		</form>
	</div>

</body>
</html>