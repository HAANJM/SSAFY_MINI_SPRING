<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SSAFY MINI</title>
<style>
.regist{
	width : 600px;
	display : inline-block;
	margin : auto;
}
input::-webkit-outer-spin-button,
input::-webkit-inner-spin-button {
  -webkit-appearance: none;
  margin: 0;
}
</style>
</head>
<body>
	<%@ include file="../include/header.jsp" %>
	<script>
		
	
	</script>
	<div class="regist">
		<form method="post" id="registForm" onsubmit="return false;"> 
		<div class="input-group mb-3">
	 		<span class="input-group-text" id="basic-addon1">아이디</span>
	 		<input type="text" name="id" class="form-control" placeholder="아이디" aria-label="Username" aria-describedby="basic-addon1">
	 		<span class="input-group-text" id="idCheck">아이디 중복 검사</span>
		</div>
		
		<div class="input-group mb-3">
	 		<span class="input-group-text" id="basic-addon1">비밀번호</span>
	 		<input type="password" id="passFirst" name="password" class="form-control" placeholder="비밀번호는 대,소문자와 숫자, 특수문자를 포함하여 생성해주세요" aria-label="Username" aria-describedby="basic-addon1">
		</div>
		
		<div class="input-group mb-3">
	 		<span class="input-group-text" id="basic-addon1">비밀번호 확인</span>
	 		<input type="password" id="passSecond" name="checkPassword" class="form-control" placeholder="비밀번호 확인" aria-label="Username" aria-describedby="basic-addon1">
		</div>
		
		<div class="input-group mb-3">
	 		<span class="input-group-text" id="basic-addon1">이름</span>
	 		<input type="text" name="name" class="form-control" placeholder="이름" aria-label="Username" aria-describedby="basic-addon1">
		</div>
		
		<div class="input-group mb-3">
		  <label class="input-group-text" for="inputGroupSelect01">성별</label>
		  <select class="form-select" id="inputGroupSelect01" name="gender">
		    <option selected>성별</option>
		    <option value="M">남성</option>
		    <option value="F">여성</option>
		  </select>
		</div>
		
		<div class="input-group mb-3">
			<span class="input-group-text" id="basic-addon1">이메일</span>
		 	<input type="text" name="emailFirst" class="form-control" placeholder="이메일" aria-label="Recipient's username" aria-describedby="basic-addon2">
		  	<span class="input-group-text" id="basic-addon2">@</span>
		  	<select name="emailLast">
		  		<option value="naver.com">naver.com</option>
		  		<option value="gmail.com">gmail.com</option>
		  		<option value="daum.net">daum.net</option>
		  		<option value="hanmail.net">hanmail.net</option>
		  	</select>
		</div>
		
		<div class="input-group mb-3">
	 		<span class="input-group-text" id="basic-addon1">전화번호</span>
	 		<input type="number" name="phone" class="form-control" aria-label="Username" aria-describedby="basic-addon1">
		</div>
		
		<div class="input-group mb-1">
	 		<span class="input-group-text" id="basic-addon1">생년월일</span>
	 		<input type="text" name="year" placeholder="년" min="1900" max="2023" class="form-control" aria-label="Username" aria-describedby="basic-addon1"> 
	 		<select name="month">
	 			<option value="월">월</option>
	 			<option value="1">1</option>
	 			<option value="2">2</option>
	 			<option value="3">3</option>
	 			<option value="4">4</option>
	 			<option value="5">5</option>
	 			<option value="6">6</option>
	 			<option value="7">7</option>
	 			<option value="8">8</option>
	 			<option value="9">9</option>
	 			<option value="10">10</option>
	 			<option value="11">11</option>
	 			<option value="12">12</option>
	 		</select>  
	 		<input type="number" name="day" placeholder="일" min="1" max="31" class="form-control" aria-label="Username" aria-describedby="basic-addon1">
		</div>
		<div>
			<input type="submit" id="registBtn" class="btn btn-success" value="회원 가입">
		</div>
		</form>
	</div>	
	
	<div>
		<div>
			비밀번호 일치 여부 : <h6 id="passCheckFirst"></h6>
		</div>
		<div>
			비밀번호 양식 일치 여부 : <h6 id="passCheckSecond"></h6>
		</div>
		
	</div>

	<script>
		
		window.addEventListener("keyup", (e) => {
			// 비밀번호 재확인 일치 여부
			let passFirst = document.getElementById("passFirst").value;
			let passSecond = document.getElementById("passSecond").value;

			let checkFirst = document.getElementById("passCheckFirst");
			let checkSecond = document.getElementById("passCheckSecond");

			if(passFirst == passSecond){
				checkFirst.innerText = "일치함!!!!";
			}
			else{
				checkFirst.innerText = "일치안함!!!!";
			};

			// 비밀번호가 양식에 맞는지 여부
			const regex = /(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[^A-Za-z0-9])(?=.{8,16})/;

			if(regex.test(passFirst)){
				checkSecond.innerText = "비밀번호 보안 높음";
			}
			else{
				checkSecond.innerText = "비밀번호 보안 약함";
			}

			let registForm = document.querySelector("#registForm");
			let registBtn = document.querySelector("#registBtn");

			if(passFirst == passSecond && regex.test(passFirst)){
				registForm.setAttribute('action', 'registUser');
			}
			else{
				registBtn.addEventListener("click", ()=>{
					alert("비밀번호 제대로 입력해봐요~");
				});
				return false;
			}

		});

	</script>

</body>
</html>