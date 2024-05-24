package com.example.emp.controller;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.emp.entity.Employee;

@Controller
@RequestMapping("/empcontroller")
public class Controllerclass {

	@GetMapping("/getemp")
	@ResponseBody
	Employee saveEmp(Employee employee) {
		Employee obj = new Employee();
		obj.setFullName("Munna");
		obj.setAge(21);
		obj.setEmail("munnabhaimbbs@gmail.com");
		obj.setId(220L);
		obj.setPhoneNumber("9999999");
		return obj;

	}

	@PostMapping("/postemp")
	@ResponseBody
	List<Employee> saveEmpdata(Employee employee) {
		List<Employee> obj = new LinkedList();

		Employee obj1 = new Employee();
		obj1.setFullName("Munna");
		obj1.setAge(21);
		obj1.setEmail("munnabhaimbbs@gmail.com");
		obj1.setId(220L);
		obj1.setPhoneNumber("9999999");

		Employee obj2 = new Employee();
		obj2.setFullName("Fareed");
		obj2.setAge(23);
		obj2.setEmail("fareedmbbs@gmail.com");
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
		employee.add(obj2);

		List<Employee> filteredEmployees = employee.stream()
				.filter(emp -> emp.getFullName()
				.equalsIgnoreCase("fareed"))
				.collect(Collectors.toList());

		return filteredEmployees;

	}

}
