package com.ssafy.mini.controller;

import java.util.List;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.ssafy.mini.model.dto.Board;
import com.ssafy.mini.model.dto.User;
import com.ssafy.mini.model.service.BoardService;
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
	
	@Autowired
	private BoardService boardService;
	
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
	
	@PostMapping("deleteUser")
	public String doDeleteUser(boolean deleteCheck, String deletePass, String deletePassCheck, HttpSession session, Model model) {
		
		// 원래는 자바스크립트로 일차적인 검사를 하고 넘어와야하는데
		// 자바스크립트로 하지 않아서 이것저것 파라미터를 많이 들고왔다
		
		User loginUser = (User) session.getAttribute("loginUser");
		
		// 로그인유저가 널이면 잘못된 접근
		if(loginUser == null) {
			model.addAttribute("msg", "잘못댐!!!");
			return "redirect:/";
		}
		
		// 비밀번호와 비밀번호 재확인이 틀리면 안댐
		if(!deletePass.equals(deletePassCheck)) {
			model.addAttribute("msg", "비밀번호가 일치하지 않음!!");
			return "redirect:/";
		}
		
		// DB의 회원 비밀번호와 비교하기 위해 deletePass를 암호화한다
		
		deletePass = encrypt.getEncrypt(deletePass);
		
		if(!deletePass.equals(loginUser.getPassword())) {
			model.addAttribute("msg", "비밀번호가 일치하지 않음!!");
			return "redirect:/";
		}
		
		int result = userService.deleteUser(loginUser.getId());
		
		if(result > 0) {
			model.addAttribute("msg", "정상적으로 탈퇴되었습니다!!!");
			return "redirect:/";
		}else {
			model.addAttribute("msg", "뭔가 이상한데요? 아무튼 안된거같음...");
			return "redirect:/";
		}
		
	}
	
	@GetMapping("sendEmail")
	public String sendEmail(Model model) {
		
		// 0. 수신자 설정
		// 랜덤 변수를 만들어서 발생시키고 싶다면 생성하고 반환한다
		String recipient = "ssafy@gmail.com";
        String code = "abc";
        int randomCode = (int)((Math.random() + 1) * 100000 ); // 랜덤 여섯자리 숫자
 
        // 1. 발신자의 메일 계정과 비밀번호 설정
        final String user = "ssafy@naver.com";
        final String password = "****";
 
        // 2. Property에 SMTP 서버 정보 설정
        Properties prop = new Properties();
        prop.put("mail.smtp.host", "smtp.naver.com");
        prop.put("mail.smtp.port", 587); // 발신자 메일이 네이버일때 587 구글 465
        prop.put("mail.smtp.auth", "true");
        // 발신자 메일이 네이버일때는 아래 두 줄을 포함시키면 안된다
        // 발신자 메일이 구글일때는 아래 두 줄을 포함시켜야한다!
//        prop.put("mail.smtp.ssl.enable", "true");
//        prop.put("mail.smtp.ssl.trust", "smtp.gmail.com");
 
        // 3. SMTP 서버정보와 사용자 정보를 기반으로 Session 클래스의 인스턴스 생성
        Session session = Session.getDefaultInstance(prop, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(user, password);
            }
        });
 
        // 4. Message 클래스의 객체를 사용하여 수신자와 내용, 제목의 메시지를 작성한다.
        // 5. Transport 클래스를 사용하여 작성한 메세지를 전달한다.
 
        MimeMessage message = new MimeMessage(session);
        try {
            message.setFrom(new InternetAddress(user));
 
            // 수신자 메일 주소
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(recipient));
 
            // Subject(제목)
            message.setSubject("SSAFY 9기 5반입니다..");
 
            // Text(본문)
            message.setText("사실 코드 테스트용 메일이지롱~ : " + randomCode);
 
            Transport.send(message);    // send message
            model.addAttribute("msg", "이메일 발송 성공!");
 
        } catch (AddressException e) {
            e.printStackTrace();
        } catch (MessagingException e) {
            e.printStackTrace();
        }
		
        return "/index";
		
	}
	
	@GetMapping("list")
	public String getBoardList(Model model) {
		
		List<Board> boardList = boardService.selectBoardList();
		
		model.addAttribute("boardList", boardList);
		
		return "list";
		
	}

}
