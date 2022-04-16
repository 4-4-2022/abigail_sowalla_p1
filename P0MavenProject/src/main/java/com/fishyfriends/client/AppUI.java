package com.fishyfriends.client;

//imports

import com.fishyfriends.Model.Animal;
import com.fishyfriends.Model.LoggedIn;
import com.fishyfriends.repository.AnimalRepository;
import com.fishyfriends.Driver;

// set up public class, then write methods

public class AppUI {
	
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
	public static void printMenu(int flowStage, boolean isEmployee, boolean isPrimary) {
		if(flowStage==1) {
			printMainMenu(isEmployee, isPrimary);
		}else if(flowStage==2) {
			catalogFlow();
		}
	}
	
	//welcome menu (logged out)
	public static void printMainMenu(boolean isEmployee, boolean isPrimary) {
		//to decide which menu to show, the program needs to know whether the user is logged in, if they're a primary user, and if they're an employee.
		LoggedIn amILoggedIn = LoggedIn.getInstance();
		if(amILoggedIn.amILoggedIn()==true) {
			if(isEmployee==false) {
				if(isPrimary==true) {
					printMainMenuInPC();
				}else
					printMainMenuInSC();
			}else {
				printMainMenuInE();
			}
		}else printMainMenuOut();
	}
	
	public static void printMainMenuOut() {
		System.out.println(
				"\n1) Log in"
				+ "\n2) Create an account"
				+ "\n3) Browse our catalog"
				+ "\n4) About Fishy Friends"
				+ "\n5) Exit Fishy Friends"
				+ "\n\nType a number to continue.");
	}
	
	//welcome menu (logged in, Primary Customer)
	public static void printMainMenuInPC() {
		System.out.println("\n1) Log out"
				+ "\n2) View Cart"
				+ "\n3) Browse our catalog"
				+ "\n4) About Fishy Friends"
				+ "\n5) Manage Funds"
				+ "\n6) Manage Users"
				+ "\n7) Account Info"
				+ "\n8) Exit Fishy Friends"
				+ "\n\nType a number to continue.");
	}
	
	//welcome menu (logged in, Secondary Customer)
	public static void printMainMenuInSC() {
		System.out.println("\n1) Log out"
				+ "\n2) View Cart"
				+ "\n3) Browse our catalog"
				+ "\n4) About Fishy Friends"
				+ "\n5) Manage Funds"
				+ "\n6) Exit Fishy Friends"
				+ "\n\nType a number to continue.");
	}
		
	//welcome menu (logged in, Employee)
	public static void printMainMenuInE() {
		System.out.println("\n1) Log out"
				+ "\n2) View & Edit Catalog"
				+ "\n3) View & Edit Accounts"
				+ "\n4) Exit Fishy Friends"
				+ "\n\nType a number to continue.");
	}
	
	//Print  the animal catalog
	public static void printCatalog(Animal[] animals) {
		for(int i=0; i<animals.length; i++ ) {
			System.out.println(animals[i]);
		}
	}
	
	//Start the catalog workflow
	public static void catalogFlow() {

		//fetch animal data
		AnimalRepository animalRepository = new AnimalRepository();
		Animal[] animals = animalRepository.listAllAnimals();
		
		//print the catalog
		printCatalog(animals);
		
		//print continue options
		System.out.println("\n1) Add an animal to your cart");
		System.out.println("2) Return to main menu");
	}
	
	
	/*
	public static int changeFlowStage(int userSelection) {
		if(userSelection==3) {
			return 2;
		}else if(userSelection==5) {
			System.out.println("0 was returned");
			return 0;
		} else return 1;
	}
	*/
	
	public static int mainInSwitch(int userSelection, int flowStage) {
		switch(userSelection) {
		case 1: 
			//isLoggedIn = AppUI.logginInOut(isLoggedIn);
			return flowStage;
			//break;
		case 2: 
			if(flowStage==2) {return 1;}
			System.out.println("Sorry, we don't have that feature yet.");
			return flowStage;
			//break;
		case 3:
			//AppUI.catalogFlow();
			return 2;
			//break;
		case 4:
			System.out.println("Dive into the fishtank of your dreams!\nFishy Friends provides aquarium enthusiasts with happy, healthy animals. We've hooked over 100 happy customers since 2021.");
			return flowStage;
			//break;
		case 5:
			System.out.println("Thanks for swimming by!");
			return 0;
			//break;
		default: 
			System.out.println("That's not an option. Go fish!");
			return flowStage;
		}
	}

}