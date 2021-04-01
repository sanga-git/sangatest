package com.victolee.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.victolee.board.dto.MemberDto;
import com.victolee.board.service.MemberService;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class MemberController {
	
	private MemberService memberService;
	
	//메인페이지
	@GetMapping("/")
	public String index() {
		return "user/index";
		
	}
	
	
	//회원가입 페이지
	@GetMapping("/user/signup")
	public String dispSignup() {
		return "user/signup";
	}
	
	
	//회원가입 처리 
	@PostMapping("/user/signup")
	public String execSignup(MemberDto memberDto) {
		memberService.joinUser(memberDto);
		
		return "redirect:";
	}
	
	
	//로그인페이지 
	@GetMapping("/user/login")
	public String dispLogin() {
		return "user/login";
		
	}
	
	//로그인결과 페이지 
	@GetMapping("/user/login/result")
	public String dispLoginResult() {
		return "user/loginSuccess";
		
	}
	
	//로그아웃 결과 페이지
	@GetMapping("/user/logout/result")
	public String dispLogout() {
		return "user/logout";
	}
	
	//접근 거부 페이지
	@GetMapping("/user/denied")
	public String dispDenied() {
		return "user/denied";
		
	}
	
	//내정보 페이지
	@GetMapping("/user/info")
	public String disMyInfo() {
		return "user/myinfo";
	}
	
	//어드민 페이지
	@GetMapping("/admin")
	public String dispAdmin() {
		return "user/admin";
	}

}
