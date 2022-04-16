package com.fishyfriends.Model;

//this Singleton will tell us whether the user is logged in.

public class LoggedIn {
	private static LoggedIn instance;
	private boolean loggedIn;
	private LoggedIn() {
		loggedIn = false;
	}
	
	//This method creates an instance of the Singleton.
	public static LoggedIn getInstance() {
		if(instance==null)
			instance=new LoggedIn();
		return instance;
	}
	
	//this method is called to change whether the user is logged in or out.
	public void logInOut() {
		//System.out.println("logInOut is running." + this.loggedIn);
		if(loggedIn==true) {
			System.out.println("SEA you later!");
			loggedIn=false;
		}else {
			System.out.println("Welcome back!");
			loggedIn=true;
		}
	}
	
	//this method returns true when the user is logged in and false when the user is logged out.
	public boolean amILoggedIn() {
		return this.loggedIn;
	}
}
