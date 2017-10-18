package de.codecentric.cvgenerator;

import java.util.*;
import javax.persistence.*;

import org.apache.commons.lang.builder.ToStringBuilder;

@Entity
public class Community {
	@Id
	@GeneratedValue
	private Integer id;
	private String theme;
	private String conference;
	private String place;
	private int year;
	
	@OneToMany(mappedBy = "community", fetch = FetchType.LAZY)
	private Set<EmployeeCommunity> employeecommunity = new HashSet<EmployeeCommunity>();
	
	public Community(){}
	
	public Community(Integer id, String theme, String conference, String place, int year){
		this.id = id;
		this.theme = theme;
		this.conference = conference;
		this.place = place;
		this.year = year;
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
	
	public String getTheme() {
		return theme;
	}

	public void setTheme(String theme) {
		this.theme = theme;
	}

	public String getConference() {
		return conference;
	}

	public void setConference(String conference) {
		this.conference = conference;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}
	
	public Set<EmployeeCommunity> getEmployeeCommunity() {
		return employeecommunity;
	}

	public void add(EmployeeCommunity employeecommunity) {
		this.employeecommunity.add(employeecommunity);
	}
	
	public void remove(EmployeeCommunity employeecommunity) {
		this.employeecommunity.remove(employeecommunity);
	}
}



