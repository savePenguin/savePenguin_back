package com.cos.photogramstart.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cos.photogramstart.domain.user.User;
import com.cos.photogramstart.domain.user.UserRepository;

import lombok.RequiredArgsConstructor;
// 서비스는 DB에 저장하기 위해!

@RequiredArgsConstructor
@Service // 1. IoC  2. 트랜잭션 관리
public class AuthService {
	
	public void 회원가(User user) {// 통신으로 받은 user
		//회원가입 진행 
		User userEntity = userRepository.save(user); // DB에 잘 들어갔다 응답는

	}
	
	private final UserRepository userRepository;
	private final BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Transactional // Write(Insert, Update, Delete)
	public User 회원가입(User user) throws RuntimeException{
		// 회원가입 진행
		String rawPassword = user.getPassword();
		String encPassword = bCryptPasswordEncoder.encode(rawPassword);
		user.setPassword(encPassword);
		user.setRole("ROLE_USER"); // 관리자 ROLE_ADMIN
		User userEntity = null;
		userEntity = userRepository.save(user);
		
		
		return userEntity;
	}
}
