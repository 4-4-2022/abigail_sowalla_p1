package com.fishyfriends.client;

import com.fishyfriends.Model.CurrentSession;
import com.fishyfriends.Model.ProgramStage;
import com.fishyfriends.Model.User;
import com.fishyfriends.client.Flows;
import com.fishyfriends.repository.UserDAO;

import java.util.Scanner;

public interface Switches extends Flows{

	//switch statement for main menu, logged out
	public static void switchMainOut(int userSelection, Scanner scanner) {
		switch(userSelection) {
		case 1: 
			CurrentSession amILoggedIn = CurrentSession.getInstance();
			amILoggedIn.logInOut(scanner);
			break;
		case 2: 
			Flows.createAccountFlow(scanner);
			break;
		case 3:
			//AppUI.catalogFlow();
			ProgramStage programStage = ProgramStage.getInstance();
			programStage.changeProgramStage(2); 
			break;
		case 4:
			System.out.println("Dive into the fishtank of your dreams!\nFishy Friends provides aquarium enthusiasts with happy, healthy animals. We've hooked over 100 happy customers since 2021.");
			break;
		case 5:
			System.out.println("Thanks for swimming by!");
			ProgramStage programStage2 = ProgramStage.getInstance();
			programStage2.changeProgramStage(0); 
			break;
		default: 
			System.out.println("That's not an option. Go fish!");
		}
	}

	//switch statement for main menu, logged in, primary customer
	public static void switchMainInPC(int userSelection, Scanner scanner) {
		switch(userSelection) {
		case 1: 
			CurrentSession amILoggedIn = CurrentSession.getInstance();
			amILoggedIn.logInOut(scanner);
			break;
		case 2: 
			ProgramStage programStage3 = ProgramStage.getInstance();
			programStage3.changeProgramStage(2); 			
			break;
		case 3:
			System.out.println("Dive into the fishtank of your dreams!\nFishy Friends provides aquarium enthusiasts with happy, healthy animals. We've hooked over 100 happy customers since 2021.");
			break;
		case 4:
			System.out.println("You have $" +300+". \n1) Return to main menu\n2) Add funds\n3) Remove Funds\n4) Tranfer funds");
			int nextStep = scanner.nextInt();
			if(nextStep==1) {
				break;
			}else if(nextStep==2) {
				Flows.addFundsFlow(scanner);
			}else if(nextStep==3) {
				Flows.removeFundsFlow(scanner);
			}else if(nextStep==4) {
				Flows.transferFundsFlow(scanner);
			}else {
				System.out.println("That is not a valid option.");
			}
			break;
		case 5:
			Flows.manageUsersFlow(scanner);
			break;
		case 6:
			CurrentSession currentSession = CurrentSession.getInstance();
			String username = currentSession.myUsername();
			User currentUser = UserDAO.getCurrentUser(username);
			User.printUserInfo(currentUser);
			System.out.println("\n1) Return to main menu\n2) Edit your account info");
			int nextAccountStep = scanner.nextInt();
			if(nextAccountStep==1) {
				break;
			}else if(nextAccountStep==2) {
				Flows.editMyAccountFlow(scanner);
			}else {
				System.out.println("That is not a valid option.");
			}
			break;
		case 7:
			System.out.println("Thanks for swimming by!");
			ProgramStage programStage2 = ProgramStage.getInstance();
			programStage2.changeProgramStage(0); 
			break;
		default: 
			System.out.println("That's not an option. Go fish!");
		}
	}

	//switch statement for main menu, logged in, secondary customer
	public static void switchMainInSC(int userSelection, Scanner scanner) {
		switch(userSelection) {
		case 1: 
			CurrentSession amILoggedIn = CurrentSession.getInstance();
			amILoggedIn.logInOut(scanner);
			break;
		case 2: 
			ProgramStage programStage3 = ProgramStage.getInstance();
			programStage3.changeProgramStage(2);
			break;
		case 3:
			System.out.println("Dive into the fishtank of your dreams!\nFishy Friends provides aquarium enthusiasts with happy, healthy animals. We've hooked over 100 happy customers since 2021.");
			break;
		case 4:
			System.out.println("Thanks for swimming by!");
			ProgramStage programStage2 = ProgramStage.getInstance();
			programStage2.changeProgramStage(0); 
			break;
		default: 
			System.out.println("That's not an option. Go fish!");
		}
	}

	//switch statement for main menu, logged in, Employee
	public static void switchMainInE(int userSelection, Scanner scanner) {
		switch(userSelection) {
		case 1: 
			CurrentSession amILoggedIn = CurrentSession.getInstance();
			amILoggedIn.logInOut(scanner);
			break;
		case 2: 
			Flows.editCatalogFlow(scanner);
			break;
		case 3:
			Flows.editAccountsFlow(scanner);
			break;
		case 4:
			System.out.println("Thanks for swimming by!");
			ProgramStage programStage2 = ProgramStage.getInstance();
			programStage2.changeProgramStage(0); 
			break;
		default: 
			System.out.println("That's not an option. Go fish!");
		}
	}
}
