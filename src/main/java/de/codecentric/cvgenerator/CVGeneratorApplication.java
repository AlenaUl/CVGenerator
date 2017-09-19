package de.codecentric.cvgenerator;

import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

@SpringBootApplication
public class CVGeneratorApplication implements CommandLineRunner {
	
	@Autowired
	EmployeeRepository employeeRepository;
	ProjectRepository projectRepository;
	TechnologyRepository technologyRepository;
	JobRepository jobRepository;
	PartRepository partRepository;

	public static void main(String[] args) {
		SpringApplication.run(CVGeneratorApplication.class, args);
		
	}

	@Override
	@Transactional
	public void run(String... arg0) throws Exception {
	
/*	Employee[] employeeArray = {
				new Employee(2, "Alena", "Ulrich", "1991-01-19", "01726000000", "ulrichal20@gmail.com")
		};
		
		for (Employee employee : employeeArray){
			employeeRepository.save(employee);
		}
*/
		
		//List<Employee> listOfEmployee = employeeRepository.findAll();
		Employee emp = employeeRepository.getOne(1);
		CVGenerator generator = new CVGenerator();
		//for (Employee emp : listOfEmployee) {
			CV cv = generator.createCV(emp);
			OutputStream out = new FileOutputStream("/home/alena/test.tex");		
			cv.render(out);
			//System.out.println("Employee: " + emp.toString());
		//}	
		
		
	}
}
