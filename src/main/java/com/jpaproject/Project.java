package com.jpaproject;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.*;

import org.apache.commons.lang.builder.ToStringBuilder;


@Entity
public class Project {
	
	@Id
	private Integer Pr_ID;
	private String Customer;
	private String Topic;
	private String Start_Date;
	private String End_Date;
	private List<Employee> Employees = new ArrayList<Employee>();;
	private List<Technology> Technologies = new ArrayList<Technology>();;
	
	public Project(){}
	
	public Project(Integer Pr_ID, String Customer, String Topic, String Start_Date, String End_Date){
		this.Pr_ID = Pr_ID;
		this.Customer = Customer;
		this.Topic = Topic;
		this.Start_Date = Start_Date;
		this.End_Date = End_Date;
	}
	
	@Override
	public String toString(){
		return ToStringBuilder.reflectionToString(this);
	}

	public Integer getPr_ID() {
		return Pr_ID;
	}

	public void setPr_ID(Integer Pr_ID) {
		if(Pr_ID == 0) throw new RuntimeException("NICHT GUT");
		this.Pr_ID = Pr_ID;
	}

	public String getCustomer() {
		return Customer;
	}

	public void setCustomer(String Customer) {
		this.Customer = Customer;
	}

	public String getTopic() {
		return Topic;
	}

	public void setTopic(String Topic) {
		this.Topic = Topic;
	}

	public String getStart_Date() {
		return Start_Date;
	}

	public void setStart_Date(String Start_Date) {
		this.Start_Date = Start_Date;
	}

	public String getEnd_Date() {
		return End_Date;
	}

	public void setEnd_Date(String End_Date) {
		this.End_Date = End_Date;
	}

	@ManyToMany(mappedBy="Projects")
	public List<Employee> getEmployees() {
		return Employees;
	}

	/*public void setEmployees(List<Employee> Employees) {
		this.Employees = Employees;
	}*/
	
	@ManyToMany(mappedBy="Projects")
	public List<Technology> getTechnologies() {
		return Technologies;
	}

	/*public void setTechnologies(List<Technology> Technologies) {
		this.Technologys = Technologies;
	}*/
	
	public Employee Search_Employee(String lastname){
		for(Employee employee : Employees){
            if (employee.getLastname() == lastname)
                return employee;
        }
        return null;
	}
	
	/*public Technology Search_Technology(String name){
		for(Technology technology : Technologies){
            if (technology.getName() == name)
                return technology;
        }
        return null;
	}*/
}
