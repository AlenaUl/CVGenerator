package de.codecentric.cvgenerator;

import java.util.*;
import javax.persistence.*;

import org.apache.commons.lang.builder.ToStringBuilder;

@Entity
public class Category {
	@Id
	@GeneratedValue
	private Integer id;
	private String name;
	
	@OneToMany(mappedBy = "category", fetch = FetchType.LAZY)
	private Set<SkillsCategory> skillscategory = new HashSet<SkillsCategory>();
	
	public Category(){}
	
	public Category(Integer id, String name){
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

	
	public Set<SkillsCategory> getJSkillsCategory() {
		return skillscategory;
	}

	public void add(SkillsCategory skillscategory) {
		this.skillscategory.add(skillscategory);
	}
	
	public void remove(SkillsCategory skillscategory) {
		this.skillscategory.remove(skillscategory);
	}
}

