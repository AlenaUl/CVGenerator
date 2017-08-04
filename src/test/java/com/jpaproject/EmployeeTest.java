package com.jpaproject;

import static org.junit.Assert.*;

import org.junit.*;

public class EmployeeTest {
	
	@Test
	public final void testGetID() {
		Integer testValue = 123456;
		Project p = new Project();
		p.setPr_ID(testValue);
		
		Integer ID = p.getPr_ID();
		
		assertEquals(ID, testValue);
	}
	
	@Test(expected = RuntimeException.class)
	public final void testGetIDNullException() throws Exception {
		
		
		Employee emp = new Employee();
		emp.setID(0);
		
	}

}
