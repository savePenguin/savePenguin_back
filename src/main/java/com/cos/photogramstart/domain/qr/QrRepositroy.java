package com.cos.photogramstart.domain.qr;


import org.springframework.data.jpa.repository.JpaRepository;

import com.cos.photogramstart.domain.user.User;

//서비스 만들고 DB저장하기 위
//어노테이션이 없어도 JpaRepository를 상속하면 IoC 등록이 자동으로 된다.
public interface QrRepositroy extends JpaRepository<User, Integer>{ //<user, 타입 >
	// JPA query method
	User findByUsername(String username);
}