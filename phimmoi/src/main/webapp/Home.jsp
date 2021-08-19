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
	<c:if test="${list1!=null&&list2!=null&&list3!=null}">
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
					<div class="carousel-item active">
						<div class="row">
							<c:forEach items="${list1}" var="o">
								<div class="col-3">
									<a href="detail?id=${o.id }"> <img src="${o.imageURL }"
										class="card-img-top" alt="${o.title}">
										<p class="show_txt text-primary">${o.title}</p></a>
									<p></p>
								</div>
							</c:forEach>
						</div>
					</div>
					<div class="carousel-item">
						<div class="row">
							<c:forEach items="${list2}" var="o">
								<div class="col-3">
									<a href="detail?id=${o.id }"> <img src="${o.imageURL }"
										class="card-img-top" alt="${o.title}">
										<p class="show_txt text-primary">${o.title}</p></a>
									<p></p>
								</div>
							</c:forEach>
						</div>
					</div>
					<div class="carousel-item">
						<div class="row">
							<c:forEach items="${list3}" var="o">
								<div class="col-3">
									<a href="detail?id=${o.id }"> <img src="${o.imageURL }"
										class="card-img-top" alt="${o.title}">
										<p class="show_txt text-primary">${o.title}</p></a>
									<p></p>
								</div>
							</c:forEach>
						</div>
					</div>
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
	</c:if>
	<c:if test="${phimBoCapNhat!=null}">
		<div class="container">
			<h3 style="color: rgb(255, 200, 50);">PHIM BỘ CẬP NHẬT</h3>
			<div class="row">
				<c:forEach items="${phimBoCapNhat}" var="o">
					<div class="col-12 col-md-4 col-xl-2 col-lg-3 col-sm-6">
						<a href="detail?id=${o.id }"> <img src="${o.imageURL }"
							class="card-img-top" alt="${o.title}">
							<p class="show_txt text-primary">${o.title}</p></a>
					</div>
				</c:forEach>
			</div>
			<hr
				style="height: 1px; border: none; background-color: rgb(240, 240, 240);">
		</div>
	</c:if>
	<c:if test="${phimLeCapNhat!=null}">
		<div class="container">
			<h3 style="color: rgb(255, 200, 50);">PHIM LẺ CẬP NHẬT</h3>
			<div class="row">
				<c:forEach items="${phimLeCapNhat}" var="o">
					<div class="col-12 col-md-4 col-xl-2 col-lg-3 col-sm-6">
						<a href="detail?id=${o.id }"> <img src="${o.imageURL }"
							class="card-img-top" alt="${o.title}">
							<p class="show_txt text-primary">${o.title}</p></a>
					</div>
				</c:forEach>
			</div>
			<hr
				style="height: 1px; border: none; background-color: rgb(240, 240, 240);">
		</div>
	</c:if>
	<c:if test="${phimChieuRapCapNhat!=null}">
		<div class="container">
			<h3 style="color: rgb(255, 200, 50);">PHIM CHIẾU RẠP CẬP NHẬT</h3>
			<div class="row">
				<c:forEach items="${phimChieuRapCapNhat}" var="o">
					<div class="col-12 col-md-4 col-xl-2 col-lg-3 col-sm-6">
						<a href="detail?id=${o.id }"> <img src="${o.imageURL }"
							class="card-img-top" alt="${o.title}">
							<p class="show_txt text-primary">${o.title}</p></a>
					</div>
				</c:forEach>
			</div>
			<hr
				style="height: 1px; border: none; background-color: rgb(240, 240, 240);">
		</div>
	</c:if>
	<c:if test="${phimHoatHinhCapNhat!=null}">
		<div class="container">
			<h3 style="color: rgb(255, 200, 50);">PHIM HOẠT HÌNH CẬP NHẬT</h3>
			<div class="row">
				<c:forEach items="${phimHoatHinhCapNhat}" var="o">
					<div class="col-12 col-md-4 col-xl-2 col-lg-3 col-sm-6">
						<a href="detail?id=${o.id }"> <img src="${o.imageURL }"
							class="card-img-top" alt="${o.title}">
							<p class="show_txt text-primary">${o.title}</p></a>
					</div>
				</c:forEach>
			</div>
		</div>
	</c:if>
	<jsp:include page="Footer.jsp"></jsp:include>
</body>
</html>