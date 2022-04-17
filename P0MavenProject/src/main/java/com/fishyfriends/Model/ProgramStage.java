package com.fishyfriends.Model;

//this Singleton will track what stage of the program's flow the user is in.

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
