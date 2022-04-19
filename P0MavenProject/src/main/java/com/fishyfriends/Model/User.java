package com.fishyfriends.Model;

public class User {
	public String userName;
	public int userAccountId;
	public String password;
	public boolean isPrimary;
	public String street;
	public String city;
	public String state;
	public int zip;
	public String email;
	public int birthday;
	public boolean isEmployee;
	public boolean isAdmin;
	
	public User(String userName, int userAccountID, String password, boolean isPrimary, String street, String city, String state, int zip, String email, int birthday, boolean isEmployee, boolean isAdmin) {
		
		super();
		
		this.userName = userName;
		this.userAccountId = userAccountID;
		this.password = password;
		this.isPrimary = isPrimary; 
		this.street = street;
		this.state = state;
		this.city = city;
		this.zip = zip; 
		this.email = email;
		this.birthday = birthday;
		this.isEmployee = isEmployee;
		this.isAdmin = isAdmin;
	}
	
	@Override
	public String toString() {
		return "Username: " + userName;
	}
	
}
