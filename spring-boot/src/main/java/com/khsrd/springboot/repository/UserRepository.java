package com.khsrd.springboot.repository;

import java.util.List;

import com.khsrd.springboot.model.User;

public interface UserRepository {
	public List<User> getAllUser();
	public User getUserById(int id);
	
	public void addUser(User user);
	public void updateUser(User user);
	public void delete(int id);
}
