package com.khsrd.springboot;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


import com.khsrd.springboot.model.User;
import com.khsrd.springboot.service.UserService;

@Controller
public class HomeController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = {"/home","/"})
	public String index(Model model) {
		//this.data();
		userService.getAllUser();
		//model.addAttribute("user", new User());
		model.addAttribute("users", userService.getAllUser());
		model.addAttribute("name", "<b>Hello</b>");
		return "home";
	}
	
	@RequestMapping(value = "/detail/{id}")
	public String about(@PathVariable("id")int id,Model model) {
		
		model.addAttribute("user", userService.getUserById(id-1));
		return "about";
	}
	
	@RequestMapping(value ="/input")
	public String getInput(Model model) {
		model.addAttribute("user", new User());
		return "add";
	}
	
	@RequestMapping(value = "/add", method= RequestMethod.POST)
	@ResponseBody
	public User getAdd(@ModelAttribute("user") User user) {
		return user;
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
	
	
//	public void data () {
//		
//		users.add(user);
//		users.add(user1);
//		users.add(user2);
//		users.add(user3);
//	}
}
