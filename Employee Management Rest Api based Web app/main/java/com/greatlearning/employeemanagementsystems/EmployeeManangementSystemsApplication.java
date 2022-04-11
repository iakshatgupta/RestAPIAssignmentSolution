package com.greatlearning.employeemanagementsystems;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EmployeeManangementSystemsApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeManangementSystemsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Initialising Employee Management System Rest API..");

	}

}
