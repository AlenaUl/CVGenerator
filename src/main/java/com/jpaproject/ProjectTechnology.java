package com.jpaproject;
import javax.persistence.*;

import org.apache.commons.lang.builder.ToStringBuilder;

@Entity
public class ProjectTechnology {
	@Id
	private Integer protech_id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "pr_id")
	private Project project;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "t_id")
	private Technology technology;
	
	public ProjectTechnology(){}
	
	public ProjectTechnology(Integer pr_id, Integer t_id){
	//	this.setPr_id(pr_id);
//		this.setT_id(t_id);
	}

	@Override
	public String toString(){
		return ToStringBuilder.reflectionToString(this);
	}
	
	@GeneratedValue
	@Column(name="protech_id")
	public Integer getProtech_id() {
		return protech_id;
	}

	public void setProtech_id(Integer protech_id) {
		this.protech_id = protech_id;
	}
	
/*	public Integer getPr_id() {
		return pr_id;
	}

	public void setPr_id(Integer pr_id) {
		this.pr_id = pr_id;
	}

	public Integer getT_id() {
		return t_id;
	}

	public void setT_id(Integer t_id) {
		this.t_id = t_id;
	}
*/
	
	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	
	public Technology getTechnology() {
		return technology;
	}

	public void setTechnology(Technology technology) {
		this.technology = technology;
	}
}
