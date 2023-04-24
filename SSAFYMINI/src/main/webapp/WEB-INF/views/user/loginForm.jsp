<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SSAFY MINI</title>
</head>
<style>
.container{
	margin : auto 0;
}
</style>
<body>
	<%@ include file="../include/header.jsp" %>
	
	<div class="container">
		<form method="post" action="login">
		<input type="text" name="id" placeholder="아이디"> 
		<input type="password" name="password" placeholder="비밀번호"> 
		<input type="submit" value="로그인">
		</form>
	</div>
	
</body>
</html>