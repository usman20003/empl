package com.example.emp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.emp.entity.Employee;
import com.example.emp.repository.Employeerepository;

@Service
public class EmployeeService {
@Autowired
Employeerepository employeerepository;
	
 public Employee saveEmp(Employee employee) {
	 employeerepository.save(employee);
		return employee;
		
	}

}
