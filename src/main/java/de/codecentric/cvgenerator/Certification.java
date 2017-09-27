package de.codecentric.cvgenerator;

import java.util.*;
import javax.persistence.*;

import org.apache.commons.lang.builder.ToStringBuilder;

@Entity
public class Certification {
	@Id
	@GeneratedValue
	private Integer id;
	private String name;
	
	@OneToMany(mappedBy = "certification", fetch = FetchType.LAZY)
	private Set<EmployeeCertification> employeecertification = new HashSet<EmployeeCertification>();
	
	public Certification(){}
	
	public Certification(Integer id, String name){
		this.id = id;
		this.name = name;
	}
	
	@Override
	public String toString(){
		return ToStringBuilder.reflectionToString(this);
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public Set<EmployeeCertification> getEmployeeCertification() {
		return employeecertification;
	}

	public void add(EmployeeCertification employeecertification) {
		this.employeecertification.add(employeecertification);
	}
	
	public void remove(EmployeeCertification employeecertification) {
		this.employeecertification.remove(employeecertification);
	}
}


