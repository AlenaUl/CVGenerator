package de.codecentric.cvgenerator;

import java.util.*;

import javax.persistence.*;

import org.apache.commons.lang.builder.ToStringBuilder;

@Entity
public class Technology {
	
	@Id
	@GeneratedValue
	private Integer id;
	private String name;
	
	@OneToMany(mappedBy = "technology", fetch = FetchType.LAZY)
	private Set<ProjectTechnology> protech = new HashSet<ProjectTechnology>();
	
	public Technology(){}
	
	public Technology(Integer id, String name){
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

	
	public Set<ProjectTechnology> getProtech() {
		return protech;
	}

	public void add(ProjectTechnology protech) {
		this.protech.add(protech);
	}
	
	public void remove(ProjectTechnology protech) {
		this.protech.remove(protech);
	}
	
	/*public Project Search_Project(String customer){
		for(Project project : Projects){
            if (project.getCustomer() == customer)
                return project;
        }
        return null;
	}*/

}
