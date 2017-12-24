package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.model.Role;
import com.example.demo.repository.UserRepository;

@Controller
public class HomeController{
	
	@Autowired
	private UserRepository user;
	
	@GetMapping(value = "/")
	public String home(Model model) {
		return "home";
	}
	
	@GetMapping(value = "/login")
	public String getLogin(Model model) {
		return "login";
	}
	
	@RequestMapping(value = "/user")
	public String getUser(Model model) {
		return "/user/dashboard";
	}
	
	@RequestMapping(value = "/admin")
	public String getAdmin(Model model) {
		return "/admin/dashboard";
	}
	@RequestMapping(value = "/dba")
	public String getDBa(Model model) {
		return "/dba/dashboard";
	}
	
	@GetMapping(value="/data")
	@ResponseBody
	public List<Role> getRole(){
		return user.getRoles();
	}
}
