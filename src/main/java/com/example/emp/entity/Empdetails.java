package com.example.emp.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="employees_details")
public class Empdetails {
	 @Id
	 @GeneratedValue(generator = "increment")
	private Long empID;
	private String empName;
	private String empMail;
	public Long getEmpID() {
		return empID;
	}
	public void setEmpID(Long empID) {
		this.empID = empID;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getEmpMail() {
		return empMail;
	}
	public void setEmpMail(String empMail) {
		this.empMail = empMail;
	}

	}
	
	
	


