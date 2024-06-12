package com.example.emp.controller;

import java.net.http.HttpHeaders;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.emp.entity.Empdetails;
import com.example.emp.entity.Employee;
import com.example.emp.repository.Emprepository;
import com.example.emp.service.CSVService;
import com.example.emp.service.EmployeeService;


@RestController
@RequestMapping("/mailcontroller")
public class Mailcontroller {
	
	@Autowired
	public EmployeeService employeeService;
	
	@Autowired
	public Emprepository emprepository;
	
	@Autowired
    private CSVService csvService;
	
	

	
	@PostMapping("/addempdata")
	 public Empdetails saveEmpdetails(@RequestBody Empdetails empdetails) {
		 employeeService.save(empdetails);
		employeeService.getEmployeeEmailByEmpID(6L);	
		 return empdetails;			
		}
	
	@GetMapping("getempdata")
	 public Iterable<Empdetails> getempdata() {
		 Iterable<Empdetails> all= employeeService.getempdata();
			return all;
			
		}
	
	@GetMapping("/getempdata/{employeeId}")
	Empdetails findbyid(@PathVariable Long employeeId) {
		Optional<Empdetails> filtereddata= emprepository.findById(employeeId);
		return filtereddata.get();
		
	}
	

}
