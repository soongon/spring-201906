package kr.re.kitri.hellospring.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.re.kitri.hellospring.annotation.TokenRequired;
import kr.re.kitri.hellospring.model.User;
import kr.re.kitri.hellospring.service.SecurityService;
import kr.re.kitri.hellospring.service.UserService;

@Controller
@ResponseBody
public class UserController {
	
	private static final Logger log = 
			LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private SecurityService securityService;
	
	@GetMapping("/greet")
	@ResponseBody
	public String hello() {
		return "Hello World";
	}
	
	// 사용자 전체보기
	@TokenRequired
	@GetMapping("/users")
	public List<User> getAllUsers() {
		return userService.searchUsers();
	}
	
	// 사용자 상세보기
	@TokenRequired
	@GetMapping("/users/{userId}")
	public User getUsersById(@PathVariable Integer userId) {
		System.out.println(userId + " .. from path variable");
		return userService.searchUserByUserid(userId);
		
	}

	// 사용자 등록
	@PostMapping("/users")
	public User registUser(@RequestBody User user) {
		log.debug("사용자 등록 시작");
		return userService.registUser(user);
	}
	
	// 사용자 조회 by username
	@GetMapping("/users/username/{username}")
	public List<User> searchUserByUsername(@PathVariable String username) {
		return userService.searchUserByUsername(username);
	}
	
	
	
	
	// 사용자 수정
	// 사용자 삭제
	
	
}



