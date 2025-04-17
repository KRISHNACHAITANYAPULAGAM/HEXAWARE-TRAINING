package com.hexaware.entity;

public class Admin {
	private String LoginID;
	private String password;
	public Admin(String Username,String password) {
		this.LoginID=Username;
		this.password=password;
	}
	
	public String getUsername() {
		return LoginID;
	}
	public String getPassword() {
		return password;
	}
	

}
