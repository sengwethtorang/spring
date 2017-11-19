package com.khsrd.springboot;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


import com.khsrd.springboot.model.User;

@Controller
public class HomeController {
	User user = new User(1,"Torang","M","Image.png");
	User user1 = new User(2,"Lyka","F","Image.png");
	User user2 = new User(3,"Torang","M","Image.png");
	User user3 = new User(4,"Lyka","F","Image.png");
	
	@RequestMapping(value = {"/home","/"})
	public String index(Model model) {
		//this.data();
		List<User> users = new ArrayList<>();
		users.add(user);
		users.add(user1);
		users.add(user2);
		users.add(user3);
		model.addAttribute("user", user);
		model.addAttribute("users", users);
		model.addAttribute("name", "<b>Hello</b>");
		return "home";
	}
	
	@RequestMapping(value = "/detail/{id}")
	public String about(@PathVariable("id")int id,Model model) {
		List<User> users = new ArrayList<>();
		users.add(user);
		users.add(user1);
		users.add(user2);
		users.add(user3);
		
		model.addAttribute("user", users.get(id-1));
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
