package com.example.emp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.emp.entity.Empdetails;
import com.example.emp.entity.Employee;
import com.example.emp.repository.Employeerepository;
import com.example.emp.repository.Emprepository;

@Service
public class EmployeeService {
@Autowired
Employeerepository employeerepository;
@Autowired
Emprepository emprepository;
	
 public Employee saveEmp(Employee employee) {
	 employeerepository.save(employee);
		return employee;
		
	}
 
 public Empdetails save(Empdetails empdetails) {
	 emprepository.save(empdetails);
		return empdetails;
		
	}
}
