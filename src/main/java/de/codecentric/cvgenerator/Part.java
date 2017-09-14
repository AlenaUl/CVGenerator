package de.codecentric.cvgenerator;

import java.util.*;
import javax.persistence.*;

import org.apache.commons.lang.builder.ToStringBuilder;

@Entity
public class Part {
	@Id
	@GeneratedValue
	private Integer id;
	private String name;
	
	@OneToMany(mappedBy = "part", fetch = FetchType.LAZY)
	private Set<Job> jobs = new HashSet<Job>();
	
	public Part(){}
	
	public Part(Integer id, String name){
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

	
	public Set<Job> getJobs() {
		return jobs;
	}

	public void add(Job jobs) {
		this.jobs.add(jobs);
	}
	
	public void remove(Job jobs) {
		this.jobs.remove(jobs);
	}
}
