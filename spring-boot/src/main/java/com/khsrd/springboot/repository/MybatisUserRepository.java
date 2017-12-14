package com.khsrd.springboot.repository;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.khsrd.springboot.model.User;

@Repository
public interface MybatisUserRepository {

	@Select("select id, name, gender, image from tbuser")
	public List<User> getAllUser();

	@Select("select id, name, gender, image from tbuser where id=#{id}")
	public User getUserById(Integer id);

	@Insert("insert into tbuser(id, name, gender, image) values(#{id}, #{name}, #{gender}, #{image})")
	public boolean addUser(User user);

	@Delete("delete from tbuser where id=#{id}")
	public boolean delete(Integer id);

	@Update("update tbuser set name=#{name}, gender=#{gender}, image=#{image} where id=#{id}")
	public boolean updateUser(User user);
	
}
