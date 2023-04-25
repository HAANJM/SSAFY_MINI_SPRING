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
	
	<h2>유 저 정 보</h2>
	<table border="1px solid salmon">
		<thead>
			<th>항목</th>
			<th>정보</th>
		</thead>
		<tbody>
			<tr>
				<td>아이디</td>
				<td>${loginUser.id}</td>
			</tr>
			<tr>
				<td>이름</td>
				<td>${loginUser.name}</td>
			</tr>
			<tr>
				<td>이메일</td>
				<td>${loginUser.email}</td>
			</tr>
			<tr>
				<td>전화번호</td>
				<td>${loginUser.phone}</td>
			</tr>
			<tr>
				<td>등급</td>
				<c:choose>
					<c:when test="${loginUser.grade eq \"USER\"}">
						<td>일반 회원</td>
					</c:when>
					<c:when test="${loginUser.grade eq \"ADMIN\"}">
						<td>관리자</td>
					</c:when>
				</c:choose>
			</tr>
			<tr>
				<td>회원 생성일</td>
				<td>${loginUser.createTime}</td>
			</tr>
		</tbody>
	
	</table>

</body>
</html>