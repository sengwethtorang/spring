package com.khsrd.springboot.repository;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.khsrd.springboot.model.Role;
import com.khsrd.springboot.model.User;

@Repository
public interface MybatisUserRepository {

	@Select("select id, name, gender, image from tbuser order by id limit 5 offset (#{page}-1)*5")
	@Results({
		@Result(property ="id",column= "id"),
		@Result(property="name", column="name"),
		@Result(property="gender", column="gender"),
		@Result(property="image", column="image"),
		@Result(property="roles", column="id", many = @Many(select="findRoleById"))
	})
	public List<User> getAllUser(int page);
	
	@Select("select r.id, r.role from tbrole r inner join tbuser_role ur on r.id = ur.role_id where ur.user_id = #{id}")
	public List<Role> findRoleById(int id);
	
	@Select("select id, name, gender, image from tbuser where id=#{id}")
	@Results({
		@Result(property ="id",column= "id"),
		@Result(property="roles", column="id", many = @Many(select="findRoleById"))
	})
	public User getUserById(Integer id);

	@Insert("insert into tbuser(name, gender, image) values(#{name}, #{gender}, #{image})")
	@SelectKey(before = false, statement="SELECT LAST_INSERT_ID()",keyColumn="id",keyProperty="id", resultType = Integer.class)
	public boolean addUser(User user);

	@Delete("delete from tbuser where id=#{id}")
	public boolean delete(Integer id);

	@Update("update tbuser set name=#{name}, gender=#{gender}, image=#{image} where id=#{id}")
	public boolean updateUser(User user);
	@Select("select id, name, gender,password, image from tbuser where name=#{user}")
	@Results({
		@Result(property ="id",column= "id"),
		@Result(property="roles", column="id", many = @Many(select="findRoleById"))
	})
	public User getUserByUserName(String user);
	
}
