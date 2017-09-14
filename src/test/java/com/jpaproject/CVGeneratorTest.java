package com.jpaproject;

import static org.junit.Assert.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.junit.Test;

import de.codecentric.cvgenerator.CV;
import de.codecentric.cvgenerator.CVGenerator;
import de.codecentric.cvgenerator.Employee;

public class CVGeneratorTest {
	@Test
	public void testGenerator() throws IOException {
		CVGenerator generator = new CVGenerator();
		Employee employee = new Employee();
		employee.setFirstname("Alena");
		CV cv = generator.createCV(employee);
		//ByteArrayOutputStream out = new ByteArrayOutputStream();
		OutputStream out = new FileOutputStream("/home/alena/test.pdf");
		
		cv.render(out);
		
		//byte[] bytes = out.toByteArray();
		
		//assertTrue(bytes.length > 0);
	}
}