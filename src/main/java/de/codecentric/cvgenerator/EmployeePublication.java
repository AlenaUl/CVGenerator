package de.codecentric.cvgenerator;

import javax.persistence.*;

import org.apache.commons.lang.builder.ToStringBuilder;

@Entity
public class EmployeePublication {

	@Id
	@GeneratedValue
	private Integer id;

	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "employee_id")
	private Employee employee;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "publication_id")
	private Publication publication;

	public EmployeePublication(){}
	
	
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
	
	public Publication getPublication() {
		return publication;
	}

	public void setPublication(Publication publication) {
		this.publication = publication;
	}

}



