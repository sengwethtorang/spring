package com.khsrd.springboot.controller;


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
		
		model.addAttribute("user", userService.getUserById(id));
		return "about";
	}
	
	@RequestMapping(value ="/user/add",method=RequestMethod.GET)
	public String getInput(Model model) {
		model.addAttribute("user", new User());
		model.addAttribute("status", true);
		return "edit";
	}
	
	@RequestMapping(value ="/edit/{id}")
	public String getInput(Model model,@PathVariable("id")int id) {
		User user = userService.getUserById(id);
		model.addAttribute("user", user);
		model.addAttribute("status", false);
		return "edit";
	}
	@RequestMapping(value="/user/update", method= RequestMethod.POST)
	public String postUpdate(@ModelAttribute("user") User user) {
		userService.updateUser(user);
		//System.out.println("AAAAAAAAAAAAA");
		return "redirect:/home";
	}
	
	@RequestMapping(value = "/user/add", method= RequestMethod.POST)
	
	public String getAdd(@ModelAttribute("user") User user) {
		userService.addUser(user);
		return "redirect:/home";
	}
	
	@RequestMapping(value = "/remove/{id}", method= RequestMethod.GET)
	public String getAdd(@PathVariable("id")int id) {
		userService.delete(id);
		return "redirect:/home";
	}
	
	@RequestMapping("/user")//user?name=parameter
	@ResponseBody
	public String getUser(@RequestParam(name ="name" , required=false, defaultValue="name") String name) {
		return name;
	}
	
//	@RequestMapping("/user/{id}")
//	@ResponseBody
//	public String getUserId(@PathVariable("id")String id) {
//		return id;
//	}
	
	
	
	
//	public void data () {
//		
//		users.add(user);
//		users.add(user1);
//		users.add(user2);
//		users.add(user3);
//	}
}
