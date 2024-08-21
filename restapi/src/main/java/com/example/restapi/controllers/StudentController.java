package com.example.restapi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.restapi.entity.Student;
import com.example.restapi.repositories.StudentRepository;

@Controller
@RequestMapping(path = "/student")
public class StudentController {

	@Autowired
	private StudentRepository studentRepo;
	
	@GetMapping("/all")
	public @ResponseBody Iterable<Student> getAllUser(){
		return studentRepo.findAll();
	}
	
	@PostMapping("/add")
	public @ResponseBody String addStudent(@RequestParam String name) {
		Student st = new Student();
		st.setName(name);
		studentRepo.save(st);
		return "saved";
	}
	
	@DeleteMapping("/delete/{id}")
	public @ResponseBody String deleteStudentRecord(@PathVariable int id) {
		studentRepo.deleteById(id);
		return "deleted";
	}
}
