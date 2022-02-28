package com.cos.photogramstart.web;

import javax.servlet.http.HttpServletRequest;

import javax.validation.Valid;

import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.cos.photogramstart.domain.user.User;
import com.cos.photogramstart.service.AuthService;
import com.cos.photogramstart.web.dto.auth.SignupDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor 
@Controller 
public class AuthController {

	private final AuthService authService;

	private static final org.slf4j.Logger log = LoggerFactory.getLogger(AuthController.class);
	
	//로그인  +result 추가하기 
	@RequestMapping("/TestLogin")
	public void androidTestWithRequest(HttpServletRequest request){
	System.out.println("로그인 성공");
	System.out.println("id:" + request.getParameter("userid"));
	System.out.println("pw:" +request.getParameter("userpw"));
	
	
	}


	
	//회원가입 
	@PostMapping("/auth/signup")
	public String signup(@Valid SignupDto signupDto, BindingResult bindingResult) { // key=value (x-www-form-urlencoded)

		User user = signupDto.toEntity();
		// 로그 남기기 
		log.info(user.toString());

			
		authService.회원가입(user);

		// 로그를 남기는 후처리!!
		return "auth/signin";

	}
}
