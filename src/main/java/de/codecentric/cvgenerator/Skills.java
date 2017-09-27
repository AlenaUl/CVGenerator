package de.codecentric.cvgenerator;

import java.util.*;
import javax.persistence.*;

import org.apache.commons.lang.builder.ToStringBuilder;

@Entity
public class Skills {
	@Id
	@GeneratedValue
	private Integer id;
	private String name;
	
	@OneToMany(mappedBy = "skills", fetch = FetchType.LAZY)
	private Set<SkillsCategory> skillscategory = new HashSet<SkillsCategory>();
	
	@OneToMany(mappedBy = "skills", fetch = FetchType.LAZY)
	private Set<EmployeeSkills> employeeskills = new HashSet<EmployeeSkills>();
	
	public Skills(){}
	
	public Skills(Integer id, String name){
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
	
	public Set<SkillsCategory> getSkillsCategory() {
		return skillscategory;
	}

	public void add(SkillsCategory skillscategory) {
		this.skillscategory.add(skillscategory);
	}
	
	public void remove(SkillsCategory skillscategory) {
		this.skillscategory.remove(skillscategory);
	}
	
	public Set<EmployeeSkills> getEmployeeSkills() {
		return employeeskills;
	}

	public void add(EmployeeSkills employeeskills) {
		this.employeeskills.add(employeeskills);
	}
	
	public void remove(EmployeeSkills skillscategory) {
		this.employeeskills.remove(employeeskills);
	}
}

