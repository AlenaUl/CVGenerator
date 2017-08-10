package de.codecentric.cvgenerator;

import java.util.*;

import javax.persistence.*;

import org.apache.commons.lang.builder.ToStringBuilder;

@Entity
public class Technology {
	
	@Id
	private Integer t_id;
	private String name;
	
	@OneToMany(mappedBy = "technology", fetch = FetchType.LAZY)
	private Set<ProjectTechnology> protech = new HashSet<ProjectTechnology>();
	
	public Technology(){}
	
	public Technology(Integer t_id, String name){
		this.t_id = t_id;
		this.name = name;
	}
	
	@Override
	public String toString(){
		return ToStringBuilder.reflectionToString(this);
	}
	
	@Column(name="t_id")
	public Integer getT_id() {
		return t_id;
	}

	public void setT_id(Integer t_id) {
		this.t_id = t_id;
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
