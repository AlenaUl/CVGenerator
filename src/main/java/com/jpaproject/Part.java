package com.jpaproject;

import java.util.*;
import javax.persistence.*;

import org.apache.commons.lang.builder.ToStringBuilder;

@Entity
public class Part {
	@Id
	private Integer p_id;
	private String name;
	private Set<Job> jobs = new HashSet<Job>();
	
	public Part(){}
	
	public Part(Integer p_id, String name){
		this.p_id = p_id;
		this.name = name;
	}
	
	@Override
	public String toString(){
		return ToStringBuilder.reflectionToString(this);
	}
	
	public Integer getP_id() {
		return p_id;
	}

	public void setP_id(Integer p_id) {
		this.p_id = p_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@OneToMany(mappedBy = "part", fetch = FetchType.LAZY)
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
