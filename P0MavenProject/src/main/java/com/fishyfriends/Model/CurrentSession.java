package com.fishyfriends.Model;

//this Singleton will tell us whether the user is logged in, a primary user, or an employee. Note: Primary + Employee = Admin.

public class CurrentSession {
	private static CurrentSession instance;
	private boolean isloggedIn;
	private boolean isPrimary;
	private boolean isEmployee;
	private CurrentSession() {
		isloggedIn = false;
		isPrimary = false;
		isEmployee = false;
	}
	
	//This method creates an instance of the Singleton.
	public static CurrentSession getInstance() {
		if(instance==null)
			instance=new CurrentSession();
		return instance;
	}
	
	//this method is called to change whether the user is logged in or out.
	public void logInOut() {
		if(isloggedIn==true) {
			System.out.println("SEA you later!");
			isloggedIn=false;
		}else {
			System.out.println("Welcome back!");
			isloggedIn=true;
		}
	}
	
	//this method is used to set if the current user is an employee.
	public void employeeStatus(boolean status) {
		isEmployee=status;
	}
	
	public void primaryStatus(boolean status) {
		isPrimary=status;
	}
	
	//this method returns true when the user is logged in and false when the user is logged out.
	public boolean amILoggedIn() {
		return this.isloggedIn;
	}
	
	public boolean amIPrimary() {
		return this.isPrimary;
	}
	
	public boolean amIEmployee() {
		return this.isEmployee;
	}
}
