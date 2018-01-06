package com.khsrd.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.khsrd.springboot.model.CustomUserDetail;
import com.khsrd.springboot.model.User;
import com.khsrd.springboot.repository.MybatisUserRepository;


@Service
public class CustomUserDetailService implements UserDetailsService{

	@Autowired
	private MybatisUserRepository userRepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		User user = userRepo.getUserByUserName(username);
		if(user== null) {
			throw new UsernameNotFoundException("User name not found");
		}
		return new CustomUserDetail(user);
	}

}
