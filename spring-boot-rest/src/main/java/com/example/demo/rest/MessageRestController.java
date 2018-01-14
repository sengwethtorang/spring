package com.example.demo.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.DataResponse;
import com.example.demo.model.Message;
import com.example.demo.service.MessageService;

@RestController
public class MessageRestController {

	@Autowired
	MessageService messageService;

	@GetMapping(value = "/messages")
	public DataResponse getAllMessage() {
		DataResponse data = new DataResponse();
		try {
			data.setData(messageService.getAllMessage());
			data.setMessage("Get Success");
			data.setStatus(200);
		} catch (Exception e) {
			// TODO: handle exception
			data.setMessage("Get Fail");
			data.setStatus(404);
		}
		return data;
	}

	@GetMapping(value = "/messages/{id}")
	public Message getAllMessage(@PathVariable int id) {
		return messageService.getMessageById(id);
	}

	@PostMapping(value = "/messages")
	public DataResponse createMessage(@RequestBody Message message) {
		DataResponse data = new DataResponse();
		try {
			data.setData(messageService.createMessage(message));
			data.setMessage("Create Success");
			data.setStatus(200);
		}catch (Exception e) {
			// TODO: handle exception
			data.setMessage(e.getMessage());
			data.setStatus(303);
		}
		return data;
	}

	@DeleteMapping(value = "/messages/{id}")
	public boolean deleteMessage(@PathVariable int id) {
		return messageService.deleteMessage(id);
	}

	@PutMapping(value = "/messges")
	public boolean updateMesage(@RequestBody Message message) {
		return messageService.updateMessage(message);
	}
}
