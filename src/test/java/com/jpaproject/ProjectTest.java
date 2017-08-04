package com.jpaproject;

import static org.junit.Assert.*;

import org.junit.Test;

public class ProjectTest {

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
		
		
		Project p = new Project();
		p.setPr_ID(0);
		
	}



}
