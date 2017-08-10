package com.jpaproject;

import static org.junit.Assert.*;

import org.junit.Test;

import de.codecentric.cvgenerator.Project;

public class ProjectTest {

	@Test
	public final void testGetID() {
		Integer testValue = 123456;
		Project p = new Project();
		p.setPrID(testValue);
		
		Integer pr_id = p.getPrID();
		
		assertEquals(pr_id, testValue);
	}
	
	@Test(expected = RuntimeException.class)
	public final void testGetIDNullException() throws Exception {
		
		
		Project p = new Project();
		p.setPrID(0);
		
	}



}
