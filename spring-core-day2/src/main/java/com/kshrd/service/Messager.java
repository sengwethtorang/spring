package com.kshrd.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.kshrd.model.Message;

@Component
public class Messager {
	private Message message;
	
	@Autowired
	@Qualifier(value="message")
	public void setMessage(Message message) {
		this.message = message;
	}
	public Messager(Message message) {
		this.message = message;
	}
	
	public void send() {
		System.out.println("Sending : "+ message.getMessage());
	}
}
