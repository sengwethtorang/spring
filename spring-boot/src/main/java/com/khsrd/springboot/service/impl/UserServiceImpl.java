package com.khsrd.springboot.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.khsrd.springboot.model.User;
import com.khsrd.springboot.repository.MybatisUserRepository;
import com.khsrd.springboot.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private MybatisUserRepository userRepository;
	@Override
	public List<User> getAllUser(int page) {
		// TODO Auto-generated method stub
		return userRepository.getAllUser(page);
	}

	@Override
	public User getUserById(int id) {
		// TODO Auto-generated method stub
		return userRepository.getUserById(id);
	}

	@Override
	public void addUser(User user) {
		// TODO Auto-generated method stub
		//user.setId(userRepository.getAllUser().size()+1);
		userRepository.addUser(user);
	}

	@Override
	public void updateUser(User user) {
		// TODO Auto-generated method stub
		userRepository.updateUser(user);
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		userRepository.delete(id);
	}

}
