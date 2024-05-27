package com.example.emp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.emp.entity.Empdetails;
import com.example.emp.service.EmployeeService;

@RestController
@RequestMapping("/mailcontroller")
public class Mailcontroller {
	
	@Autowired
	public EmployeeService employeeService;
		
	@PostMapping("/addempdata")
	 public Empdetails saveEmpdetails(@RequestBody Empdetails empdetails) {
		 employeeService.save(empdetails);
			return empdetails;
			
		}

}
