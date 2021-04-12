package out.stagarm.config;

import org.apache.coyote.http11.Http11AprProtocol;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import out.stagarm.service.MyAuthenticationProvider;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	MyAuthenticationProvider myAuthenticationProvider;
	
	
	//시큐리티 필터 무시하려고 사용하는것 
	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/res/**");
		//res 경로안에는 무시한다 필터
		
		
	}
	
	@Override
	public void configure(HttpSecurity http) throws Exception{
		http.authorizeRequests()
		.antMatchers("/admin/**").hasAuthority("ROLE_ADMIN")
		.antMatchers("/guest/**").permitAll()
		.antMatchers("/").permitAll()
			.antMatchers("/", "/images/**", "/resources/**", "/resources/images/**") 
			.permitAll()
		.antMatchers("/**").authenticated();
		
		http.csrf().disable();
		
		http.formLogin()
        .loginPage("/guest/login")
				/* .loginProcessingUrl("/guest/login_processing") */
		/*
		 * .failureUrl("/guest/login?error") 
		 */
        /*.usernameParameter("userId")
        .passwordParameter("passwd")
        .permitAll(*/;
		

    http.logout()
        .logoutRequestMatcher(new AntPathRequestMatcher("/main/logout_processing"))
        .logoutSuccessUrl("/guest/login")
        .invalidateHttpSession(true);

    http.authenticationProvider(myAuthenticationProvider);
	}

}
