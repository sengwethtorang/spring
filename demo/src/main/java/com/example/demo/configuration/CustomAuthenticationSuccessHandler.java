package com.example.demo.configuration;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import com.example.demo.model.CustomUserDetail;
import com.example.demo.model.User;


@Component
public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler{

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication auth)
			throws IOException, ServletException {
		System.out.println("Login Success");
		String url = (String) request.getSession().getAttribute("REQUEST_URL");
		CustomUserDetail customUserDetail = (CustomUserDetail) auth.getPrincipal();
		
		System.out.println(customUserDetail.getUser());
		if(url == null) {
			for (GrantedAuthority item : auth.getAuthorities()) {
				System.out.println("Role :"+ item.getAuthority());
				if(item.getAuthority().equals("ROLE_ADMIN")) {
					url ="/admin";
				}else if(item.getAuthority().equals("ROLE_DBA")) {
					url ="/dba";
				}else if(item.getAuthority().equals("ROLE_USER")) {
					url ="/user";
				}
			}
			
		}
		response.sendRedirect(url);
	}

}
