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
	private String phonenumber;
	private String Email;
	
	public Employee(){}
	
	public Employee(int ID, String Firstname, String Lastname, String Date_Of_Birth, String PhoneNumber, String Email){
		this.ID = ID;
		this.Firstname = Firstname;
		this.Lastname = Lastname;
		this.Date_Of_Birth = Date_Of_Birth;
		this.phonenumber = PhoneNumber;
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
	
	public String getPhoneNumber() {
		return phonenumber;
	}
	
	public void setPhoneNumber(String PhoneNumber) {
		this.phonenumber = PhoneNumber;
	}
	
	public String getEmail() {
		return Email;
	}
	
	public void setEmail(String Email) {
		this.Email = Email;
	}
}
