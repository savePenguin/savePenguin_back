package com.cos.photogramstart.web;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cos.photogramstart.domain.user.User;
import com.cos.photogramstart.handler.ex.CustomValidationException;
import com.cos.photogramstart.service.AuthService;
import com.cos.photogramstart.web.dto.auth.SignupDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor // final된 필드 모두 DI 할때 사용
@RestController // 1. IoC 2. 파일을 리턴하는 컨트롤러
public class AuthController {

	private final AuthService authService;
	private static final org.slf4j.Logger log = LoggerFactory.getLogger(AuthController.class);
	
	// 의존성 주입 (귀찮은 방법) 
	//public AuthController(AuthService authService) {
		//this.authService = authService; // 있으면 의존성 주입 
		
	//}
	

	@GetMapping("/auth/signin")
	public String signinForm() {
		return "auth/signin 접근 완료";
	}

	@GetMapping("/auth/signup")
	public String signupForm() {
		return "auth/signup 접근 완료";
	}

	// 회원가입버튼 -> /auth/signup -> /auth/signin
	// 회원가입버튼 X
	@PostMapping("/auth/signup")
	public String signup(@Valid SignupDto signupDto, BindingResult bindingResult) { // key=value (x-www-form-urlencoded)

		// 로그 남기기 
		//log.info(signupDto.toString());
		// User < - SignupDto
		User user = signupDto.toEntity();
		// 로그 남기기 
		log.info(user.toString());
		authService.회원가입(user);
		// System.out.println(userEntity);

		// 로그를 남기는 후처리!!
		return "auth/signin";

	}
}
