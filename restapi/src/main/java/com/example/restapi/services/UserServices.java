package com.example.restapi.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import com.example.restapi.entity.User;
//import com.example.restapi.repositories.UserRepository;

@Service
public class UserServices {
/*
	@Autowired
	UserRepository userRepo;
	
	public List<User> getAllUserDetails() {
		return userRepo.findAll();
	}
	
	public User getUserById(int id) {
		return userRepo.findById(id).orElse(null);
	}
	
	public User CreateUser(User user) {
		return userRepo.save(user);
	}
	
	public User updateUser(int id,User user) {
		User tempUser = userRepo.findById(id).orElse(null);
		if(tempUser != null) {
			tempUser.setPassword(user.getPassword());
			tempUser.setStudent(user.getStudent());
			return userRepo.save(tempUser);
		}else {
			return null;
		}
	}
	
	public void deleteUser(int id) {
		userRepo.deleteById(id);
	} */
	
	private int uerId;
	private String userName;
}
