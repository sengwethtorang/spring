package com.khsrd.springboot;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {

	@RequestMapping(value = {"/home","/"})
	public String index() {
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
