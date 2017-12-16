package com.khsrd.springboot.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.khsrd.springboot.model.Role;
import com.khsrd.springboot.repository.RolesRepository;
import com.khsrd.springboot.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService{

	@Autowired
	private RolesRepository rolesRepository;
	
	@Override
	public List<Role> getRoles() {
		// TODO Auto-generated method stub
		return rolesRepository.getRoles();
	}

	@Override
	public void saveRole(int user_id, int role_id) {
		// TODO Auto-generated method stub
		rolesRepository.saveUserRole(user_id, role_id);
		
	}

}
