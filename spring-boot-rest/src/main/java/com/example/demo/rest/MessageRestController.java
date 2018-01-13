package com.example.demo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Message;
import com.example.demo.service.MessageService;

@RestController
public class MessageRestController {

	
	@Autowired
	MessageService messageService;
	
	@GetMapping(value="/messages")
	public List<Message> getAllMessage(){
		return messageService.getAllMessage();
	}
	
	@GetMapping(value="/messages/{id}")
	public Message getAllMessage(@PathVariable int id){
		return messageService.getMessageById(id);
	}
	
	@PostMapping(value="/messages")
	public boolean createMessage(@RequestBody Message message) {
		return messageService.createMessage(message);
	}
	
	@DeleteMapping(value="/messages/{id}")
	public boolean deleteMessage(@PathVariable int id) {
		return messageService.deleteMessage(id);
	}
	
	@PutMapping(value="/messges")
	public boolean updateMesage(@RequestBody Message message)
	{
		return messageService.updateMessage(message);
	}
}
