package com.khsrd.springboot.repository.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.github.javafaker.Faker;
import com.khsrd.springboot.model.User;
import com.khsrd.springboot.repository.UserRepository;

@Repository
public class UserRepositoryImpl implements UserRepository{
	private List<User> users= new ArrayList<>();
	public UserRepositoryImpl() {
		Faker faker = new Faker();
		for(int i=1; i<10; i++){

			String name = faker.name().fullName();
			String image = faker.internet().image(100, 100, false, null);
			
			User user = new User(i, name, (i%2==0)?"M":"F", image);
			users.add(user);
		}
	}

	@Override
	public List<User> getAllUser() {
		// TODO Auto-generated method stub
		return users;
	}

	@Override
	public User getUserById(int id) {
		// TODO Auto-generated method stub
		for (int i=0;i<users.size();i++) {
			System.out.println("ID :"+ users.get(i).getId());
			if(users.get(i).getId()== id) {
				return users.get(i);
			}
			
		}
		return null;
	}

	@Override
	public void addUser(User user) {
		// TODO Auto-generated method stub
		users.add(user);
	}

	@Override
	public void updateUser(User user_) {
		for (int i=1;i<users.size();i++) {
			if(users.get(i).getId()== user_.getId()) {
				users.set(i, user_);
				break;
			}
			
		}
		
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		for (int i=1;i<users.size();i++) {
			if(users.get(i).getId()== id) {
				users.remove(i);
				break;
			}
			
		}
	}

}
