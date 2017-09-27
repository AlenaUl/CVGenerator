package de.codecentric.cvgenerator;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.junit.Test;

import de.codecentric.cvgenerator.CV;
import de.codecentric.cvgenerator.CVGenerator;
import de.codecentric.cvgenerator.Employee;
import de.codecentric.cvgenerator.Job;
import de.codecentric.cvgenerator.Project;

public class CVGeneratorTest {
	@Test
	public void testGenerator() throws IOException {
		CVGenerator generator = new CVGenerator();
		Employee employee = new Employee();
		employee.setFirstname("Alena");
		Project project = new Project();
		project.setCustomer("Lavego AG");
		Job job = new Job();
		job.setProject(project);
		employee.add(job);
		
		Project second = new Project();
		second.setCustomer("Test");
		
		Job sjob = new Job();
		sjob.setProject(second);
		
		employee.add(sjob);
		
		CV cv = generator.createCV(employee);
		OutputStream out = new FileOutputStream("/home/alena/test.tex");		
		cv.render(out);
	}
}