package com.example.empl.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/empController")
public class EmployeeCOntroler {

	@GetMapping("/get")
	public String saveEmp() {
		return "cool ";

	}
	@GetMapping("/del")
	public String delEmp() {
		return "cool ";

	}
}
