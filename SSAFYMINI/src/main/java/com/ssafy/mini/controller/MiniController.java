package com.ssafy.mini.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.ssafy.mini.model.dto.User;
import com.ssafy.mini.model.service.UserService;
import com.ssafy.mini.util.Encrypt;
import com.ssafy.mini.util.RegistCheck;

@Controller
public class MiniController {
	
	@Autowired
	private Encrypt encrypt;
	
	@Autowired
	private RegistCheck rCheck;
	
	@Autowired
	private UserService userService;
	
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
	public String registUser(User user, String checkPassword, Model model) {
		
		System.out.println(user.getPassword());
		user.setEmail(user.getEmailFirst()+"@"+user.getEmailLast());
		
		if(!user.getPassword().equals(checkPassword)) {
			model.addAttribute("msg", "비밀번호가 일치하지 않습니다.");
			return "user/registForm";
		}else if(!rCheck.passCheck(user.getPassword(), user.getId())){
			model.addAttribute("msg", "비밀번호는 8~16자 영문 대 소문자, 숫자, 특수문자를 사용하세요.");
			return "user/registForm";
		}
		
		if(!rCheck.emailCheck(user.getEmail())) {
			model.addAttribute("msg", "이메일이 올바르지 않습니다.");
			return "user/registForm";
		}
		
		if(!rCheck.phoneCheck(user.getPhone())) {
			model.addAttribute("msg", "전화번호가 올바르지 않습니다.");
			return "user/registForm";
		}
		
		user.setPassword(encrypt.getEncrypt(user.getPassword()));
		
		if(userService.insertUser(user) > 0) {
			model.addAttribute("msg", "회원가입이 정상적으로 처리되었습니다. 로그인을 해주세요.");
			return "user/loginForm";
		}else {
			model.addAttribute("msg", "회원가입이 처리되지 않았습니다. 다시 시도해주세요.");
			return "user/registForm";
		}
		
	}
	
	@GetMapping("myPage")
	public String myPage() {
		return "user/myPage";
	}

}
