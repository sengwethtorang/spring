package com;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	public HomeController() {
		// TODO Auto-generated constructor stub
		System.out.println("Home COntroller");
	}
	
	@RequestMapping("/index")
	public String hello() {
		return "home";
	}
	
}
