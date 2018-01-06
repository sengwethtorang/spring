package com.khsrd.springboot.repository;

import java.util.List;

import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.khsrd.springboot.model.User;

public interface UserRepository {
	public List<User> getAllUser();
	public User getUserById(int id);
	
	public void addUser(User user);
	public void updateUser(User user);
	public void delete(int id);

}
