package com.khsrd.springboot.controller;


import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.khsrd.springboot.model.Role;
import com.khsrd.springboot.model.User;
import com.khsrd.springboot.service.RoleService;
import com.khsrd.springboot.service.UploadFileService;
import com.khsrd.springboot.service.UserService;

@Controller
public class HomeController {
	
	@Autowired
	private UserService userService;
	@Autowired
	private RoleService roleService;
	@Autowired
	private UploadFileService uploadFileService;
	@RequestMapping(value = {"/home","/"})
	public String index(Model model,@RequestParam(required= false ,defaultValue="1") int page) {
		//this.data();
		//userService.getAllUser();
		//model.addAttribute("user", new User());
		System.out.println("Page :"+page);
		model.addAttribute("users", userService.getAllUser(page));
		model.addAttribute("name", "<b>Hello</b>");
		model.addAttribute("prevPage", page);
		return "home";
	}
	
	@GetMapping(value = "/login")
	public String getLogin(Model model) {
		return "login";
	}
	
	@RequestMapping(value = "/detail/{id}")
	public String about(@PathVariable("id")int id,Model model) {
		
		model.addAttribute("user", userService.getUserById(id));
		return "about";
	}
	
	@RequestMapping(value ="/user/add",method=RequestMethod.GET)
	public String getInput(Model model) {
		List<Role> roles = roleService.getRoles();
		System.out.println("Size :"+roles.size());
		model.addAttribute("roles", roles);
		model.addAttribute("user", new User());
		model.addAttribute("status", true);
		return "edit";
	}
	
	@RequestMapping(value ="/edit/{id}")
	public String getInput(Model model,@PathVariable("id")int id) {
		User user = userService.getUserById(id);
		model.addAttribute("roles", roleService.getRoles());
		model.addAttribute("user", user);
		model.addAttribute("status", false);
		return "edit";
	}
	@Transactional
	@RequestMapping(value="/user/update", method= RequestMethod.POST)
	public String postUpdate(@ModelAttribute("user") User user, @RequestParam("file") MultipartFile file) {
		if(file.getSize()!=0 || (!file.isEmpty())) {
			System.out.println("True");
			user.setImage(uploadFileService.uploadFile(file));
		}
		System.out.println("Image"+ user.getImage());
		userService.updateUser(user);
		roleService.deleteRole(user.getId());
		roleService.saveRole(user.getId(), user.getRoles().get(0).getId());
		//System.out.println("AAAAAAAAAAAAA");
		return "redirect:/home";
	}
	
	@RequestMapping(value = "/user/add", method= RequestMethod.POST)
	@Transactional
	public String getAdd(@RequestParam("file") MultipartFile file, @Valid @ModelAttribute("user") User user,BindingResult result,Model model) {
		if(result.hasErrors()) {
			for (FieldError error : result.getFieldErrors()) {
				System.out.println(error.getField());
				System.out.println(error.getDefaultMessage());
			}

			model.addAttribute("user", user);
			model.addAttribute("status", true);
			return "edit";
		}
		
		user.setImage(uploadFileService.uploadFile(file));
		userService.addUser(user);
		roleService.saveRole(user.getId(), user.getRoles().get(0).getId());
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
