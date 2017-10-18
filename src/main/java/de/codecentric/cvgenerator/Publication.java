package de.codecentric.cvgenerator;

import java.util.*;
import javax.persistence.*;

import org.apache.commons.lang.builder.ToStringBuilder;

@Entity
public class Publication {
	@Id
	@GeneratedValue
	private Integer id;
	private String title;
	private String journal;
	private Integer volume;
	private Integer start_page;
	private Integer end_page;

	@OneToMany(mappedBy = "publication", fetch = FetchType.LAZY)
	private Set<EmployeePublication> employeepublication = new HashSet<EmployeePublication>();
	
	public Publication(){}
	
	public Publication(Integer id, String title, String journal, Integer volume, Integer start_page, Integer end_page){
		this.id = id;
		this.title = title;
		this.journal = journal;
		this.volume = volume;
		this.start_page = start_page;
		this.end_page = end_page;
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
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getJournal() {
		return journal;
	}

	public void setJournal(String jornal) {
		this.journal = jornal;
	}

	public Integer getVolume() {
		return volume;
	}

	public void setVolume(Integer volume) {
		this.volume = volume;
	}

	public Integer getStartPage() {
		return start_page;
	}

	public void setStartPage(Integer start_page) {
		this.start_page = start_page;
	}

	public Integer getEndPage() {
		return end_page;
	}

	public void setEndPage(Integer end_page) {
		this.end_page = end_page;
	}
	
	public Set<EmployeePublication> getEmployeePublication() {
		return employeepublication;
	}

	public void add(EmployeePublication employeepublication) {
		this.employeepublication.add(employeepublication);
	}
	
	public void remove(EmployeePublication employeepublication) {
		this.employeepublication.remove(employeepublication);
	}
}


