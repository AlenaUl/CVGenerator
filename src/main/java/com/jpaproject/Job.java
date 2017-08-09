package com.jpaproject;

import javax.persistence.*;

import org.apache.commons.lang.builder.ToStringBuilder;

@Entity
public class Job {

	@Id
	private Integer job_id;
	private Integer emp_id;
	private Integer pr_id;
	private Integer p_id;
	private Employee employee;
	private Project project;
	private Part part;

	public Job(){}
	
	public Job(Integer emp_id, Integer pr_id, Integer p_id){
		
		this.emp_id = emp_id;
		this.pr_id = pr_id;
		this.p_id = p_id;
	}
	
	@Override
	public String toString(){
		return ToStringBuilder.reflectionToString(this);
	}
	
	@GeneratedValue
	public Integer getJob_id() {
		return job_id;
	}
	public void setJob_id(Integer job_id) {
		this.job_id = job_id;
	}
	@Column(name="emp_id")
	public Integer getId() {
		return emp_id;
	}
	public void setId(Integer emp_id) {
		this.emp_id = emp_id;
	}
	public Integer getPr_id() {
		return pr_id;
	}
	public void setPr_id(Integer pr_id) {
		this.pr_id = pr_id;
	}
	public Integer getP_id() {
		return p_id;
	}
	public void setP_id(Integer p_id) {
		this.p_id = p_id;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "emp_id")
	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "pr_id")
	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "p_id")
	public Part getPart() {
		return part;
	}

	public void setPart(Part part) {
		this.part = part;
	}

}
