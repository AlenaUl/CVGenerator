package de.codecentric.cvgenerator;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@RunWith(SpringRunner.class)
public class EmployeeRepositoryTest {
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	@Test
	@Transactional
	public void test() {
		assertNotNull(employeeRepository);
		Employee employee = employeeRepository.findOne(1);
		assertNotNull(employee);
		assertFalse(employee.getEmployeeQualification().isEmpty());
		assertEquals(10, employee.getSkillCategories().size());
	}

}
