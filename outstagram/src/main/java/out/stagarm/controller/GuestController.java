package out.stagarm.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import out.stagarm.domain.User;
import out.stagarm.model.UserRegistrationModel;
import out.stagarm.service.UserService;

@Controller
public class GuestController {

	@Autowired
	UserService userService;

	// @GetMapping("/") public String main() { return "/"; }

	@RequestMapping("/")
	public String mainpage() throws Exception {
		System.out.println("메인안녕");
		return "/guest/login";
	}

	
	  @RequestMapping("/guest/login") 
	  //@RequestMapping({ "/", "/guest/login" }) 
	  // 이렇게 되면 localhost:8080에 접속해도 이 페이지 나옴
	  public String login(Model model,Principal principal) throws Exception{
	  
	  
	  
	  String userId=SecurityContextHolder.getContext().getAuthentication().getName();
	 
	 
	  
	  System.out.println("로그인성공");
	  
	  
	  model.addAttribute("user",userService.findByUserId(userId));
	  
	  System.out.println(userId);
	  

	
	  
	  
	  return "/main"; 
	  }
	  
	  
	/*
	 * @RequestMapping("/main") public String mainPage(Model model) throws
	 * Exception{ //현재 로그인되어있는 유저의 아이디를 구해주는 메소드 String
	 * userId=SecurityContextHolder.getContext().getAuthentication().getName();
	 * 
	 * model.addAttribute("user",userService.findByUserId(userId));
	 * 
	 * return "/main"; }
	 */
	 
	// 회원가입 페이지로감
	@RequestMapping(value = "/guest/register", method = RequestMethod.GET)
	public String register(UserRegistrationModel userModel, Model model) {

		return "/guest/register";
	}

	@PostMapping("/guest/register")
	public String register(UserRegistrationModel userModel, Model model, BindingResult bindingResult) throws Exception {

		if (userService.hasErrors(userModel, bindingResult)) {
			return "/guest/register";
		}

		userService.save(userModel);

		return "redirect:/";

	}

	/*
	 * @GetMapping("/login_processing") public String oneuser(Model model, User
	 * user) { String userId =
	 * SecurityContextHolder.getContext().getAuthentication().getName();
	 * 
	 * System.out.println("로그인성공");
	 * 
	 * model.addAttribute("user", userService.findByUserId(userId));
	 * 
	 * System.out.println(userId);
	 * 
	 * return "/main"; }
	 */
}
