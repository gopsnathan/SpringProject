package com.jsonspring.SpringWS.model;


public class Gopi {
	int custId;
	String firstName;
	String lastName;
	String email;
	String timestamp;
	public Gopi(int custId, String firstName, String lastName, String email, String timestamp) {
		this.firstName = firstName;
		this.custId = custId;
		this.lastName = lastName;
		this.email = email;
		this.timestamp = timestamp;
		// TODO Auto-generated constructor stub
	}
	public int getCustId() {
		// TODO Auto-generated method stub
		return custId;
	}
	public String getFirstName() {
		// TODO Auto-generated method stub
		return firstName;
	}
	public String getLasttName() {
		// TODO Auto-generated method stub
		return lastName;
	}
	public String getEmail() {
		// TODO Auto-generated method stub
		return email;
	}
	public String getTimestamp() {
		// TODO Auto-generated method stub
		return timestamp;
	}
}
