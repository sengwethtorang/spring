package com.khsrd.springboot.repository;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.khsrd.springboot.model.Role;

public interface RolesRepository {
	
	
	@Select("select r.id, r.role from tbrole r order by id")
	public List<Role> getRoles();
	
	@Insert("insert into tbuser_role(user_id, role_id) values(#{user_id}, #{role_id})")
	public boolean saveUserRole(@Param("user_id") int user_id , @Param("role_id") int role_id);
	@Delete("delete from tbuser_role where user_id=#{id}")
	public boolean delete(Integer id);
	
}
