package de.codecentric.cvgenerator;

import javax.persistence.*;

import org.apache.commons.lang.builder.ToStringBuilder;

@Entity
public class EmployeeCommunity {

	@Id
	@GeneratedValue
	private Integer id;

	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "employee_id")
	private Employee employee;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "community_id")
	private Community community;

	public EmployeeCommunity(){}
	
	
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
	
	public Community getCommunity() {
		return community;
	}

	public void setCommunity(Community community) {
		this.community = community;
	}

}



