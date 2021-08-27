<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:if
	test="${categoryPhimBo!=null||categoryPhimLe!=null||categoryPhimChieuRap!=null||categoryPhimHoatHinh!=null}">
	<div class="container">
		<div class="row">
			<div class="col-lg-9">
				<h1>
					<a href="home" class="nav-link" style="color: rgb(240, 240, 240);">PHIM
						MOI</a>
				</h1>
			</div>

			<div class="col-lg-3" style="margin-top: 15px;">
				<form class="form-inline my-2 my-lg-0">
					<div class="input-group input-group-sm" style="width: 100%;">
						<input oninput="searchByName(this)" value="${txt }" type="text"
							class="form-control" aria-label="Small"
							aria-describedby="inputGroup-sizing-sm"
							placeholder="Tìm kiếm theo tên phim">
						<div class="input-group-append">
							<dvi class="btn btn-primary btn-number"> <i
								class="bi bi-search"></i>
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
		<div class="row">
			<nav class="col-lg-9">
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
				<c:if test="${sessionScope.admin!=null}">
					<div class="btn-group">
						<a href="logout"><button type="button"
								class="btn btn-secondary menu1">Đăng xuất</button></a>
					</div>
				</c:if>
				<c:if test="${sessionScope.admin!=null}">
					<div class="btn-group">
						<button data-toggle="modal" data-target="#add" type="button"
							class="btn btn-secondary menu1">Thêm phim</button>
					</div>
				</c:if>
				<c:if test="${sessionScope.admin!=null}">
					<div class="btn-group">
						<button data-toggle="modal" data-target="#admin" type="button"
							class="btn btn-secondary menu1">Admin</button>
					</div>
				</c:if>
			</nav>
		</div>
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
						<label for="account"><b>Tài khoản:</b></label> <input
							readonly="readonly" type="text" class="form-control"
							value="${sessionScope.admin.account}" id="account"><label
							for="email"><b>Email:</b></label> <input required="required"
							type="text" class="form-control" name="email" id="email"
							value="${sessionScope.admin.email}"> <input name="id"
							value="${sessionScope.admin.id}" style="display: none;" id="_id">
						<button style="margin: 15px 0 15px 0;" type="submit"
							class="btn btn-primary">Cập nhật</button>
					</form>
					<form action="update-password" method="post">
						<label for="password"><b>Mật khẩu cũ:</b></label>
						<div class="row">
							<div class="col-11">
								<input oninput="checkPassword(this)" required="required" type="password" class="form-control"
									id="password" name="password">
							</div>
							<div class="col-1" style="margin-top: 5px;" id="pass">
								<i class="bi bi-x-circle text-danger"></i>
							</div>
						</div>
						<label for="newpass"><b>Mật khẩu mới:</b></label>
						<div class="row">
							<div class="col-11">
								<input required="required" type="password" class="form-control"
									name="newpass" id="newpass">
							</div>
							<div class="col-1" style="margin-top: 5px;">
								<i class="bi bi-x-circle text-danger"></i>
							</div>
						</div>
						<label for="confirm"><b>Xác nhận mật khẩu:</b></label>
						<div class="row">
							<div class="col-11">
								<input required="required" type="password" class="form-control"
									name="confirm" id="confirm">
							</div>
							<div class="col-1" style="margin-top: 5px;">
								<i class="bi bi-x-circle text-danger"></i>
							</div>
						</div>
						<button style="margin-top: 15px;" type="submit"
							class="btn btn-primary">Cập nhật</button>
					</form>
				</div>
			</div>
		</div>
	</div>
	<script>
		function checkPassword(param) {
			var password = param.value;
			var _id = document.getElementById("_id").value;
			$.ajax({
				url : "/phimmoi/check-password",
				type : "post",
				data : {
					pass : password,
					id : _id
				},
				success : function(data) {
					var row = document.getElementById("pass");
					row.innerHTML = data;
				}

			});
		}
	</script>
</c:if>