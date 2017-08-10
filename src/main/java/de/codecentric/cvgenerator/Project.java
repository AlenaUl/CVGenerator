package de.codecentric.cvgenerator;

import java.util.*;
import javax.persistence.*;

import org.apache.commons.lang.builder.ToStringBuilder;


@Entity
public class Project {
	
	@Id
	private Integer pr_id;
	private String customer;
	private String topic;
	private String start_date;
	private String end_date;
	
	@OneToMany(mappedBy = "project", fetch = FetchType.LAZY)
	private Set<Job> jobs = new HashSet<Job>();
	
	@OneToMany(mappedBy = "project", fetch = FetchType.LAZY)
	private Set<ProjectTechnology> protech = new HashSet<ProjectTechnology>();

	public Project(){}
	
	public Project(Integer pr_id, String customer, String topic, String start_date, String end_date){
		this.pr_id = pr_id;
		this.customer = customer;
		this.topic = topic;
		this.start_date = start_date;
		this.end_date = end_date;
	}
	
	@Override
	public String toString(){
		return ToStringBuilder.reflectionToString(this);
	}

	@Column(name="pr_id")
	public Integer getPrID() {
		return pr_id;
	}

	public void setPrID(Integer pr_id) {
		if(pr_id == 0) throw new RuntimeException("NICHT GUT");
		this.pr_id = pr_id;
	}

	public String getCustomer() {
		return customer;
	}

	public void setCustomer(String customer) {
		this.customer = customer;
	}

	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

	public String getStart_Date() {
		return start_date;
	}

	public void setStart_date(String start_date) {
		this.start_date = start_date;
	}

	public String getEnd_date() {
		return end_date;
	}

	public void setEnd_Date(String end_date) {
		this.end_date = end_date;
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
	
	
	public Set<ProjectTechnology> getProtech() {
		return protech;
	}

	public void setProtech(Set<ProjectTechnology> protech) {
		this.protech = protech;
	}
	
	public void add(ProjectTechnology protech) {
		this.protech.add(protech);
	}
	
	public void remove(ProjectTechnology protech) {
		this.protech.remove(protech);
	}
	
	/*public Technology Search_Technology(String name){
		for(Technology technology : Technologies){
            if (technology.getName() == name)
                return technology;
        }
        return null;
	}*/
}
