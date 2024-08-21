package com.example.restapi.controllers;

import com.example.restapi.entity.Employee;
import com.example.restapi.services.EmployeeService;

import java.util.List;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/emp")
public class EmployeeController {

	@Autowired
	EmployeeService empService;
	
	@GetMapping("/all")
	public String getAllEmployee() {
		JSONObject jsObj = new JSONObject(); 
		List<Employee> lsEmp = empService.getAllEmployee();
		jsObj.put("employee", lsEmp);
		jsObj.put("Result", "Success");
		return jsObj.toString();
	}
	
	@GetMapping("/byId")
	public String getEmployeebyId(@RequestParam(name="id") int emp_id) {
		return empService.getEmployeeById(emp_id);
	}
	
	@PostMapping("/create")
	public String CreateEmployee(@RequestBody Employee emp) {
		return empService.CreateEmployee(emp);
	}
	
	@PutMapping("/update")
	public String updateEmployee(@RequestParam(name="id") int emp_id , @RequestBody Employee emp) {
		return empService.updateEMployee(emp_id, emp);
	}
	
	@DeleteMapping("/delete")
	public String deleteEmployee(@RequestParam(name="id") int emp_id) {
		return empService.deleteEmployee(emp_id);
	}
}
