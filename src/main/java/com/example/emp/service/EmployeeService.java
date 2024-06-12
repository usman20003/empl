package com.example.emp.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
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
	@Autowired
    private JavaMailSender javaMailSender;

	public Employee saveEmp(Employee employee) {
		employeerepository.save(employee);
		return employee;

	}

	public Empdetails save(Empdetails empdetails) {
		emprepository.save(empdetails);
		return empdetails;

	}

	public Iterable<Empdetails> getempdata() {
		Iterable<Empdetails> all = emprepository.findAll();
		return all;

	}

	public String getEmployeeEmailByEmpID(Long empID) {
		Optional<Empdetails> empdetails = emprepository.findById(empID);
		String empMal = (empdetails != null) ? empdetails.get().getEmpMail() : null;
		return empMal;
	}
	
	public void sendEmailToEmployee(String email, String subject, String text) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(email);
        message.setSubject(subject);
        message.setText(text);
        javaMailSender.send(message);
    }

}
