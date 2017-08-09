package com.jpaproject;

import java.util.List;

import javax.persistence.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JpaProjectApplication implements CommandLineRunner {
	
	@Autowired
	EmployeeRepository employeeRepository;
	ProjectRepository projectRepository;
	TechnologyRepository technologyRepository;
	JobRepository jobRepository;
	PartRepository partRepository;

	public static void main(String[] args) {
		SpringApplication.run(JpaProjectApplication.class, args);
		
	}

	@Override
	public void run(String... arg0) throws Exception {
	
/*		Employee[] employeeArray = {
				new Employee(4, "Alena", "Ulrich", "1991-01-19", "01726000000", "ulrichal20@gmail.com")
		};
		
		for (Employee employee : employeeArray){
			employeeRepository.save(employee);
		}*/
		
		List<Employee> listOfEmployee = employeeRepository.findAll();
		
		for (Employee emp : listOfEmployee) {
			System.out.println("Employee: " + emp.toString());
		}	
	}
}
