package com.khsrd.springboot.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.khsrd.springboot.model.User;

@Service
public class UserService {
	
	private List<User> users;
	public List<User> getAllUser(){
		User user = new User(1,"Torang","M","Image.png");
		User user1 = new User(2,"Lyka","F","Image.png");
		User user2 = new User(3,"Torang","M","Image.png");
		User user3 = new User(4,"Lyka","F","Image.png");
		users = new ArrayList<>();
		users.add(user);
		users.add(user1);
		users.add(user2);
		users.add(user3);
		return users;
	}
	
	public User getUserById(int id) {
		return users.get(id);
	}
}
