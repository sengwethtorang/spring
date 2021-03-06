package com.khsrd.springboot.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.khsrd.springboot.service.CustomUserDetailService;


@Configuration
@EnableWebSecurity
public class ConfigurationMVC extends WebSecurityConfigurerAdapter {

	@Autowired
	private CustomAuthenticationSuccessHandler successHandler;
	@Autowired
	private CustomEntrypoint authenticationEntryPoint;
	@Autowired
	private CustomUserDetailService userDetailsService;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// TODO Auto-generated method stub
//		auth.inMemoryAuthentication()
//		.withUser("user").password("123").roles("USER").and()
//		.withUser("dba").password("123").roles("DBA").and()
//		.withUser("admin").password("123").roles("ADMIN");
		auth.userDetailsService(userDetailsService);
	}
	
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		// TODO Auto-generated method stub
//		http.formLogin();
//	
//		http.authorizeRequests().antMatchers("/admin/**").hasRole("ADMIN")
//		.antMatchers("/dba/**").hasAnyRole("ADMIN","DBA")
//		.antMatchers("/user/**").hasAnyRole("ADMIN","DBA","USER");
//	}
	
	
		@Override
		protected void configure(HttpSecurity http) throws Exception {
			
			// TODO Auto-generated method stub
			http.formLogin().loginPage("/login").permitAll().successHandler(successHandler);
			http.logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout"));
	//		http.csrf().disable();
			http.authorizeRequests().anyRequest().authenticated();
			http.exceptionHandling().authenticationEntryPoint(authenticationEntryPoint);
		}
		
		@Override
		public void configure(WebSecurity web) throws Exception {
			// TODO Auto-generated method stub
			web.ignoring().antMatchers("/assets/**").antMatchers("/webjars/**");
		}
	
}
