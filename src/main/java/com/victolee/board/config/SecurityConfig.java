package com.victolee.board.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.victolee.board.service.MemberService;

import org.springframework.security.crypto.password.PasswordEncoder;

import lombok.AllArgsConstructor;

@Configuration
@EnableWebSecurity
@AllArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter  {
	
	//@EnableWebSecurity
	/*
	 * @Configuration 클래스에 @EnableWebSecurity 어노테이션을 추가하여 Spring Security 설정할 클래스라고
	 * 정의합니다. 설정은 WebSebSecurityConfigurerAdapter 클래스를 상속받아 메서드를 구현하는 것이 일반적인 방법입니다.
	 */
	 
	
	//WebSecurityConfigurerAdapter :WebSecurityConfigurer 인스턴스를 편리하게 생성하기 위한 클래스입니다.
	
	private MemberService memberService;
	
	@Bean
	public PasswordEncoder PasswordEncoder() {
		return new BCryptPasswordEncoder();
		
		/*
		 * passwordEncoder() BCryptPasswordEncoder는 Spring Security에서 제공하는 비밀번호 암호화
		 * 객체입니다. Service에서 비밀번호를 암호화할 수 있도록 Bean으로 등록합니다.
		 */

	}
	
	@Override
	public void configure(WebSecurity web) throws Exception
	{
		 // static 디렉터리의 하위 파일 목록은 인증 무시 ( = 항상통과 )
		//WebSecurity는 FilterChainProxy를 생성하는 필터
		web.ignoring().antMatchers("/css/**", "/js/**", "/img/**", "/lib/**");
	}
	

	@Override
	public void configure(HttpSecurity http) throws Exception{
		//http.httpBasic().disable();
		
		
		http.authorizeRequests()
		//페이지 권한설정
				
				.antMatchers("/admin/**").hasRole("ADMIN")
				  .antMatchers("/admin/**").hasRole("ADMIN")
				  .antMatchers("/user/myinfo").hasRole("MEMBER")
				  .antMatchers("/**").permitAll()
				 
         
         
         .and() // 로그인 설정
		         .formLogin()
				.loginPage("/user/login")
				.defaultSuccessUrl("/user/login/result")
				.permitAll()
				
				//formlogin() : from기반으로 인증을 하도록 합니다. 로그인 정보는 기본적으로 HttpSession을 이용합니다.
		.and() // 로그아웃 설정
		        .logout()
				.logoutRequestMatcher(new AntPathRequestMatcher("/user/logout"))
				.logoutSuccessUrl("/user/logout/result")
				.invalidateHttpSession(true)
		.and()
			// 403 예외처리 핸들링
        .exceptionHandling().accessDeniedPage("/user/denied");
		}
	 @Override
	    public void configure(AuthenticationManagerBuilder auth) throws Exception {
	        auth.userDetailsService(memberService).passwordEncoder(PasswordEncoder());
	    }
	

}
