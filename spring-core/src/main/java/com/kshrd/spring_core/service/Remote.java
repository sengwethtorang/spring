package com.kshrd.spring_core.service;

import com.kshrd.spring_core_model.TV;

public class Remote {
	private TV tv;

//	public TV getTv() {
//		return tv;
//	}
//
//	public void setTv(TV tv) {
//		this.tv = tv;
//	}
	public Remote(TV tv) {
		super();
		this.tv = tv;
	}
	public void remoter () {
		System.out.println("Remote "+tv.getName());
	}

	
	
	
}
