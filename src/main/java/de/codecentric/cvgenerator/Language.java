package de.codecentric.cvgenerator;

import java.util.*;
import javax.persistence.*;

import org.apache.commons.lang.builder.ToStringBuilder;

@Entity
public class Language {
	@Id
	@GeneratedValue
	private Integer id;
	private String name;
	
	@OneToMany(mappedBy = "language", fetch = FetchType.LAZY)
	private Set<EmployeeLanguage> employeelanguage = new HashSet<EmployeeLanguage>();
	
	public Language(){}
	
	public Language(Integer id, String name){
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

	
	public Set<EmployeeLanguage> getEmployeeLanguage() {
		return employeelanguage;
	}

	public void add(EmployeeLanguage employeelanguage) {
		this.employeelanguage.add(employeelanguage);
	}
	
	public void remove(EmployeeLanguage employeelanguage) {
		this.employeelanguage.remove(employeelanguage);
	}
}
