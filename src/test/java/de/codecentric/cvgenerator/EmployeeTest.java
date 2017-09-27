package de.codecentric.cvgenerator;

import static org.junit.Assert.*;

import java.util.Collection;

import org.junit.Test;

import de.codecentric.cvgenerator.Employee;
import de.codecentric.cvgenerator.Job;
import de.codecentric.cvgenerator.Part;
import de.codecentric.cvgenerator.Project;

public class EmployeeTest {
	
	@Test
	public void testProjectsWithPart() {
		Employee employee = new Employee();
		Part part = new Part();
		Project project = new Project();
		Job job = new Job();
		job.setEmployee(employee);
		job.setPart(part);
		job.setProject(project);
		employee.add(job);
		
		Collection<Project> projects = employee.getProjectsWithPart(part);
		
		assertTrue(projects.contains(project));
		
	}
	
	@Test
	public final void testGetID() {
		Integer testValue = 123456;
		Employee emp = new Employee();
		emp.setID(testValue);
		
		Integer emp_id = emp.getID();
		
		assertEquals(emp_id, testValue);
	}
	
	@Test(expected = RuntimeException.class)
	public final void testGetIDNullException() throws Exception {
		
		
		Employee emp = new Employee();
		emp.setID(0);
		
	}

}
