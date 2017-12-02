package com.khsrd.springboot.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

public class User {
	@NotNull
	@NotEmpty

	private String name;
	private int id;
	@Size(min=1,max=1)
	private String gender;
	private String image;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	
//	@Override
//	public String toString() {
//		// TODO Auto-generated method stub
//		return super.toString();
//	}
	
	public User() {
		// TODO Auto-generated constructor stub
	}
	public User( int id,String name, String gender, String image) {
		super();
		this.name = name;
		this.id = id;
		this.gender = gender;
		this.image = image;
	}
	
	
}
