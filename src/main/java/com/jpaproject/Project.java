package com.jpaproject;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.apache.commons.lang.builder.ToStringBuilder;

@Entity
public class Project {
	
	@Id
	private int ID;
	private String Customer;
	private String Topic;
	private String Start_Date;
	private String End_Date;
	
	public Project(){}
	
	public Project(int ID, String Customer, String Topic, String Start_Date, String End_Date){
		this.ID = ID;
		this.Customer = Customer;
		this.Topic = Topic;
		this.Start_Date = Start_Date;
		this.End_Date = End_Date;
	}
	
	@Override
	public String toString(){
		return ToStringBuilder.reflectionToString(this);
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getCustomer() {
		return Customer;
	}

	public void setCustomer(String customer) {
		Customer = customer;
	}

	public String getTopic() {
		return Topic;
	}

	public void setTopic(String topic) {
		Topic = topic;
	}

	public String getStart_Date() {
		return Start_Date;
	}

	public void setStart_Date(String start_Date) {
		Start_Date = start_Date;
	}

	public String getEnd_Date() {
		return End_Date;
	}

	public void setEnd_Date(String end_Date) {
		End_Date = end_Date;
	}
}
