<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:if
	test="${categoryPhimBo!=null||categoryPhimLe!=null||categoryPhimChieuRap!=null||categoryPhimHoatHinh!=null}">
	<div class="container">
		<div class="row">
			<div class="col-lg-9">
				<h1 style="line-height: 60px; height: 50px;">
					<a href="home" class="nav-link" style="color: rgb(240, 240, 240);">PHIM
						MOI</a>
				</h1>
			</div>

			<div class="col-lg-3" style="margin-top: 22px;">
				<form class="form-inline my-2 my-lg-0">
					<div class="input-group input-group-sm" style="width: 100%;">
						<input oninput="searchByName(this)" value="${txt }" type="text"
							class="form-control" aria-label="Small"
							aria-describedby="inputGroup-sizing-sm"
							placeholder="Tìm kiếm theo tên phim">
						<div class="input-group-append">
							<div class="btn btn-number"
								style="background-color: rgb(255, 200, 50);">
								<i class="bi bi-search" style="color: white;"></i>
							</div>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>

	<hr
		style="height: 3px; border: none; background-color: rgb(255, 200, 50);">

	<div class="container">
		<nav>
			<div class="btn-group">
				<button type="button"
					class="btn btn-secondary dropdown-toggle menu1"
					data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Phim
					bộ</button>
				<div class="dropdown-menu dropdown-menu-right">
					<c:forEach items="${categoryPhimBo}" var="o">
						<a class="dropdown-item menu2"
							href="search?type=Phim%20bộ&category=${o }">${o }</a>
					</c:forEach>
				</div>
			</div>
			<div class="btn-group">
				<button type="button"
					class="btn btn-secondary dropdown-toggle  menu1"
					data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Phim
					lẻ</button>
				<div class="dropdown-menu dropdown-menu-right">
					<c:forEach items="${categoryPhimLe}" var="o">
						<a class="dropdown-item menu2"
							href="search?type=Phim%20lẻ&category=${o }">${o }</a>
					</c:forEach>
				</div>
			</div>
			<div class="btn-group">
				<button type="button"
					class="btn btn-secondary dropdown-toggle menu1"
					data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Phim
					chiếu rạp</button>
				<div class="dropdown-menu dropdown-menu-right">
					<c:forEach items="${categoryPhimChieuRap}" var="o">
						<a class="dropdown-item menu2"
							href="search?type=Phim%20chiếu%20rạp&category=${o }">${o }</a>
					</c:forEach>
				</div>
			</div>
			<div class="btn-group">
				<button type="button"
					class="btn btn-secondary dropdown-toggle menu1"
					data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Phim
					hoạt hình</button>
				<div class="dropdown-menu dropdown-menu-right">
					<c:forEach items="${categoryPhimHoatHinh}" var="o">
						<a class="dropdown-item menu2"
							href="search?type=Phim%20hoạt%20hình&category=${o }">${o }</a>
					</c:forEach>
				</div>
			</div>
			<c:if test="${sessionScope.admin!=null || sessionScope.user!=null}">
				<div class="btn-group">
					<a href="logout"><button type="button"
							class="btn btn-secondary menu1">Đăng xuất</button></a>
				</div>
			</c:if>
			<c:if test="${sessionScope.admin!=null}">
				<div class="btn-group">
					<button data-toggle="modal" data-target="#admin" type="button"
						class="btn btn-secondary menu1">Admin</button>
				</div>
			</c:if>
			<c:if test="${sessionScope.admin!=null}">
				<div class="btn-group">
					<button data-toggle="modal" data-target="#add" type="button"
						class="btn btn-secondary menu1">
						<i class="bi bi-plus-circle"></i>
					</button>
				</div>
			</c:if>
			<c:if test="${sessionScope.admin!=null}">
				<div class="btn-group">
					<button data-toggle="modal" data-target="#report" type="button"
						class="btn btn-secondary menu1">
						<i class="bi bi-bell-fill"></i>
					</button>
				</div>
			</c:if>
			<c:if test="${sessionScope.user!=null}">
				<div class="btn-group">
					<button data-toggle="modal" data-target="#history" type="button"
						class="btn btn-secondary menu1">
						<i class="bi bi-clock-history"></i>
					</button>
				</div>
			</c:if>
			<c:if test="${sessionScope.user==null}">
				<div class="btn-group">
					<a
						href="https://www.facebook.com/dialog/oauth?client_id=667188987589328&redirect_uri=https://localhost:8443/phimmoi/login-facebook"><button
							type="button" class="btn btn-secondary menu1">Đăng nhập</button></a>
				</div>
			</c:if>
		</nav>
		<hr
			style="height: 1px; border: none; background-color: rgb(240, 240, 240);">
	</div>
	<!-- Add -->
	<div class="modal fade" id="add" tabindex="-1"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">Thêm phim</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<form action="add" method="post">
					<div class="modal-body">
						<label for="type"><b>Kiểu:</b></label> <input required="required"
							type="text" class="form-control" name="type" id="type"><label
							for="category"><b>Thể loại:</b></label> <input
							required="required" type="text" class="form-control"
							name="category" id="category"><label for="episode"><b>Tập:</b></label>
						<input required="required" type="text" class="form-control"
							name="episode" id="episode"><label for="episodeURL"><b>URL:</b></label>
						<input required="required" type="text" class="form-control"
							name="episodeURL" id="episodeURL"><label for="imageURL"><b>Ảnh:</b></label>
						<input required="required" type="text" class="form-control"
							name="imageURL" id="imageURL"><label for="title"><b>Tiêu
								đề:</b></label> <input required="required" type="text" class="form-control"
							name="title" id="title">
					</div>
					<div class="modal-footer">
						<button type="submit" class="btn btn-primary">Cập nhật</button>
					</div>
				</form>
			</div>
		</div>
	</div>
	<!-- Get report -->
	<div class="modal fade" id="report" tabindex="-1"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">Báo lỗi</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<ul>
						<c:forEach items="${report}" var="o">
							<li><a href="report?id=${o.id }" class="nav-link">${o.title }</a></li>
						</c:forEach>
					</ul>
				</div>

			</div>
		</div>
	</div>
	<!-- Get history -->
	<div class="modal fade" id="history" tabindex="-1"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog modal-lg">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">Lịch sử</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<ul>
						<c:forEach items="${history}" var="o">
							<li><a href="detail?id=${o.id }" class="nav-link"> <span> ${o.title } </span><span style="color: red;"> ${o.time } </span>
							</a></li>
						</c:forEach>
					</ul>
				</div>

			</div>
		</div>
	</div>
	<!-- admin -->
	<div class="modal fade" id="admin" tabindex="-1"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">Admin</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<form action="update-email" method="post">
						<div class="row">
							<div class="col-1"></div>
							<div class="col-10">
								<label for="account"><b>Tài khoản:</b></label>
							</div>
							<div class="col-1"></div>
						</div>
						<div class="row">
							<div class="col-1"></div>
							<div class="col-10">
								<input readonly="readonly" type="text" class="form-control"
									value="${sessionScope.admin.account}" id="account">
							</div>
							<div class="col-1"></div>
						</div>
						<div class="row">
							<div class="col-1"></div>
							<div class="col-10">
								<label for="email"><b>Email:</b></label>
							</div>
							<div class="col-1"></div>
						</div>
						<div class="row">
							<div class="col-1"></div>
							<div class="col-10">
								<input required="required" type="email" class="form-control"
									name="email" id="email" value="${sessionScope.admin.email}">
							</div>
							<div class="col-1"></div>
						</div>
						<input name="id" value="${sessionScope.admin.id}"
							style="display: none;" id="_id">
						<div class="row">
							<div class="col-1"></div>
							<div class="col-10">
								<label for="password"><b>Mật khẩu cũ:</b></label>
							</div>
							<div class="col-1"></div>
						</div>
						<div class="row">
							<div class="col-1"></div>
							<div class="col-10">
								<input oninput="checkPassword1(this)" required="required"
									type="password" class="form-control" id="password"
									name="password"> <sup><a href="get-password">Quên
										mật khẩu</a></sup>
							</div>
							<div class="col-1" style="margin-top: 5px;" id="pass1"></div>
						</div>
						<div class="row">
							<div class="col-1"></div>
							<div class="col-10">
								<button style="margin: 15px 0 15px 0;" type="submit"
									class="btn btn-primary">Cập nhật</button>
							</div>
							<div class="col-1"></div>
						</div>
					</form>
					<form action="update-password" onsubmit="return confirmm()"
						method="post">
						<input name="id" value="${sessionScope.admin.id}"
							style="display: none;" id="_id">
						<div class="row">
							<div class="col-1"></div>
							<div class="col-10">
								<label for="password"><b>Mật khẩu cũ:</b></label>
							</div>
							<div class="col-1"></div>
						</div>
						<div class="row">
							<div class="col-1"></div>
							<div class="col-10">
								<input oninput="checkPassword2(this)" required="required"
									type="password" class="form-control" id="password"
									name="password"> <sup><a href="get-password">Quên
										mật khẩu</a></sup>
							</div>
							<div class="col-1" style="margin-top: 5px;" id="pass2"></div>
						</div>
						<div class="row">
							<div class="col-1"></div>
							<div class="col-10">
								<label for="newpass"><b>Mật khẩu mới:</b></label>
							</div>
							<div class="col-1"></div>
						</div>
						<div class="row">
							<div class="col-1"></div>
							<div class="col-10">
								<input oninput="newPass()" required="required" type="password"
									class="form-control" name="newpass" id="newpass"> <sup
									id="a" class="text-danger" style="display: none;">Mật
									khẩu yếu</sup>
							</div>
							<div class="col-1" style="margin-top: 5px;">
								<i id="b" class="bi bi-x-circle text-danger"
									style="display: none;"></i> <i id="c"
									class="bi bi-check-circle text-success" style="display: none;"></i>
							</div>
						</div>
						<div class="row">
							<div class="col-1"></div>
							<div class="col-10">
								<label for="confirm"><b>Xác nhận mật khẩu:</b></label>

							</div>
							<div class="col-1"></div>
						</div>
						<div class="row">
							<div class="col-1"></div>
							<div class="col-10">
								<input oninput="confirmm()" required="required" type="password"
									class="form-control" name="confirm" id="confirm"> <sup
									id="d" class="text-danger" style="display: none;">Mật
									khẩu không khớp</sup>
							</div>
							<div class="col-1" style="margin-top: 5px;">
								<i id="e" class="bi bi-x-circle text-danger"
									style="display: none;"></i> <i id="f"
									class="bi bi-check-circle text-success" style="display: none;"></i>
							</div>
						</div>
						<div class="row">
							<div class="col-1"></div>
							<div class="col-10">
								<button style="margin-top: 15px; display: none;" type="submit"
									id="submit" class="btn btn-primary">Cập nhật</button>
							</div>
							<div class="col-1"></div>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
	<script>
		function checkPassword1(param) {
			let password = param.value;
			let _id = document.getElementById("_id").value;
			$.ajax({
				url : "/phimmoi/check-password",
				type : "post",
				data : {
					pass : password,
					id : _id
				},
				success : function(data) {
					let row = document.getElementById("pass1");
					row.innerHTML = data;
				}

			});
		}
		function checkPassword2(param) {
			let password = param.value;
			let _id = document.getElementById("_id").value;
			$.ajax({
				url : "/phimmoi/check-password",
				type : "post",
				data : {
					pass : password,
					id : _id
				},
				success : function(data) {
					let row = document.getElementById("pass2");
					row.innerHTML = data;
				}

			});
		}

		function newPass() {
			let newpass = document.getElementById("newpass").value;
			if (newpass.length >= 6 && /[\d]/.test(newpass)
					&& /[a-z]/.test(newpass) && /[A-Z]/.test(newpass)
					&& /[\W]/.test(newpass) && /[\w]/.test(newpass)) {
				document.getElementById("a").style.display = "none";
				document.getElementById("c").style.display = "inline";
				document.getElementById("b").style.display = "none";
			} else {
				document.getElementById("a").style.display = "inline";
				document.getElementById("c").style.display = "none";
				document.getElementById("b").style.display = "inline";
			}
			confirmm();
		}

		function confirmm() {
			let confirm = document.getElementById("confirm").value;
			let newpass = document.getElementById("newpass").value;
			{
				if (confirm == newpass) {
					document.getElementById("d").style.display = "none";
					document.getElementById("f").style.display = "inline";
					document.getElementById("e").style.display = "none";
				} else {
					document.getElementById("d").style.display = "inline";
					document.getElementById("f").style.display = "none";
					document.getElementById("e").style.display = "inline";
				}
			}
			{
				if (newpass.length >= 6 && /[\d]/.test(newpass)
						&& /[a-z]/.test(newpass) && /[A-Z]/.test(newpass)
						&& /[\W]/.test(newpass) && /[\w]/.test(newpass)
						&& confirm == newpass) {
					document.getElementById("submit").style.display = "inline";
				} else {
					document.getElementById("submit").style.display = "none";
				}
			}
			return newpass.length >= 6 && /[\d]/.test(newpass)
					&& /[a-z]/.test(newpass) && /[A-Z]/.test(newpass)
					&& /[\W]/.test(newpass) && /[\w]/.test(newpass)
					&& confirm == newpass;
		}
	</script>
</c:if>