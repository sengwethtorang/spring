package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Message;

public interface MessageService {
	public List<Message> getAllMessage();
	public Message getMessageById(int id);
	public boolean createMessage(Message message);
	public boolean updateMessage(Message message);
	public boolean deleteMessage(int id);
}
