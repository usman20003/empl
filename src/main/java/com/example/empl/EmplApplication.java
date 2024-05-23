package com.example.empl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EmplApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmplApplication.class, args);
		
		System.out.println("EmplApplication.main()");
	}

}
