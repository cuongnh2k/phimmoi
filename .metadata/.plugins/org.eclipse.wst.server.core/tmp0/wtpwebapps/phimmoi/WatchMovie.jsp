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
<title>${phim.title }</title>
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

.menu3:hover {
	background-color: rgb(60, 179, 113);
}

.menu2:hover {
	color: white;
	background-color: #708090;
}
</style>

<body class="bg-dark" style="font-family: Trirong, serif;">
	<jsp:include page="Head.jsp"></jsp:include>
	<div class="container">
		<div id="search" class="row"></div>
	</div>
	<c:if test="${phim!=null}">
		<div class="container">
			<p style="color: rgb(255, 200, 50);">${phim.type }/
				${phim.category} / ${phim.title }</p>
			<h3 class="text-primary">${phim.title }</h3>
			<c:if test="${boPhim!=null}">
				<p style="color: rgb(240, 240, 240);">Tập: ${phim.episode }</p>
			</c:if>
			<div class="row">
				<div class="col-sm-12">
					<p style="color: rgb(240, 240, 240);">
						Lượt xem: ${phim.view} <i class="bi bi-eye"></i>
					</p>
				</div>
				<div class="col-sm-1" onclick="report()"
					style="color: rgb(240, 240, 240); font-size: 25px;">
					<i class="bi bi-flag-fill"></i>
				</div>
				<c:if test="${sessionScope.admin!=null }">
					<div class="col-sm-1">
						<i data-toggle="modal" data-target="#edit" class="bi bi-hammer"
							style="color: rgb(240, 240, 240); font-size: 25px;"></i>
					</div>
					<div class="col-sm-1">
						<i data-toggle="modal" data-target="#remove" class="bi bi-trash"
							style="color: rgb(240, 240, 240); font-size: 25px;"></i>
					</div>
				</c:if>
			</div>
			<iframe class="ifra" width=100% src="${phim.episodeURL }"
				title="${phim.title }" frameborder="0"
				allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture"
				allowfullscreen></iframe>
			<c:forEach items="${boPhim}" var="o">
				<span class="btn ${o.episode==phim.episode?"btn-danger":"btn-secondary" } menu3"><a
					style="color: rgb(240, 240, 240); padding: 0px;" class="nav-link"
					href="detail?id=${o.id }">${o.episode}</a></span>
			</c:forEach>
			<jsp:include page="Comment.jsp"></jsp:include>
			<hr
				style="height: 1px; border: none; background-color: rgb(240, 240, 240);">
			<h3 style="color: rgb(255, 200, 50);">Có thể bạn muốn xem</h3>

			<div class="row">
				<c:forEach items="${phimTuongTu}" var="o">
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

	<!-- Edit -->
	<div class="modal fade" id="edit" tabindex="-1"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">${phim.title }</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<form action="edit" method="post">
					<div class="modal-body">
						<input name="id" id="id" value="${phim.id }"
							style="display: none;"> <label for="type"><b>Kiểu:</b></label>
						<input type="text" class="form-control" name="type" id="type"
							value="${phim.type }"><label for="category"><b>Thể
								loại:</b></label> <input type="text" class="form-control" name="category"
							id="category" value="${phim.category}"><label
							for="episode"><b>Tập:</b></label> <input type="text"
							class="form-control" name="episode" id="episode"
							value="${phim.episode }"><label for="episodeURL"><b>URL:</b></label>
						<input type="text" class="form-control" name="episodeURL"
							id="episodeURL" value="${phim.episodeURL }"><label
							for="imageURL"><b>Ảnh:</b></label> <input type="text"
							class="form-control" name="imageURL" id="imageURL"
							value="${phim.imageURL }"><label for="title"><b>Tiêu
								đề:</b></label> <input type="text" class="form-control" name="title"
							id="title" value="${phim.title}">
					</div>
					<div class="modal-footer">
						<button type="submit" class="btn btn-primary">Cập nhật</button>
					</div>
				</form>
			</div>
		</div>
	</div>
	<!-- Rempve -->
	<div class="modal fade" id="remove" tabindex="-1"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">Có muốn xóa
						không ?</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary"
						data-dismiss="modal">Không</button>
					<form action="remove" method="post">
						<input name="id" value="${phim.id }" style="display: none;">
						<button type="submit" class="btn btn-primary">Có</button>
					</form>
				</div>
			</div>
		</div>
	</div>
	<script>
		function report() {
			let id = document.getElementById("id").value;
			$.ajax({
				url : "/phimmoi/report",
				type : "post",
				data : {
					id : id
				},
				success : function(data) {

				}

			});

			alert('Báo cáo thành công');
		}

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

		function phanHoi(comment_id) {
			document.getElementById(comment_id).style.display = "inline";
		}
	</script>
</body>
</html>