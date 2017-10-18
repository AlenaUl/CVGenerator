package de.codecentric.cvgenerator;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import javax.persistence.*;

import org.apache.commons.lang.builder.ToStringBuilder;


@Entity
public class Project {
	
	@Transient
	private DateFormat format = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
	
	@Id
	@GeneratedValue
	private Integer id;
	private String customer;
	private String topic;
	private String start_date;
	private String end_date;
	
	@OneToMany(mappedBy = "project", fetch = FetchType.LAZY)
	private Set<Job> jobs = new HashSet<Job>();
	
	@OneToMany(mappedBy = "project", fetch = FetchType.LAZY)
	private Set<ProjectTechnology> protech = new HashSet<ProjectTechnology>();

	public Project(){}
	
	public Project(Integer id, String customer, String topic, String start_date, String end_date){
		this.id = id;
		this.customer = customer;
		this.topic = topic;
		this.start_date = start_date;
		this.end_date = end_date;
	}
	
	@Override
	public String toString(){
		return ToStringBuilder.reflectionToString(this);
	}

	public Integer getID() {
		return id;
	}

	public void setID(Integer id) {
		if(id == 0) throw new RuntimeException("NICHT GUT");
		this.id = id;
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

	public String getStartDate() {
		return start_date;
	}
	
	public String getStartDateFormatted() throws ParseException {
		Date date = format.parse(start_date);
		SimpleDateFormat dt1 = new SimpleDateFormat("MM/yyyy");
        return dt1.format(date);
	}

	public void setStartDate(String start_date) {
		this.start_date = start_date;
	}

	public String getEndDate() {
		return end_date;
	}
	
	public String getEndDateFormatted() throws ParseException {
		Date date = format.parse(end_date);
		SimpleDateFormat dt1 = new SimpleDateFormat("MM/yyyy");
        return dt1.format(date);
	}
	
	public String getEndDateFormattedReversed() throws ParseException {
		Date date = format.parse(end_date);
		SimpleDateFormat dt1 = new SimpleDateFormat("yyyy-MM-dd");
        return dt1.format(date);
	}

	public void setEndDate(String end_date) {
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
}
