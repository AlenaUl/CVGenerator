package com.jpaproject;

import static org.junit.Assert.*;

import org.junit.*;

public class EmployeeTest {
	
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
