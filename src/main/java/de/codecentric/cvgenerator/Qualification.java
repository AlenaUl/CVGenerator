package de.codecentric.cvgenerator;

import java.util.*;
import javax.persistence.*;

import org.apache.commons.lang.builder.ToStringBuilder;

@Entity
public class Qualification {
	@Id
	@GeneratedValue
	private Integer id;
	private String place;
	private String profil;
	private String start_date;
	private String end_date;

	@OneToMany(mappedBy = "skills", fetch = FetchType.LAZY)
	private Set<EmployeeQualification> employeequalification = new HashSet<EmployeeQualification>();
	
	public Qualification(){}
	
	public Qualification(Integer id, String place, String profil, String start_date, String end_date){
		this.id = id;
		this.place = place;
		this.profil = profil;
		this.start_date = start_date;
		this.end_date = end_date;
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
	
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}

	public String getProfil() {
		return profil;
	}
	public void setProfil(String profil) {
		this.profil = profil;
	}

	public String getStart_date() {
		return start_date;
	}
	public void setStart_date(String start_date) {
		this.start_date = start_date;
	}

	public String getEnd_date() {
		return end_date;
	}
	public void setEnd_date(String end_date) {
		this.end_date = end_date;
	}
	
	public Set<EmployeeQualification> getEmployeeQualification() {
		return employeequalification;
	}

	public void add(EmployeeQualification employeequalification) {
		this.employeequalification.add(employeequalification);
	}
	
	public void remove(EmployeeQualification employeequalification) {
		this.employeequalification.remove(employeequalification);
	}
}


