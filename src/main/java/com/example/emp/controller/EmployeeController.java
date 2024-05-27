package com.example.emp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.emp.entity.Employee;
import com.example.emp.repository.Employeerepository;
import com.example.emp.service.EmployeeService;

@RestController
@RequestMapping("/emp")
public class EmployeeController {
@Autowired
public EmployeeService employeeService;
@Autowired
public Employeerepository employeerepository;

	@PostMapping("/saveEmpData")
	Employee saveEmp(@RequestBody Employee employee) {
		employeeService.saveEmp(employee);
		return employee;
		
	}
	
	@GetMapping("/getempdata")
	public Iterable<Employee> getEmp(){
		
		Iterable<Employee> all = employeerepository.findAll();
		return all;
		
		
	}
	
	@DeleteMapping("/delEmpData/{employeeId}")
	void delEmp(@PathVariable Long employeeId) {
		employeerepository.deleteById(employeeId);
		
	}

}
