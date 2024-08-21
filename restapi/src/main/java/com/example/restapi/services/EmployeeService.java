package com.example.restapi.services;

import java.util.List;
import java.util.Optional;

import com.example.restapi.entity.Employee;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.restapi.repositories.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepo;


	public List<Employee> getAllEmployee() {
		return employeeRepo.findAll();
	}

	public String getEmployeeById(int id) {
		JSONObject resJson = new JSONObject();
		Employee employee = employeeRepo.findById(id).orElse(null);
		resJson.put("result", "success");
		if(employee != null) {
			resJson.put("employee", new JSONObject(employee));
		}else {
			resJson.put("message", "Employee doesn't exists.");
		}
		return resJson.toString();
	}

	public String CreateEmployee(Employee emp) {
		JSONObject resJSon = new JSONObject();
		resJSon.put("result", "Fail");
		int id = emp.getEmp_id();
		if(id <= 0) {
			resJSon.put("message", "Enter Valid Employee Id.");
		}
		else if (emp.getFirst_name() == null || emp.getFirst_name().equals("")) {
			resJSon.put("message", "First Name Can't be empty.");
		} 
		else if (emp.getLast_name() == null || emp.getLast_name().equals("")) {
			resJSon.put("message", "Last Name Can't be empty.");
		} 
		else if (emp.getEmail() == null || emp.getEmail().equals("")) {
			resJSon.put("message", "Email Can't be empty.");
		} 
		else if (emp.getPassword() == null || emp.getPassword().equals("")) {
			resJSon.put("message", "Password Can't be empty.");
		}
		else if(employeeRepo.existsByEmail(emp.getEmail())) {
			resJSon.put("message", "Email already exists.");
		}
		else if(emp.getPassword().length() > 10) {
			resJSon.put("message", "Maximum length of Password is 10");
		}
		else {
			Employee employee = employeeRepo.findById(id).orElse(null);
			if(employee == null) {				
				employeeRepo.save(emp);
				resJSon.put("result", "success");
				resJSon.put("message", "Employee Saved Successfully.");
			}else {
				resJSon.put("message", "Employee Exists with same employee id.");
			}
		}
		return resJSon.toString();
	}

	public String updateEMployee(int id, Employee emp) {
		JSONObject resJson = new JSONObject();
		Employee employee = employeeRepo.findById(id).orElse(null);
		if(employee != null) {
			if (emp.getFirst_name() == null || emp.getFirst_name().equals("")) {
				resJson.put("message", "First Name Can't be empty.");
			} 
			else if (emp.getLast_name() == null || emp.getLast_name().equals("")) {
				resJson.put("message", "Last Name Can't be empty.");
			} 
			else if (emp.getEmail() == null || emp.getEmail().equals("")) {
				resJson.put("message", "Email Can't be empty.");
			} 
			else if (emp.getPassword() == null || emp.getPassword().equals("")) {
				resJson.put("message", "Password Can't be empty.");
			}
			else if(employeeRepo.existsByEmail(emp.getEmail())) {
				resJson.put("message", "Email already exists.");
			}
			else if(emp.getPassword().length() > 10) {
				resJson.put("message", "Maximum length of Password is 10");
			}
			else {
				employee.setFirst_name(emp.getFirst_name());
				employee.setLast_name(emp.getLast_name());
				employee.setEmail(emp.getEmail());
				employee.setPassword(emp.getPassword());
				employeeRepo.save(employee);
				resJson.put("result", "success");
				resJson.put("message", "Employee Updated Successfully.");
			}
		}else {
			resJson.put("result", "Fail");
			resJson.put("message", "Employee Doesn't exists.");
		}
		return resJson.toString();
		/*Employee employee = employeeRepo.findById(id).orElse(null);
		if (employee != null) {
			employee.setFirst_name(emp.getFirst_name());
			employee.setLast_name(emp.getLast_name());
			employee.setEmail(emp.getEmail());
			employee.setPassword(emp.getPassword());
			return employeeRepo.save(employee);
		} else {
			return null;
		}*/
	}

	public String deleteEmployee(int id) {
		JSONObject resJson = new JSONObject();
		Employee employee = employeeRepo.findById(id).orElse(null);
		if(employee == null) {
			resJson.put("result", "Fail");
			resJson.put("message", "Employee Doesn't exists.");
		}else {
			employeeRepo.deleteById(id);
			resJson.put("result", "Success");
			resJson.put("message", "Employee deleted successfully.");
		}
		return resJson.toString();
	}
}
