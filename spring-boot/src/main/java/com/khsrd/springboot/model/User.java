package com.khsrd.springboot.model;

public class User {
	private String name;
	private int id;
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
