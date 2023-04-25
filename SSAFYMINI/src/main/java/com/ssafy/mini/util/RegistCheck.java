package com.ssafy.mini.util;

import java.util.regex.Pattern;

import org.springframework.stereotype.Component;

@Component
public class RegistCheck {
	
	public boolean passCheck(String password, String id) {
		
		// 비밀번호를 최소 8자 최대 16자, 영어 대소문자를 각각 포함하고, 숫자와 특수문자를 최소 1자씩 포함하여 만들었는가
		String pattern = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,16}$";
		
		// 비밀번호에 아이디가 포함되어 있는가
		if(password.contains(id)) {
			return false;
		}
		
		return Pattern.matches(pattern, password);
		
		// 주석처리한 부분은 비밀번호 체크 시 더 고려할 수 있는 부분입니다(인터넷발췌)
		// 한번 참고해보세요
		// 참고 해보세요 ㅎㅎ
		/*
		
				private String checkPassword(String pwd, String id){
		  
				  // 비밀번호 포맷 확인(영문, 특수문자, 숫자 포함 8자 이상)
				  Pattern passPattern1 = Pattern.compile("^(?=.*[a-zA-Z])(?=.*\\d)(?=.*\\W).{8,20}$");
				  Matcher passMatcher1 = passPattern1.matcher(pwd);
				  
				  if(!passMatcher1.find()){
				    return "비밀번호는 영문과 특수문자 숫자를 포함하며 8자 이상이어야 합니다.";
				  }
				  
				  // 반복된 문자 확인
				  Pattern passPattern2 = Pattern.compile("(\\w)\\1\\1\\1");
				  Matcher passMatcher2 = passPattern2.matcher(pwd);
				  
				  if(passMatcher2.find()){
				    return "비밀번호에 동일한 문자를 과도하게 연속해서 사용할 수 없습니다.";
				  }
				  
				  // 아이디 포함 확인
				  if(pwd.contains(id)){
				    return "비밀번호에 ID를 포함할 수 없습니다.";
				  }
				  
				  // 특수문자 확인
				  Pattern passPattern3 = Pattern.compile("\\W");
				  Pattern passPattern4 = Pattern.compile("[!@#$%^*+=-]");
				  
				  for(int i = 0; i < pwd.length(); i++){
				    String s = String.valueOf(pwd.charAt(i));
				    Matcher passMatcher3 = passPattern3.matcher(s);
				    
				    if(passMatcher3.find()){
				      Matcher passMatcher4 = passPattern4.matcher(s);
				      if(!passMatcher4.find()){
				        return "비밀번호에 특수문자는 !@#$^*+=-만 사용 가능합니다.";
				      }
				    }   
				  }
				  
				  //연속된 문자 확인
				  int ascSeqCharCnt = 0; // 오름차순 연속 문자 카운트
				  int descSeqCharCnt = 0; // 내림차순 연속 문자 카운트
				  
				  char char_0;
				  char char_1;
				  char char_2;
				  
				  int diff_0_1;
				  int diff_1_2;
				  
				  for(int i = 0; i < pwd.length()-2; i++){
				    char_0 = pwd.charAt(i);
				    char_1 = pwd.charAt(i+1);
				    char_2 = pwd.charAt(i+2);
				    
				    diff_0_1 = char_0 - char_1;
				    diff_1_2 = char_1 - char_2;
				    
				    if(diff_0_1 == 1 && diff_1_2 == 1){
				      ascSeqCharCnt += 1;
				    }
				    
				    if(diff_0_1 == -1 && diff_1_2 == -1){
				      descSeqCharCnt -= 1;
				    }
				  }
				  
				  if(ascSeqCharCnt > 1 || descSeqCharCnt > 1){
				    return "비밀번호에 연속된 문자열을 사용할 수 없습니다.";
				  }
				  
				  return "";
				}
		
		 
		 * */
		
	}
	
	public boolean emailCheck(String email) {
		
		// 이메일이 aaaa@naver.com 와 같은 형태로 만들어져 있는가
		// 이메일을 입력받을때 아이디 부분과 도메인 부분을 나누어서 컨트롤러에서 합쳤기 때문에 검사해줘야한다
		String pattern = "^[_a-z0-9-]+(.[_a-z0-9-]+)*@(?:\\w+\\.)+\\w+$";
		
		return Pattern.matches(pattern, email);
		
	}
	
	public boolean phoneCheck(String phone) {
		
		// 전화번호가 01012341234 와 같은 형태인지
		// 최근 회원가입들은 전화번호 인증을 하기위해 하이픈(-)을 빼고 입력받는 경우가 많다
		// 그렇기에 이렇게 검사한다
		String pattern = "^01(?:0|1|[6-9])(?:\\d{3}|\\d{4})\\d{4}$";
		
		return Pattern.matches(pattern, phone);
		
	}
	

}
