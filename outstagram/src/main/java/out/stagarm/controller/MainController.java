package out.stagarm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import out.stagarm.service.UserService;

@Controller
public class MainController {
	
	@Autowired
	UserService userService;
	
	
	/*
	 * @RequestMapping("/main") 
	 * public String mainPage(Model model) throws
	 * Exception{ //현재 로그인되어있는 유저의 아이디를 구해주는 메소드 String
	 * userId=SecurityContextHolder.getContext().getAuthentication().getName();
	 * 
	 * model.addAttribute("user",userService.findByUserId(userId));
	 * 
	 * return "/main"; }
	 */
	
	@RequestMapping("/main/user/{id}")
	public String main_user(@PathVariable("id") int id,Model model ) throws Exception{
		String userId=SecurityContextHolder.getContext().getAuthentication().getName();
		model.addAttribute("user",userService.findByUserId(userId));
		
		return "/main/user";
		
	}
	
	

}
