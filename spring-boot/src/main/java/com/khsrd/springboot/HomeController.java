package com.khsrd.springboot;

import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


import com.khsrd.springboot.model.User;

@Controller
public class HomeController {

	@RequestMapping(value = {"/home","/"})
	public String index(Model model) {
		User user = new User(1,"Torang","M","Image.png");
		model.addAttribute("user", user);
		return "home";
	}
	
	@RequestMapping(value = "/about")
	public String about() {
		return "about";
	}
	
	@RequestMapping("/user")//user?name=parameter
	@ResponseBody
	public String getUser(@RequestParam(name ="name" , required=false, defaultValue="name") String name) {
		return name;
	}
	
	@RequestMapping("/user/{id}")
	@ResponseBody
	public String getUserId(@PathVariable("id")String id) {
		return id;
	}
}
