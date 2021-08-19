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

.ifra {
	height: 620px;
}

@media screen and (max-width: 1000px) {
	.ifra {
		height: 556px;
	}
}

@media screen and (max-width: 950px) {
	.ifra {
		height: 528px;
	}
}

@media screen and (max-width: 900px) {
	.ifra {
		height: 500px;
	}
}

@media screen and (max-width: 850px) {
	.ifra {
		height: 472px;
	}
}

@media screen and (max-width: 800px) {
	.ifra {
		height: 444px;
	}
}

@media screen and (max-width: 750px) {
	.ifra {
		height: 417px;
	}
}

@media screen and (max-width: 700px) {
	.ifra {
		height: 389px;
	}
}

@media screen and (max-width: 650px) {
	.ifra {
		height: 361px;
	}
}

@media screen and (max-width: 600px) {
	.ifra {
		height: 333px;
	}
}

@media screen and (max-width: 550px) {
	.ifra {
		height: 306px;
	}
}

@media screen and (max-width: 500px) {
	.ifra {
		height: 278px;
	}
}

@media screen and (max-width: 450px) {
	.ifra {
		height: 250px;
	}
}

@media screen and (max-width: 400px) {
	.ifra {
		height: 222px;
	}
}

.show_txt {
	display: inline-block;
	width: 100%;
	white-space: nowrap;
	overflow: hidden !important;
	text-overflow: ellipsis;
}

.menu1:hover {
	color: rgb(255, 200, 50);
}
.menu2:hover {
	background-color: rgb(60, 179, 113);
}
</style>

<body class="bg-dark" style="font-family: Trirong, serif;">
	<jsp:include page="Head.jsp"></jsp:include>
	<c:if test="${phim!=null}">
		<div class="container">
			<h3 class="text-primary">${phim.title }</h3>
			<iframe class="ifra" width=100% src="${phim.episodeURL }"
				title="${phim.title }" frameborder="0"
				allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture"
				allowfullscreen></iframe>

			<c:forEach items="${boPhim}" var="o">
				<span class="btn ${o.episode==phim.episode?"bg-danger":"btn-secondary" } menu2"><a style="color: rgb(240, 240, 240); padding: 0px;" class="nav-link"
					href="detail?id=${o.id }">${o.episode}</a></span>
			</c:forEach>
			<hr
				style="height: 1px; border: none; background-color: rgb(240, 240, 240);">
		</div>
	</c:if>
	<div class="container">

		<h3 style="color: rgb(255, 200, 50);">Có thể bạn muốn xem</h3>
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
	</div>
	<jsp:include page="Footer.jsp"></jsp:include>
</body>
</html>