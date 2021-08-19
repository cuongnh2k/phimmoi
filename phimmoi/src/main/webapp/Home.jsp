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
<title>xxx</title>
</head>

<style>
.menu1:hover {
	color: rgb(255, 200, 50);
}

.menu2:hover {
	color: white;
	background-color: #708090;
}

@media screen and (max-width: 800px) {
	.huyen-anh {
		display: none;
	}
}

.show_txt {
	display: inline-block;
	width: 100%;
	white-space: nowrap;
	overflow: hidden !important;
	text-overflow: ellipsis;
}
</style>

<body class="bg-dark" style="font-family: Trirong, serif;">
	<jsp:include page="Head.jsp"></jsp:include>
	<div class="container huyen-anh">
		<h3 style="color: rgb(255, 200, 50);">PHIM ĐỀ CỬ</h3>
		<div id="carouselExampleIndicators" class="carousel slide"
			data-ride="carousel">
			<ol class="carousel-indicators">
				<li data-target="#carouselExampleIndicators" data-slide-to="0"
					class="active"></li>
				<li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
				<li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
			</ol>
			<div class="carousel-inner">
				<%
				for (int i = 0; i < 12; i++) {
				%>
				<div class="carousel-item active">
					<div class="row">

						<div class="col-3">
							<img
								src="https://www.fullphimz.net/static/5fe2d564b3fa6403ffa11d1c/60c2c95a395ca20c35574f9b_truong-bach-thai-tue.jpg"
								class="card-img-top" alt="...">
							<p class="show_txt text-primary">Phim sss
								mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm</p>
							<p></p>
						</div>
						<div class="col-3">
							<img
								src="https://www.fullphimz.net/static/5fe2d564b3fa6403ffa11d1c/60c2315e8071871c9ecde8d7_thuc-tinh.jpg"
								class="card-img-top" alt="...">
							<p class="show_txt text-primary">Phim sss
								mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm</p>
						</div>
						<div class="col-3">
							<img
								src="https://www.fullphimz.net/static/5fe2d564b3fa6403ffa11d1c/60c1d42a65f2e34d789b3f46_anh-hung-xa-dieu-truyen.jpg"
								class="card-img-top" alt="...">
							<p class="show_txt text-primary">Phim sss
								mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm</p>
						</div>
						<div class="col-3">
							<img
								src="https://www.fullphimz.net/static/5fe2d564b3fa6403ffa11d1c/60c0de02d066b12ac2ab4720_khu-rung-bi-an.jpg"
								class="card-img-top" alt="...">
							<p class="show_txt text-primary">Phim sss
								mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm</p>
						</div>

					</div>
				</div>
				<%
				}
				%>
			</div>

			<a class="carousel-control-prev" href="#carouselExampleIndicators"
				role="button" data-slide="prev"> <span
				class="carousel-control-prev-icon" aria-hidden="true"></span> <span
				class="sr-only">Previous</span>
			</a> <a class="carousel-control-next" href="#carouselExampleIndicators"
				role="button" data-slide="next"> <span
				class="carousel-control-next-icon" aria-hidden="true"></span> <span
				class="sr-only">Next</span>
			</a>
		</div>
		<hr
			style="height: 1px; border: none; background-color: rgb(240, 240, 240);">
	</div>
	<%
	for (int i = 0; i < 4; i++) {
	%>
	<div class="container">
		<h3 style="color: rgb(255, 200, 50);">PHIM BỘ CẬP NHẬT</h3>
		<div class="row">
			<%
			for (int j = 0; j < 12; j++) {
			%>
			<div class="col-12 col-md-4 col-xl-2 col-lg-3 col-sm-6">
				<img
					src="https://www.fullphimz.net/static/5fe2d564b3fa6403ffa11d1c/60c0de02d066b12ac2ab4720_khu-rung-bi-an.jpg"
					class="card-img-top" alt="...">
				<p class="show_txt text-primary">Phim sss
					mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm</p>
			</div>
			<%
			}
			%>
		</div>
		<hr
			style="height: 1px; border: none; background-color: rgb(240, 240, 240);">
	</div>
	<%
	}
	%>
	<jsp:include page="Footer.jsp"></jsp:include>
</body>
</html>