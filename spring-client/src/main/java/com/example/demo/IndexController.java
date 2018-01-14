package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

	@GetMapping(value = "/home")
	public String getHome() {
		return "index";
	}
	
	@GetMapping(value = "/create")
	public String getCreate() {
		return "create";
	}
}
