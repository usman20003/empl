package com.example.emp.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.emp.entity.Empdetails;
import com.example.emp.entity.Employee;
import com.example.emp.repository.Employeerepository;
import com.example.emp.service.CSVService;
import com.example.emp.service.EmployeeService;

@RestController
@RequestMapping("/emp")
public class EmployeeController {
	@Autowired
	public EmployeeService employeeService;
	@Autowired
	public Employeerepository employeerepository;
	
	@Autowired
    private CSVService csvService;
	
	
	@GetMapping("/download/csv")
    public ResponseEntity<String> downloadCSV() {
        List<Empdetails> employees =employeerepository.findAll();
        String csvContent = csvService.convertToCSV(employees);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "attachment; filename=employees.csv");

        return ResponseEntity.ok()
                .headers(headers)
                .body(csvContent);
    }

	@PostMapping("/saveEmpData")
	Employee saveEmp(@RequestBody Employee employee) {
		employeeService.saveEmp(employee);
		return employee;

	}

	@GetMapping("/getempdata")
	public Iterable<Empdetails> getempdata() {
		Iterable<Empdetails> all = employeeService.getempdata();
		return all;

	}

	@DeleteMapping("/delEmpData/{employeeId}")
	void delEmp(@PathVariable Long employeeId) {
		employeerepository.deleteById(employeeId);

	}

}
