<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:if test="${sessionScope.user==null}">
	<a
		href="https://www.facebook.com/dialog/oauth?client_id=667188987589328&redirect_uri=https://localhost:8443/phimmoi/login-facebook"><button
			class="btn text-primary">Đăng nhập bằng Facebook</button></a>
</c:if>