package com.jpaproject;

import java.util.*;
import javax.persistence.*;

import org.apache.commons.lang.builder.ToStringBuilder;

@Entity
public class Employee {

	@Id
	private Integer emp_id;
	private String firstname;
	private String lastname;
	private String date_of_birth;
	private String phonenumber;
	private String email;
	
	private Set<Job> jobs = new HashSet<Job>();
	
	public Employee(){}
	
	public Employee(Integer emp_id, String firstname, String lastname, String date_of_birth, String phonenumber, String email){
		this.emp_id = emp_id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.date_of_birth = date_of_birth;
		this.phonenumber = phonenumber;
		this.email = email;
	}
	
	@Override
	public String toString(){
		return ToStringBuilder.reflectionToString(this);
	}
	
	public Integer getID() {
		return emp_id;
	}
	
	public void setID(Integer emp_id) {
		if(emp_id == 0) throw new RuntimeException();
		this.emp_id = emp_id;
	}
	
	public String getFirstname() {
		return firstname;
	}
	
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	
	public String getLastname() {
		return lastname;
	}
	
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	
	public String getDate_of_birth() {
		return date_of_birth;
	}
 
	public void setDate_of_birth(String date_of_birth) {
		this.date_of_birth = date_of_birth;
	}
	
	public String getPhonenumber() {
		return phonenumber;
	}
	
	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}

	@OneToMany(mappedBy = "employee", fetch = FetchType.LAZY)
	public Set<Job> getJobs() {
		return jobs;
	}

	public void add(Job jobs) {
		this.jobs.add(jobs);
	}
	
	public void remove(Job jobs) {
		this.jobs.remove(jobs);
	}
	
	/*public Project Search_Project(String customer){
		for(Project project : Projects){
            if (project.getCustomer() == customer)
                return project;
        }
        return null;
	}*/
}
