package com.ssafy.mini.controller;

import javax.servlet.http.HttpSession;

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
	public String dologin(User user, Model model, HttpSession session) {
		
		user.setPassword(encrypt.getEncrypt(user.getPassword()));

		User loginUser = userService.selectOne(user.getId());
		
		if(loginUser != null && loginUser.getPassword().equals(user.getPassword())) {
			session.setAttribute("loginUser", loginUser);
			model.addAttribute("msg", "로그인 성공");
			return "redirect:/";
		}else {
			model.addAttribute("msg", "다시 시도해주세요.");
			return "/index";
		}
		
		
	}
	
	@GetMapping("registUser")
	public String registForm() {
		return "user/registForm";
	}
	
	@PostMapping("registUser")
	public String registUser(User user, String checkPassword, Model model) {

		// 회원가입 폼에서 이메일 아이디 부분과 도메인 부분을 나누어서 입력받았기 때문에 합쳐서 email 필드에 넣어준다
		user.setEmail(user.getEmailFirst()+"@"+user.getEmailLast());
		
		// 어느부분이 틀렸는지 알 수 있게 일부러 모든 경우의 에러메시지를 출력하게 했습니다
		// 비밀번호와 확인 비밀번호가 일치하지 않을때
		if(!user.getPassword().equals(checkPassword)) {
			model.addAttribute("msg", "비밀번호가 일치하지 않습니다.");
			return "user/registForm";
		// 비밀번호 조건에 맞지 않을 때
		}else if(!rCheck.passCheck(user.getPassword(), user.getId())){
			model.addAttribute("msg", "비밀번호는 8~16자 영문 대 소문자, 숫자, 특수문자를 사용하세요.");
			return "user/registForm";
		}
		
		// 이메일 조건에 맞지 않을 때
		if(!rCheck.emailCheck(user.getEmail())) {
			model.addAttribute("msg", "이메일이 올바르지 않습니다.");
			return "user/registForm";
		}
		
		// 전화번호를 올바르게 입력하지 않았을 때
		// 최근에는 회원가입 시 전화번호로 바로 개인 인증을 하는 경우가 많기 때문에 전화번호가 틀리면 인증 부분에서 막힌다
		// 우리는 아직 번호 인증을 하지 않기 때문에 전화번호 조건 검사를 넣었다
		if(!rCheck.phoneCheck(user.getPhone())) {
			model.addAttribute("msg", "전화번호가 올바르지 않습니다.");
			return "user/registForm";
		}
		
		// 위와 같은 조건들을 통과했다면 비밀번호를 암호화한다
		user.setPassword(encrypt.getEncrypt(user.getPassword()));
		
		// 등록 insert 쿼리문의 반환값이 0보다 크다면 정상적으로 처리되었다는 뜻
		// 하나의 유저만 회원가입하는 것이니 정확한 반환값은 1이 될 것이다
		if(userService.insertUser(user) > 0) {
			model.addAttribute("msg", "회원가입이 정상적으로 처리되었습니다. 로그인을 해주세요.");
			return "user/loginForm";
		}else { // 그러한 반환값이 아니라면 문제가 생겼다는 뜻
			model.addAttribute("msg", "회원가입이 처리되지 않았습니다. 다시 시도해주세요.");
			return "user/registForm";
		}
		
	}
	
	@GetMapping("myPage")
	public String myPage() {
		return "user/myPage";
	}
	
	@GetMapping("logout")
	public String doLogout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}

}
