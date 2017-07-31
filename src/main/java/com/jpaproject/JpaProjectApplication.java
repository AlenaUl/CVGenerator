package com.jpaproject;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JpaProjectApplication implements CommandLineRunner {
	
	@Autowired
	EmployeeRepository employeeRepository;

	public static void main(String[] args) {
		SpringApplication.run(JpaProjectApplication.class, args);
	}

	@Override
	public void run(String... arg0) throws Exception {
	
		Employee[] employeeArray = {
				new Employee(3, "Alena", "Ulrich", "1991-01-19", "01726000000", "ulrichal20@gmail.com")
		};
		
		for (Employee employee : employeeArray){
			employeeRepository.save(employee);
		}
		
		List<Employee> listOfEmployee = employeeRepository.findAll();
		
		for (Employee employee : listOfEmployee) {
			System.out.println("Employee: " + employee.toString());
		}	
	}
}
