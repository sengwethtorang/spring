package com.kshrd.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.kshrd.model.Message;


@Configuration
public class BeanConfiguration {
	@Bean
	public Message message1() {
		Message message= new Message();
		System.out.println("AAAAAAAAAAA");
		message.setMessage("Hello");
		return message;
	}
	@Bean
	public Message message2() {
		Message message= new Message();
		System.out.println("111");
		message.setMessage("Hell999999999999999o");
		return message;
	}
	
//	@Bean
//	public Messager messager() {
//		return new Messager(message());
//	}
}
