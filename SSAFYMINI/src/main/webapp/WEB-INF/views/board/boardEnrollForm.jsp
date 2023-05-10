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
		<label for="title">제목</label>
		<input type="text" id="title" name="title"> <br>
		<label for="writer">작성자</label>
		<input type="text" id="writer" name="writer"> <br>
		<label for="content">본문</label>
		<textarea id="writer" name="content"></textarea> <br>
		<input type="submit">
	</form>

</body>
</html>