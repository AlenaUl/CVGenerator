package de.codecentric.cvgenerator;

import javax.persistence.*;

import org.apache.commons.lang.builder.ToStringBuilder;

@Entity
public class EmployeeSkills {

	@Id
	@GeneratedValue
	private Integer id;

	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "employee_id")
	private Employee employee;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "skills_id")
	private Skills skills;

	public EmployeeSkills(){}
	
	
	@Override
	public String toString(){
		return ToStringBuilder.reflectionToString(this);
	}
	
	
	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	
	public Skills getSkills() {
		return skills;
	}

	public void setSkills(Skills skills) {
		this.skills = skills;
	}

}

