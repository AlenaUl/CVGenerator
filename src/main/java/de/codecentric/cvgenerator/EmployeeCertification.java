package de.codecentric.cvgenerator;

import javax.persistence.*;

import org.apache.commons.lang.builder.ToStringBuilder;

@Entity
public class EmployeeCertification {

	@Id
	@GeneratedValue
	private Integer id;

	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "employee_id")
	private Employee employee;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "certification_id")
	private Certification certification;

	public EmployeeCertification(){}
	
	
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
	
	public Certification getCertification() {
		return certification;
	}

	public void setSkills(Certification certification) {
		this.certification = certification;
	}

}


