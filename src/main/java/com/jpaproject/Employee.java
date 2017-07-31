package com.jpaproject;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.apache.commons.lang.builder.ToStringBuilder;

@Entity
public class Employee {

	@Id
	private int ID;
	private String Firstname;
	private String Lastname;
	private String Date_Of_Birth;
	private String Phone_Number;
	private String Email;
	
	public Employee(){}
	
	public Employee(int ID, String Firstname, String Lastname, String Date_Of_Birth, String phone_number, String Email){
		this.ID = ID;
		this.Firstname = Firstname;
		this.Lastname = Lastname;
		this.Date_Of_Birth = Date_Of_Birth;
		this.Phone_Number = phone_number;
		this.Email = Email;
	}
	
	@Override
	public String toString(){
		return ToStringBuilder.reflectionToString(this);
	}
	
	public int getID() {
		return ID;
	}
	
	public void setID(int ID) {
		this.ID = ID;
	}
	
	public String getFirstname() {
		return Firstname;
	}
	
	public void setFirstname(String Firstname) {
		this.Firstname = Firstname;
	}
	
	public String getLastname() {
		return Lastname;
	}
	
	public void setLastname(String Lastname) {
		this.Lastname = Lastname;
	}
	
	public String getDate_Of_Birth() {
		return Date_Of_Birth;
	}
 
	public void setDate_Of_Birth(String Date_Of_Birth) {
		this.Date_Of_Birth = Date_Of_Birth;
	}
	
	public String getPhone_Number() {
		return Phone_Number;
	}
	
	public void setPhone_Number(String Phone_Number) {
		this.Phone_Number = Phone_Number;
	}
	
	public String getEmail() {
		return Email;
	}
	
	public void setEmail(String Email) {
		this.Email = Email;
	}
}