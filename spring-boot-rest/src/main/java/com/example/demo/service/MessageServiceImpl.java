package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Message;
import com.example.demo.repository.MessageRepository;

@Service
public class MessageServiceImpl implements MessageService{

	@Autowired
	private MessageRepository messageServiceImpl;
	
	@Override
	public List<Message> getAllMessage() {
		// TODO Auto-generated method stub
		return messageServiceImpl.getMessages();
	}

	@Override
	public Message getMessageById(int id) {
		// TODO Auto-generated method stub
		return messageServiceImpl.getMessage(id);
	}

	@Override
	public boolean createMessage(Message message) {
		// TODO Auto-generated method stub
		return messageServiceImpl.saveMessage(message);
	}

	@Override
	public boolean updateMessage(Message message) {
		// TODO Auto-generated method stub
		return messageServiceImpl.updateUser(message);
	}

	@Override
	public boolean deleteMessage(int id) {
		// TODO Auto-generated method stub
		return messageServiceImpl.delete(id);
	}

}
