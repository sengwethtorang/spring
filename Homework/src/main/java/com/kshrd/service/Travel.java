package com.kshrd.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.kshrd.model.Transport;

@Component
public class Travel {
	private Transport transport;
	
	@Autowired
	@Qualifier(value="bycircle")
	public void setTransport(Transport transport) {
		this.transport = transport;
	}
	
	public void travelling() {
		System.out.println("Go to KPS by :"+transport.getTransport());
	}
}
