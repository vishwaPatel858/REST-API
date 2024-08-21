package com.example.restapi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
//import com.example.restapi.entity.User;
import com.example.restapi.services.UserServices;

@RestController
@RequestMapping("/user")
public class UserControllers {
/*
	@Autowired
	UserServices userServices;
	
	@GetMapping("/all")
	public List<User> getAllUsers(){
		return userServices.getAllUserDetails();
	}
	
	@GetMapping("/id/{id}")
	public User getUserByIId(@PathVariable int id) {
		return userServices.getUserById(id);
	}
	
	@PostMapping("/create")
	public User createUser(@RequestBody User user) {
		return userServices.CreateUser(user);
	}
	
	@PutMapping("/update")
	public User updateUser(@RequestParam(name="id") int id , @RequestBody User user) {
		return userServices.updateUser(id, user);
	}
	
	@DeleteMapping("/delete/{id}")
	public void deleteUser(@PathVariable int id) {
		userServices.deleteUser(id);
	} */
}
