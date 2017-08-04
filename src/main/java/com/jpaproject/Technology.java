package com.jpaproject;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.*;

import org.apache.commons.lang.builder.ToStringBuilder;

@Entity
public class Technology {
	
	@Id
	private Integer T_ID;
	private String Name;
	private List<Project> Projects = new ArrayList<Project>();
	
	public Technology(){}
	
	public Technology(Integer T_ID, String Name){
		this.T_ID = T_ID;
		this.Name = Name;
	}
	
	@Override
	public String toString(){
		return ToStringBuilder.reflectionToString(this);
	}
	
	public Integer getT_ID() {
		return T_ID;
	}

	public void setT_ID(Integer T_ID) {
		this.T_ID = T_ID;
	}

	public String getName() {
		return Name;
	}

	public void setName(String Name) {
		this.Name = Name;
	}

	@ManyToMany
	@JoinTable(name="Project",
				joinColumns={@JoinColumn(name="T_ID", referencedColumnName="T_ID")},
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
