package de.codecentric.cvgenerator;

import java.util.*;
import javax.persistence.*;

import org.apache.commons.lang.NotImplementedException;
import org.apache.commons.lang.builder.ToStringBuilder;

@Entity
public class Employee {

	@Id
	@GeneratedValue
	private Integer id;
	private String firstname;
	private String lastname;
	private String date_of_birth;
	private String phonenumber;
	private String email;
	
	@OneToMany(mappedBy = "employee", fetch = FetchType.LAZY)
	private Set<Job> jobs = new HashSet<Job>();
	
	public Employee(){}
	
	public Employee(Integer id, String firstname, String lastname, String date_of_birth, String phonenumber, String email){
		this.id = id;
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
		return id;
	}
	
	public void setID(Integer id) {
		if(id == 0) throw new RuntimeException();
		this.id = id;
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
	
	/**
	 * Get all projects of this employee with given role.
	 * @param part
	 * @return
	 */
	public Collection<Project> getProjectsWithPart(Part part) {
		Collection<Project> projects = new LinkedList<Project>();
		for (Job job : jobs) {
			if (job.getPart().equals(part)) {
				projects.add(job.getProject());
			}
		}
		return projects;
	}
	
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
