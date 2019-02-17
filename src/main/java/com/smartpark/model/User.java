package com.smartpark.model;


public class User {
	String id;
	UserTypeEnum type;
	String username;
	String passwd;
	String firstname;
	String lastname;
	String phone;
	String email;
	
	
	//get and set for id
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	//get and set for type
	public UserTypeEnum getType() {
		return type;
	}
	
	public void setType(UserTypeEnum type) {
		this.type = type;
	}
	
	//get and set for username
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String un) {
		this.username = un; 
	}
	
	//get and set for passwd
	
	public String getPasswd() {
		return passwd;
	}
	
	public void setPasswd(String pw) {
		this.passwd = pw;
	}
	
	//get and set for firstname
	public String getFirstname() {
		return firstname;
	}
	
	public void setFirstname(String fn) {
		this.firstname = fn;
	}
	
	//get and set for lastname
	public String getLastname() {
		return lastname;
	}
	
	public void setLastname(String ln) {
		this.lastname = ln;
	}
	
	//get and set for phone
	public String getPhone() {
		return phone;
	}
	
	public void setPhone(String ph) {
		this.phone = ph;
	}
	
	//get and set for email
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String eml) {
		this.email = eml;
	}
	
	
}
