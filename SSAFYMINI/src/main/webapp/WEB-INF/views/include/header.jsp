<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.ssafy.mini.model.dto.*" %>
<!-- CSS only -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
<!-- JavaScript Bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
<style>
#nav-header {
	display: flex;
	justify-content: space-between;
}
#ssafy_logo{
	width: 150px;
}
</style>
<c:set value="${pageContext.request.contextPath }" scope="session" var="root"></c:set>
<div id="nav-header">
	<img src="${root }/resources/img/ssafy_logo.png" id="ssafy_logo">
	<%-- session에서 loginUser를 가져와서 존재 여부에 따라 로그인 폼 또는 사용자 정보를 출력한다. --%>
	<div class="nav-login">
		
		<c:if test="${empty loginUser}">
			<a href="login">로그인</a>
			<a href="registUser">회원가입</a>
		</c:if>
		
		<c:if test="${!empty loginUser }">
			<c:if test="${loginUser.name eq 'admin'}">
				<div>
					${loginUser.name }님 반갑습니다. 
					<a href="./logout">로그아웃</a>
					<a href="./myPage">관리자 페이지</a>
				</div>
			</c:if>
			<c:if test="${loginUser.name ne 'admin'}">
				<div>
					${loginUser.name }님 반갑습니다. 
					<a href="./logout">로그아웃</a>
					<a href="./myPage">마이 페이지</a>
				</div>
			</c:if>
		</c:if>
	</div>
</div>
<hr>
<script>
	// request 영역에 msg라는 이름의 attribute가 있다면 화면에 alert으로 출력한다.
	let msg = "${msg}";
	if (msg) {
		alert(msg)
	}
</script>