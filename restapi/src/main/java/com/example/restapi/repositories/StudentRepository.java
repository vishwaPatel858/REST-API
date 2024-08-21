package com.example.restapi.repositories;

import org.springframework.data.repository.CrudRepository;

import com.example.restapi.entity.Student;

public interface StudentRepository extends CrudRepository<Student, Integer>{

}
