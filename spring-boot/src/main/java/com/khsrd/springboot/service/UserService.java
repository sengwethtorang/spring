package com.khsrd.springboot.service;

import java.util.List;
import com.khsrd.springboot.model.User;


public interface UserService {
	

	public List<User> getAllUser(int page);
	public User getUserById(int id);
	public void addUser(User user);
	public void updateUser(User user);
	public void delete(int id);
}
