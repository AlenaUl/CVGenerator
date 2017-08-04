package com.jpaproject;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import org.apache.commons.lang.builder.ToStringBuilder;

@Entity
public class Employee {

	@Id
	private Integer ID;
	private String Firstname;
	private String Lastname;
	private String Date_Of_Birth;
	private String phonenumber;
	private String Email;
	private List<Project> Projects = new ArrayList<Project>();
	
	public Employee(){}
	
	public Employee(Integer ID, String Firstname, String Lastname, String Date_Of_Birth, String PhoneNumber, String Email){
		this.ID = ID;
		this.Firstname = Firstname;
		this.Lastname = Lastname;
		this.Date_Of_Birth = Date_Of_Birth;
		this.phonenumber = PhoneNumber;
		this.Email = Email;
	}
	
	@Override
	public String toString(){
		return ToStringBuilder.reflectionToString(this);
	}
	
	public Integer getID() {
		return ID;
	}
	
	public void setID(Integer ID) {
		if(ID == 0) throw new RuntimeException();
		this.ID = ID;
	}
	
	public String getFirstname() {
		return Firstname;
	}
	
	public void setFirstname(String Firstname) {
		this.Firstname = Firstname;
	}
	
	public String getLastname() {
		return Lastname;
	}
	
	public void setLastname(String Lastname) {
		this.Lastname = Lastname;
	}
	
	public String getDate_Of_Birth() {
		return Date_Of_Birth;
	}
 
	public void setDate_Of_Birth(String Date_Of_Birth) {
		this.Date_Of_Birth = Date_Of_Birth;
	}
	
	public String getPhoneNumber() {
		return phonenumber;
	}
	
	public void setPhoneNumber(String PhoneNumber) {
		this.phonenumber = PhoneNumber;
	}
	
	public String getEmail() {
		return Email;
	}
	
	public void setEmail(String Email) {
		this.Email = Email;
	}

	@ManyToMany
	@JoinTable(name="Project",
				joinColumns={@JoinColumn(name="ID", referencedColumnName="ID")},
				inverseJoinColumns={@JoinColumn(name="Pr_ID", referencedColumnName="Pr_ID")})
	public List<Project> getProjects() {
		return Projects;
	}

	/*public void setProjects(List<Project> Projects) {
		this.Projects = Projects;
	}*/
	
	/*public Project Search_Project(String customer){
		for(Project project : Projects){
            if (project.getCustomer() == customer)
                return project;
        }
        return null;
	}*/
}
