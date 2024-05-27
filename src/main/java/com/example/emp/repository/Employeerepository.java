package com.example.emp.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.emp.entity.Employee;

@Repository
public interface Employeerepository extends CrudRepository<Employee, Long>{
	
	

	
}
