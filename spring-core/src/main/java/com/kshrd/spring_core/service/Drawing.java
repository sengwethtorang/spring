package com.kshrd.spring_core.service;

import com.kshrd.spring_core_model.Traingle;

public class Drawing {

	private Traingle traingle;
	
	public Drawing(Traingle traingle) {
		super();
		this.traingle = traingle;
	}


	public Drawing() {
		super();
	}


	public void draw() {
		System.out.println("Drawing "+traingle.getType());
	}
}
