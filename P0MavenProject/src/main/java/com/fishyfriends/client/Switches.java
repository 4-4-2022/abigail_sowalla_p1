package com.fishyfriends.client;

import com.fishyfriends.Model.CurrentSession;
import com.fishyfriends.Model.ProgramStage;

public interface Switches {

	//switch statement for main menu, logged out
	public static void switchMainOut(int userSelection) {
		switch(userSelection) {
		case 1: 
			CurrentSession amILoggedIn = CurrentSession.getInstance();
			amILoggedIn.logInOut();
			break;
		case 2: 
			/*ProgramStage programStage = ProgramStage.getInstance();
			if(programStage.returnsProgramStage()==2) { 
				programStage.changeProgramStage(1); 
			}*/
			System.out.println("Sorry, we don't have that feature yet.");
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
	public static void switchMainInPC(int userSelection) {
		switch(userSelection) {
		case 1: 
			CurrentSession amILoggedIn = CurrentSession.getInstance();
			amILoggedIn.logInOut();
			break;
		case 2: 
			ProgramStage programStage3 = ProgramStage.getInstance();
			programStage3.changeProgramStage(2); 			System.out.println("Sorry, we don't have that feature yet.");
			break;
		case 3:
			System.out.println("Dive into the fishtank of your dreams!\nFishy Friends provides aquarium enthusiasts with happy, healthy animals. We've hooked over 100 happy customers since 2021.");
			break;
		case 4:
			System.out.println("You want to manage your funds. We don't have that feature yet.");
			break;
		case 5:
			System.out.println("You want to manage account users. We don't have that feature yet.");
			break;
		case 6:
			System.out.println("You want to view your account info. We don't have that feature yet.");
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
	public static void switchMainInSC(int userSelection) {
		switch(userSelection) {
		case 1: 
			CurrentSession amILoggedIn = CurrentSession.getInstance();
			amILoggedIn.logInOut();
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
	public static void switchMainInE(int userSelection) {
		switch(userSelection) {
		case 1: 
			CurrentSession amILoggedIn = CurrentSession.getInstance();
			amILoggedIn.logInOut();
			break;
		case 2: 
			ProgramStage programStage3 = ProgramStage.getInstance();
			programStage3.changeProgramStage(2); 			System.out.println("Sorry, we don't have that feature yet.");
			break;
		case 3:
			System.out.println("You want to view & edit accounts. We don't have that feature yet.");
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
