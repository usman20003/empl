package com.example.emp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.emp.entity.Empdetails;

@Repository
public interface Employeerepository extends JpaRepository<Empdetails, Long>{
	
	

	
}
