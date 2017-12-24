package com.example.demo.configuration;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

@Component
public class CustomEntrypoint implements AuthenticationEntryPoint{

	@Override
	public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException auth)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		System.out.println("Rqequest Url :"+ request.getRequestURL());
		request.getSession().setAttribute("REQUEST_URL", request.getRequestURL().toString());
		response.sendRedirect("/login");
		
	}

}
