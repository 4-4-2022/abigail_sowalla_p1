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
	
	public User(String userName) {
		
		super();
		
		this.userName = userName;
		this.userAccountId = 0;
		this.password = null;
		this.isPrimary = false; 
		this.street = null;
		this.state = null;
		this.city = null;
		this.zip = 0; 
		this.email = null;
		this.birthday = 0;
		this.isEmployee = false;
		this.isAdmin = false;
	}
	
	@Override
	public String toString() {
		return "Username: " + userName;
	}
	
	public static void printUserInfo(User user) {
		System.out.println(
				"Username: "+user.userName+
				"\nPassword: "+user.password+
				"\nEmail: "+user.email+
				"\nBirthday: "+user.birthday+
				"\nAddress: \n"+user.street+"\n"+user.city+", "+user.state+" "+user.zip
				);
	}
	
}
