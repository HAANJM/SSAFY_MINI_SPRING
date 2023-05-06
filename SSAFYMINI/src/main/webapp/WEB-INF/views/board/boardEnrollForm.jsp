<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SSAFY MINI</title>
</head>
<body>

	<%@ include file="../include/header.jsp" %>
	
	<form action="boardEnroll" method="POST">
		<input type="text" name="title">
		<input type="text" name="writer">
		<textarea name="content"></textarea>
		<input type="submit">
	</form>

</body>
</html>