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
						<input oninput="searchByName(this)" type="text" class="form-control"
							aria-label="Small" aria-describedby="inputGroup-sizing-sm"
							placeholder="Tìm kiếm theo tên phim">
						<div class="input-group-append">
							<dvi class="btn btn-primary btn-number">
								<i class="bi bi-search"></i>
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
			</nav>
		</div>
		<hr
			style="height: 1px; border: none; background-color: rgb(240, 240, 240);">
	</div>
</c:if>