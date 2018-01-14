package com.example.demo.repository;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Message;

@Repository
public interface MessageRepository {

	@Select("select r.id, r.message from message r order by id")
	public List<Message> getMessages();

	@Select("select id, message from message where id=#{id}")
	public Message getMessage(int id);
	
	@Insert("insert into  message(id,message) values(#{id},#{message})")
	public boolean saveMessage(Message messa);

	@Delete("delete from message where id=#{id}")
	public boolean delete(Integer id);

	@Update("update message set message=#{message} where id=#{id}")
	public boolean updateUser(Message messa);
}
