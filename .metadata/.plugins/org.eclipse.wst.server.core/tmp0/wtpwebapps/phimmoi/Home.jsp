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
<title>Phim mới</title>
</head>

<style>
.menu1:hover {
	color: rgb(255, 200, 50);
}

.menu2:hover {
	color: white;
	background-color: #708090;
}

@media screen and (max-width: 700px) {
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

.menu3:hover {
	background-color: rgb(60, 179, 113);
}
</style>

<body class="bg-dark" style="font-family: Trirong, serif;">
	<jsp:include page="Head.jsp"></jsp:include>
	<div class="container">
		<div id="search" class="row"></div>
	</div>
	<c:if test="${size!=null}">
		<div class="container">
			<div class="row">
				<c:forEach items="${searchByName}" var="o">
					<div class="col-12 col-md-4 col-xl-2 col-lg-3 col-sm-6">
						<a href="detail?id=${o.id }"> <img src="${o.imageURL }"
							class="card-img-top" alt="${o.title}">
							<p class="show_txt text-primary">${o.title}</p></a>
					</div>
				</c:forEach>
			</div>
			<c:forEach items="${size}" var="o">
				<span class="btn ${o.value==x?"btn-danger":"btn-secondary" } menu3"><a
					style="color: rgb(240, 240, 240); padding: 0px;" class="nav-link"
					href="searchByName?txt=${txt }&x=${o.value}">${o.key }</a></span>
			</c:forEach>
			<hr
				style="height: 1px; border: none; background-color: rgb(240, 240, 240);">
		</div>
	</c:if>
	<c:if test="${count!=null }">
		<div class="container">
			<p style="color: rgb(255, 200, 50);">${CT030408.type }/
				${CT030408.category}</p>
			<div class="row">
				<c:forEach items="${searchMenu}" var="o">
					<div class="col-12 col-md-4 col-xl-2 col-lg-3 col-sm-6">
						<a href="detail?id=${o.id }"> <img src="${o.imageURL }"
							class="card-img-top" alt="${o.title}">
							<p class="show_txt text-primary">${o.title}</p></a>
					</div>
				</c:forEach>
			</div>

			<c:forEach items="${count}" var="o">
				<span class="btn ${o.value==index?"btn-danger":"btn-secondary" } menu3"><a
					style="color: rgb(240, 240, 240); padding: 0px;" class="nav-link"
					href="search?type=${CT030408.type }&category=${CT030408.category}&index=${o.value}">${o.key }</a></span>
			</c:forEach>
			<hr
				style="height: 1px; border: none; background-color: rgb(240, 240, 240);">
		</div>
	</c:if>
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
	<script>
		function searchByName(param) {
			var txtSearch = param.value;
			$.ajax({
				url : "/phimmoi/searchByName",
				type : "post",
				data : {
					txt : txtSearch
				},
				success : function(data) {
					var row3 = document.getElementById("search");
					row3.innerHTML = data;
				}

			});
		}
	</script>

</body>
</html>