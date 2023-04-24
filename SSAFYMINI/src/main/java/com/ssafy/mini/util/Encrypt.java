package com.ssafy.mini.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.springframework.stereotype.Component;

@Component
public class Encrypt {
	
	// password : 우리가 입력할 비밀번호
	public String getEncrypt(String password) {
		
		String result = "";
		
		try {
			
			// SHA256 알고리즘 객체 생성
			// MessageDigest : 자바에 내장된 암호화를 도와주는 클래스입니다
			MessageDigest md = MessageDigest.getInstance("SHA-256");
			
			// 문자열(우리가 입력한 패스워드)에 SHA256 적용
			md.update(password.getBytes());
			byte[] pwd = md.digest();
			
			// byte to String(10진수의 문자열로 변경)
			StringBuffer sb = new StringBuffer();
			for(byte b : pwd) {
				sb.append(String.format("%02x", b));
			}
			
			result = sb.toString();
			
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// 반환
		return result;
		
	}

}