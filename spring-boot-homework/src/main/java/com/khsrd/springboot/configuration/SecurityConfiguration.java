package com.khsrd.springboot.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.khsrd.springboot.service.CustomUserDetailService;




@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	private CustomAuthenticationSuccessHandler successHandler;
	@Autowired
	private CustomEntrypoint authenticationEntryPoint;
	@Autowired
	private CustomUserDetailService userDetailsService;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// TODO Auto-generated method stub
		auth.userDetailsService(userDetailsService);
	}
		
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		// TODO Auto-generated method stub
		http.formLogin().loginPage("/login").permitAll().successHandler(successHandler);
		http.logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout"));
		http
		.authorizeRequests()
			.anyRequest().authenticated();
		http.exceptionHandling().authenticationEntryPoint(authenticationEntryPoint);
	}
	
}
