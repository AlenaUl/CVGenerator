package de.codecentric.cvgenerator;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {

	@Autowired
	EmployeeRepository employeeRepository;
	
	@RequestMapping(value="/employees", method=RequestMethod.GET)
	public List<Employee> getAll() {
		return employeeRepository.findAll();
	}
	
//	@RequestMapping(value="/employees/{id}", method=RequestMethod.GET)
//	public List<Employee> getOne(@PathVariable Integer id) {
//		return employeeRepository.getOne(id);
//		
//	}
	
}
