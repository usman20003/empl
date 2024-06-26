package com.example.emp.controller;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.emp.entity.Employee;
import com.example.emp.service.EmployeeService;

@Controller
@RequestMapping("/empcontroller")
public class Controllerclass {

	@Autowired
	EmployeeService employeeService;

	@GetMapping("/getemp")
	@ResponseBody
	Employee saveEmp(Employee employee) {
		Employee obj = new Employee();
		obj.setFullName("Munna");
		obj.setAge(21);
		obj.setEmail("usman.angadi786@gmail.com");
		obj.setId(220L);
		obj.setPhoneNumber("9999999");
		employeeService.getEmployeeEmailByEmpID(5L);
		return obj;

	}

	
	@PostMapping("/postemp")
	@ResponseBody
	List<Employee> saveEmpdata(Employee employee) {
		List<Employee> obj = new LinkedList();

		Employee obj1 = new Employee();
		obj1.setFullName("Munna");
		obj1.setAge(21);
		obj1.setEmail("sattarbaigh1@gmail.com");
		obj1.setId(220L);
		obj1.setPhoneNumber("9999999");

		Employee obj2 = new Employee();
		obj2.setFullName("Fareed");
		obj2.setAge(23);
		obj2.setEmail("developer.fareed@gmail.com");
		obj2.setId(2240L);
		obj2.setPhoneNumber("99999999");

		obj.add(obj1);
		obj.add(obj2);
		return obj;

	}

	@PostMapping("/postempdata")
	@ResponseBody
	List<Employee> saveEmpdata1(@RequestBody List<Employee> employee) {

		Employee obj2 = new Employee();
		obj2.setFullName("Fareed");
		obj2.setAge(23);
		obj2.setEmail("fareedmbbs@gmail.com");
		obj2.setId(2240L);
		obj2.setPhoneNumber("99999999");
		obj2.setSalary(45676);
		employee.add(obj2);

		/*
		 * List<Employee> filteredEmployees = employee.stream() .filter(emp ->
		 * emp.getFullName() .equalsIgnoreCase("fareed")) .collect(Collectors.toList());
		 */

		List<Employee> obj = new ArrayList<Employee>();
		obj.addAll(employee);
		for (Employee i : employee) {
			if (i.getSalary() > 10000) {
				obj.remove(i);
			}

		}

		return obj;

	}

}
