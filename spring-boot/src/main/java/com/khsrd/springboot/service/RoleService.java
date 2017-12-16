package com.khsrd.springboot.service;

import java.util.List;

import com.khsrd.springboot.model.Role;

public interface RoleService {

	public List<Role> getRoles();
	public void saveRole(int user_id, int role_id);
}
