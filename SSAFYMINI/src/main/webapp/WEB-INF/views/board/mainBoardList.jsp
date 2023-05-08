<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SSAFY MINI</title>
</head>
<body>
	<%@ include file="../include/header.jsp" %>

	<h2>게시판이 될거에요</h2>
	
	<hr>
	
	<table>
		<thead>
			<th>게시글 번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>작성일자</th>
			<th>조회수</th>
		</thead>
		<tbody>
		<c:forEach var="board" items="${list}">
			<tr>
				<td>${board.boardNo}</td>
				<td>${board.title}</td>
				<td>${board.writer}</td>
				<td>${board.createDate}</td>
				<td>${board.viewCount}</td>
			</tr>
		</c:forEach>
		</tbody>
	</table>

</body>
</html>