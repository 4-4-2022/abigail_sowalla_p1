package com.fishyfriends.client;

//imports

import com.fishyfriends.Model.Animal;
import com.fishyfriends.Model.CurrentSession;
import com.fishyfriends.Model.ProgramStage;
import com.fishyfriends.repository.AccountDAO;
import com.fishyfriends.repository.AnimalDAO;
//import com.fishyfriends.repository.AnimalRepository;

import java.util.Scanner;

// set up public class, then write methods
public class AppUI implements Menus, Switches, Flows{
	
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
		public static void chooseSwitch(int userSelection, Scanner scanner) {
			ProgramStage programStage = ProgramStage.getInstance();
			if(programStage.returnsProgramStage()==1) {
				chooseSwitchMain(userSelection, scanner);
			}else if(programStage.returnsProgramStage()==2) {
				catalogSwitch(userSelection, scanner);
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
				if(currentSession.amIPrimary()==true) {
					Menus.printMainMenuInA();
				}else
				Menus.printMainMenuInE();
			}
		}else {
			Menus.printMainMenuOut();
		}
	}
	
	public static void chooseSwitchMain(int userSelection, Scanner scanner) {
		CurrentSession currentSession = CurrentSession.getInstance();
		if(currentSession.amILoggedIn()==true) {
			if(currentSession.amIEmployee()==false) {
				if(currentSession.amIPrimary()==true) {
					Switches.switchMainInPC(userSelection, scanner);
				}else
					Switches.switchMainInSC(userSelection, scanner);
			}else {
				if(currentSession.amIPrimary()==true) {
					Switches.switchMainInA(userSelection, scanner);
				}else
					Switches.switchMainInE(userSelection, scanner);
			}
		}else {
			Switches.switchMainOut(userSelection, scanner);
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
		//AnimalRepository animalRepository = new AnimalRepository();
		//Animal[] animals = animalRepository.listAllAnimals();
		
		//print the catalog
		//printCatalog(animals);
		
		printItem(AnimalDAO.findAllAnimals());
		
		//print continue options
		System.out.println("\n1) Purchase an animal");
		System.out.println("2) Return to main menu");
	}
	
	public static int verify1to(int userSelection, Scanner scanner, int max) {
		while(userSelection<1 | userSelection>max) {
			System.out.println("Invalid choice. Type a number between 1 and "+max+".");
			userSelection = scanner.nextInt();
		}
		return userSelection;
	}
	
	public static float verifyPositive(float userSelection, Scanner scanner) {
		while(userSelection<0) {
			System.out.println("Invalid choice. Enter a positive value.");
			userSelection = scanner.nextInt();
		}
		return userSelection;
	}
	
	public static int verifyInBudget(float price, int userSelection, float balance, Scanner scanner) {
		while(userSelection*price>balance) {
			System.out.println("You don't have enough funds. Your balance is "+balance+". Choose a smaller amount or type 0.");
			userSelection = scanner.nextInt();
		}
		return userSelection;
	}
	
	
	
	public static void catalogSwitch(int userSelection, Scanner scanner) {
		CurrentSession currentSession = CurrentSession.getInstance();	
		userSelection=verify1to(userSelection, scanner, 2);
		if(userSelection==1) {
			if(currentSession.amILoggedIn()==true) {
				Flows.purchaseFlow(scanner);
			}else {
				System.out.println("You need to log in to purchase an animal. Return to the main menu and log in.\n");
			}
		}else {
			ProgramStage programStage = ProgramStage.getInstance();
			programStage.changeProgramStage(1);
		}
	}
	
	//to print database resultSets
	public static void printItem(Object item) {
		if(item instanceof Iterable) {
			Iterable iterable = (Iterable) item;
			for(Object o : iterable) {
				System.out.println(o);
			}
		}else if(item instanceof Object[]) {
			Object[] array = (Object[]) item;
			for(Object o : array) {
				System.out.println(o);
			}
		}else System.out.println(item);
	}
	
	//to get the balance of the user logged in
	public static float getUsersBalance() {
		CurrentSession currentsession=CurrentSession.getInstance();
		String user = currentsession.myUsername();
		int accountID= AccountDAO.getAccountID(user);
		float balance = AccountDAO.getAccountBalance(accountID);
		return balance;
	}
	
	//to get the account ID of the user currently logged in
	public static int getUsersID() {
		CurrentSession currentsession=CurrentSession.getInstance();
		String user = currentsession.myUsername();
		int accountID= AccountDAO.getAccountID(user);
		return accountID;
	}

}