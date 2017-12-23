package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController{
	
	@GetMapping(value = "/")
	public String home(Model model) {
		return "home";
	}
	
	@GetMapping(value = "/login")
	public String getLogin(Model model) {
		return "login";
	}
	
	@RequestMapping(value = "/user/dashboard")
	public String getUser(Model model) {
		return "/user/dashboard";
	}
	
	@RequestMapping(value = "/admin/dashboard")
	public String getAdmin(Model model) {
		return "/admin/dashboard";
	}
	@RequestMapping(value = "/dba/dashboard")
	public String getDBa(Model model) {
		return "/dba/dashboard";
	}
	
}
