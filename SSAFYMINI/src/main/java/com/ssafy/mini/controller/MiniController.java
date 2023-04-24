package com.ssafy.mini.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.ssafy.mini.model.dto.User;
import com.ssafy.mini.util.Encrypt;

@Controller
public class MiniController {
	
	@Autowired
	private Encrypt encrypt;
	
	@GetMapping({"/", "index"})
	public String showIndex() {
		return "/index";
	}
	
	@GetMapping("login")
	public String loginForm() {
		return "user/loginForm";
	}
	
	@PostMapping("login")
	public String dologin(User user) {
		
		return null;
		
	}
	
	@GetMapping("registUser")
	public String registForm() {
		return "user/registForm";
	}
	
	@PostMapping("registUser")
	public String registUser(User user) {
		
		System.out.println(user);
		
		return null;
	}
	
	@GetMapping("myPage")
	public String myPage() {
		return "user/myPage";
	}

}
