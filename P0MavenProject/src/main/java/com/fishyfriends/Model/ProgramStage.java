package com.fishyfriends.Model;

/*this Singleton will track what stage of the program's flow the user is in.
 * 
 * programStage:
 * 1: Main Menu
 * 2: Viewing Catalog
 * 3: Logging In
 * 4: Creating an Account
 * 5: Ordering an Animal
 * 6: Manage Funds
 * 7: Add Funds
 * 8: Transfer Funds
 * 9: Remove Funds
 * 10: Viewing Account Info
 * 11: Changing Account Info
 * 12: Managing Accounts
 * 13: Add an account
 * 14: Remove an Account
 * 
 */

public class ProgramStage {
	private static ProgramStage instance;
	private int programStage;
	private ProgramStage() {
		programStage=1;
	}
	
	//this method returns an instance
	public static ProgramStage getInstance() {
		if(instance==null)
			instance=new ProgramStage();
		return instance;
	}
	
	//this method changes the program stage
	public void changeProgramStage(int stage) {
		this.programStage = stage;
	}
	
	//this method returns the program stage
	public int returnsProgramStage() {
		return this.programStage;
	}
	
}
