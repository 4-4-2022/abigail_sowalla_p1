package com.fishyfriends.client;

//imports

import com.fishyfriends.Model.Animal;
import com.fishyfriends.Model.CurrentSession;
import com.fishyfriends.Model.ProgramStage;
import com.fishyfriends.repository.AnimalRepository;


import java.util.Scanner;

// set up public class, then write methods
public class AppUI implements Menus, Switches{
	
	//log in or out
	public static boolean logginInOut(boolean isLoggedIn) {
		if(isLoggedIn==true) {
			System.out.println("Thanks for logging out!");
			return false;
		}else 
			System.out.println("Thanks for logging in!");
			return true;
	}
	
	//decide which menu category to print
	public static void printMenu() {
		ProgramStage programStage = ProgramStage.getInstance();
		if(programStage.returnsProgramStage()==1) {
			printMainMenu();
		}else if(programStage.returnsProgramStage()==2) {
			catalogMenu();
		}
	}
	
	//decide which menu category to print
		public static void chooseSwitch(int userSelection) {
			ProgramStage programStage = ProgramStage.getInstance();
			if(programStage.returnsProgramStage()==1) {
				chooseSwitchMain(userSelection);
			}else if(programStage.returnsProgramStage()==2) {
				catalogSwitch(userSelection);
			}
		}
	
	//welcome menu (logged out)
	public static void printMainMenu() {
		//to decide which menu to show, the program needs to know whether the user is logged in, if they're a primary user, and if they're an employee.
		CurrentSession currentSession = CurrentSession.getInstance();
		if(currentSession.amILoggedIn()==true) {
			if(currentSession.amIEmployee()==false) {
				if(currentSession.amIPrimary()==true) {
					Menus.printMainMenuInPC();
				}else
					Menus.printMainMenuInSC();
			}else {
				Menus.printMainMenuInE();
			}
		}else {
			Menus.printMainMenuOut();
		}
	}
	
	public static void chooseSwitchMain(int userSelection) {
		CurrentSession currentSession = CurrentSession.getInstance();
		if(currentSession.amILoggedIn()==true) {
			if(currentSession.amIEmployee()==false) {
				if(currentSession.amIPrimary()==true) {
					Switches.switchMainInPC(userSelection);
				}else
					Switches.switchMainInSC(userSelection);
			}else {
				Switches.switchMainInE(userSelection);
			}
		}else {
			Switches.switchMainOut(userSelection);
		}
	}
	
	//Print  the animal catalog
	public static void printCatalog(Animal[] animals) {
		for(int i=0; i<animals.length; i++ ) {
			System.out.println(animals[i]);
		}
	}
	
	//Start the catalog workflow
	public static void catalogMenu() {

		//fetch animal data
		AnimalRepository animalRepository = new AnimalRepository();
		Animal[] animals = animalRepository.listAllAnimals();
		
		//print the catalog
		printCatalog(animals);
		
		//print continue options
		System.out.println("\n1) Purchase an animal");
		System.out.println("2) Return to main menu");
	}
	
	public static void catalogSwitch(int userSelection) {
			
		if(userSelection==1) {
			System.out.println("You need to log in to purchase an animal. Return to the main menu and log in.\n");
		}else {
			ProgramStage programStage = ProgramStage.getInstance();
			programStage.changeProgramStage(1);
		}
	}

}