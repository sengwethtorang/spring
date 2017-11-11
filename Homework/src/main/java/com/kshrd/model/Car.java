package com.kshrd.model;

import org.springframework.stereotype.Component;

@Component
public class Car implements Transport {

	public String getTransport() {
		// TODO Auto-generated method stub
		return "car";
	}

}
