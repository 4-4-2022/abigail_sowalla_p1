package com.fishyfriends.client;

import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fishyfriends.repository.AnimalDAO;
import com.fishyfriends.Model.User;
import com.fishyfriends.repository.AccountDAO;
import com.fishyfriends.repository.UserDAO;

import com.fishyfriends.Model.CurrentSession;

public interface Flows {
	
	final Logger logger = LoggerFactory.getLogger(Flows.class);
	
	public static void loginFlow(Scanner scanner) {
		System.out.println("Enter your username:");
		scanner.nextLine();
		String username = scanner.nextLine();
		User currentUser = UserDAO.getCurrentUser(username);
		System.out.println("Enter your Password:");
		String password = scanner.nextLine();
		if(password.equals(currentUser.password)) {
			//send account data to CurrentSession
			CurrentSession amILoggedIn = CurrentSession.getInstance();
			amILoggedIn.logIn();
			amILoggedIn.setIsEmployee(currentUser.isEmployee);
			amILoggedIn.setIsPrimary(currentUser.isPrimary);
			amILoggedIn.setName(username);
			logger.info(username+"logged in.");
			System.out.println("Welcome back, "+username+"!");
		} else {
		System.out.println("The login info you entered was incorrect.");
		}
	}
	
	public static void createAccountFlow(Scanner scanner) {
		System.out.println("Enter a username:");
		scanner.nextLine();
		String newUserName = scanner.nextLine();
		System.out.println("Enter a password:");
		String password = scanner.nextLine();
		System.out.println("Enter an email:");
		String email = scanner.nextLine();
		System.out.println("Select an account ID:");
		int id = scanner.nextInt();
		System.out.println("Would you like to enter your birthday? You'll receive special birthday coupons! \n1) Yes \n2) No");
		int confirm = scanner.nextInt();
		int Bday=0;
		if(confirm==1) {
			System.out.println("Enter Birthday (MMDD):");
			scanner.nextLine();
			Bday = scanner.nextInt();
		}
		System.out.println("Would you like to enter your Address? We'll mail you our fishy newsletter! \n1) Yes \n2) No");
		confirm = scanner.nextInt();
		String street=null;
		String city=null;
		String state=null;
		int zip=0;
		if(confirm==1) {
			scanner.nextLine();
			System.out.println("Enter your street.");
			street = scanner.nextLine();
			System.out.println("Enter your city.");
			city = scanner.nextLine();
			System.out.println("Enter your state.");
			state = scanner.nextLine();
			System.out.println("Enter your ZIP.");
			zip = scanner.nextInt();
		}

		AccountDAO.addAccount(id, newUserName, 0);
		UserDAO.addUser(newUserName, id, password, true, street, city, state, zip, email, Bday, false, false);
		logger.info("New account created.");
		System.out.println("Thanks for joining FishyFriends, "+newUserName+"! \nLog in with your new username and password.");
	}
	
	public static void purchaseFlow(Scanner scanner) {
		float price;
		float balance;
		int accountID = AppUI.getUsersID();
		balance = AccountDAO.getAccountBalance(accountID);
		System.out.println("Which animal would you like to purchase? \nType the ID number for the animal.");
		scanner.nextLine();
		int id = scanner.nextInt();
		price = AnimalDAO.getAnimalPrice(id);
		System.out.println("How many would you like to purchase?");
		int amount = AppUI.verifyInBudget(price,scanner.nextInt(),balance,scanner);
		float total = amount*price;
		float newBalance = balance-total;
		System.out.println("That will cost you "+total+".\nYou have $" + balance + ".\nConfirm Purchase?\n\n1) Confirm\n2) Cancel");
		int confirm = scanner.nextInt();
		if(confirm==1) {
			AccountDAO.editAccountBalance(accountID,newBalance);
			logger.info(amount+" animals of ID#"+id+" were purchased.");
			System.out.println("Thank you for your purchase!\n");
		}else {
			System.out.println("Purchase cancelled.");
		}
	}
	
	public static void addFundsFlow(Scanner scanner) {
		float balance = AppUI.getUsersBalance();
		int accountID = AppUI.getUsersID();
		System.out.println("You have $" + balance + " in your account.\nHow much would you like to add?");
		scanner.nextLine();
		float toAdd = AppUI.verifyPositive(scanner.nextInt(),scanner);
		System.out.println("Enter your credit card number (no spaces).");
		double cc = scanner.nextDouble();
		System.out.println("Enter your PIN.");
		int pin = scanner.nextInt();
		System.out.println("Enter your credit card's expiration date (MMYY).");
		int exp = scanner.nextInt();
		System.out.println("You are adding $"+toAdd+" to your account. Confirm?\n\n1) Confirm\n2) Cancel");
		int confirm = scanner.nextInt();
		if(confirm==1) {
			AccountDAO.editAccountBalance(accountID,(balance+toAdd));
			logger.info("$"+balance+" added to account #"+accountID);
			System.out.println("Your new balance is "+(balance+toAdd)+"\n");
		}else {
			System.out.println("Operation cancelled.");
		}
	}
	
	public static void removeFundsFlow(Scanner scanner) {
		float balance = AppUI.getUsersBalance();
		int accountID = AppUI.getUsersID();
		System.out.println("You have $" + balance + " in your account.\nHow much would you like to remove?");
		scanner.nextLine();
		float toSub = AppUI.verifyPositive(scanner.nextInt(),scanner);
		System.out.println("Enter your credit card number to upload the funds to (no spaces).");
		double cc = scanner.nextDouble();
		System.out.println("Enter your PIN.");
		int pin = scanner.nextInt();
		System.out.println("Enter your credit card's expiration date (MMYY).");
		int exp = scanner.nextInt();
		System.out.println("You are removing $"+toSub+" from your account. Confirm?\n\n1) Confirm\n2) Cancel");
		int confirm = scanner.nextInt();
		if(confirm==1) {
			AccountDAO.editAccountBalance(accountID,(balance-toSub));
			logger.info("$"+balance+" removed from account #"+accountID);
			System.out.println("Your new balance is "+(balance-toSub)+"\n");
		}else {
			System.out.println("Operation cancelled.");
		}
	}
	
	public static void transferFundsFlow(Scanner scanner) {
		//get current session name
		float balance = AppUI.getUsersBalance();
		int accountID = AppUI.getUsersID();
		System.out.println("You have $" + balance + " in your account.\nHow much would you like to transfer?");
		scanner.nextLine();
		float toTransfer = AppUI.verifyPositive(scanner.nextInt(),scanner);
		System.out.println("Type the ID of the account you wish to transfer to.");
		scanner.nextLine();
		int otherUser = scanner.nextInt();
		float otherBalance = AccountDAO.getAccountBalance(otherUser);
		System.out.println("You are transfering $"+toTransfer+". Confirm?\n\n1) Confirm\n2) Cancel");
		int confirm = scanner.nextInt();
		if(confirm==1) {
			AccountDAO.editAccountBalance(accountID,(balance-toTransfer));
			AccountDAO.editAccountBalance(otherUser,(otherBalance+toTransfer));
			logger.info("$"+balance+" transferred from account #"+accountID+" to account #"+otherUser);
			System.out.println("Funds have been transferred!\n");
		}else {
			System.out.println("Operation cancelled.\n");
		}
	}
	
	public static void manageUsersFlow(Scanner scanner) {
		AppUI.printItem(UserDAO.findUsersByID());
		int accountID = AppUI.getUsersID();
		System.out.println("Would you like to add or remove a user?\n\n1) Add\n2) Remove\n3) Return to main menu");
		scanner.nextLine();
		int choose = AppUI.verify1to(scanner.nextInt(), scanner, 3);
		if(choose==1) {
			scanner.nextLine();
			System.out.println("Type the username of the user you would like to add.");
			String newUserName = scanner.nextLine();
			System.out.println("Type a password for this user.");
			String newUserPassword = scanner.nextLine();
			System.out.println("Type an email we can send this user's login info to.");
			String newUserEmail = scanner.nextLine();
			UserDAO.addUser(newUserName, accountID, newUserPassword, newUserEmail);
		}else if (choose==2) {
			scanner.nextLine();
			System.out.println("Type the username of the user you would like to remove.");
			String removedUser = scanner.nextLine();
			UserDAO.removeSingleUser(removedUser);
		}
	}
	
	public static void editMyAccountFlow(Scanner scanner) {
		CurrentSession currentSession = CurrentSession.getInstance();
		String username=currentSession.myUsername();
		System.out.println("Which info do you wish to edit?\n\n1) Username\n2) Password\n3) email\n4) Birthday\n5) Address");
		scanner.nextLine();
		int choose = AppUI.verify1to(scanner.nextInt(), scanner, 5);
		if(choose==1) {
			scanner.nextLine();
			System.out.println("Type your new username.");
			String newUserName = scanner.nextLine();
			UserDAO.editUserName(username, newUserName);
			currentSession.setName(newUserName);
			logger.info(username+"changed their username.");
			System.out.println("Your username is now "+newUserName+"!\n");
		}else if (choose==2) {
			scanner.nextLine();
			System.out.println("Type your new password.");
			String newUserPassword = scanner.nextLine();
			UserDAO.editUserPassword(username, newUserPassword);
			logger.info(username+"changed their password.");
			System.out.println("Your password is now "+newUserPassword+"!\n");
		}else if (choose==3) {
			scanner.nextLine();
			System.out.println("Type your new email.");
			String newUserEmail = scanner.nextLine();
			UserDAO.editUserEmail(username, newUserEmail);
			logger.info(username+"changed their email.");
			System.out.println("Your email is now "+newUserEmail+"!\n");
		}else if (choose==4) {
			scanner.nextLine();
			System.out.println("Enter your birthday (MMDDYYY).");
			int newUserBday = scanner.nextInt();
			UserDAO.editUserBirthday(username, newUserBday);
			logger.info(username+"changed their birthday.");
			System.out.println("Your birthday has been updated!\n");
		}else if (choose==5) {
			scanner.nextLine();
			System.out.println("Enter your street.");
			String street = scanner.nextLine();
			System.out.println("Enter your city.");
			String city = scanner.nextLine();
			System.out.println("Enter your state.");
			String state = scanner.nextLine();
			System.out.println("Enter your ZIP.");
			int zip = scanner.nextInt();
			UserDAO.editUserAddress(username, street, city, state, zip);
			logger.info(username+"changed their address.");
			System.out.println("Your address has been updated!\n");
		}
	}
	
	public static void editCatalogFlow(Scanner scanner) {
		AppUI.printItem(AnimalDAO.findAllAnimals());
		System.out.println("\nWould you like to add, remove, or edit an animal?\n\n1) Add\n2) Remove\n3) Edit\n4) Return to Main Menu");
		scanner.nextLine();
		int choose = AppUI.verify1to(scanner.nextInt(), scanner, 4);
		if(choose==1) {
			scanner.nextLine();
			System.out.println("Enter the requested info.\nSpecies:");
			String newAnimalName = scanner.nextLine();
			System.out.println("Price:");
			float newAnimalPrice = scanner.nextFloat();
			System.out.println("Difficulty:");
			scanner.nextLine();
			String newAnimalDifficulty = scanner.nextLine();
			System.out.println("Social (true or false):");
			boolean newAnimalSocial = scanner.nextBoolean();
			scanner.nextLine();
			System.out.println("Water Type (freshwater or saltwater):");
			String newAnimalWater = scanner.nextLine();
			System.out.println("Choose an ID #:");
			int newAnimalID = scanner.nextInt();
			AnimalDAO.addAnimal(newAnimalID, newAnimalName, newAnimalDifficulty, newAnimalSocial, newAnimalWater, newAnimalPrice);
			logger.info(newAnimalName+" has been added to the catalog.");
			System.out.println(newAnimalName+" has been added to the catalog!\n");
		}else if (choose==2) {
			scanner.nextLine();
			System.out.println("Type the ID of the animal you would like to remove.");
			int removedAnimal = scanner.nextInt();
			AnimalDAO.removeAnimal(removedAnimal);
			logger.info("Animal with ID #"+removedAnimal+" has been removed from the catalog.");
			System.out.println("Operation complete!\n");
		}else if (choose==3) {
			System.out.println("Type the ID of the animal you would like to edit.");
			scanner.nextLine();
			int editedAnimal = scanner.nextInt();
			System.out.println("Which feature would you like to edit?\n\n1) Species\n2) Price\n3) Difficulty\n4) Social\n5) Water Type");
			scanner.nextLine();
			int option = scanner.nextInt();
			if(option==1) {
				System.out.println("Enter the new species:");
				scanner.nextLine();
				String newValue = scanner.nextLine();
				AnimalDAO.editAnimalName(editedAnimal, newValue);
			} else if(option==2) {
				System.out.println("Enter the new price:");
				scanner.nextLine();
				float newValue = scanner.nextFloat();
				AnimalDAO.editAnimalPrice(editedAnimal, newValue);
			} else if(option==3) {
				System.out.println("Enter the new difficulty:");
				scanner.nextLine();
				String newValue = scanner.nextLine();
				AnimalDAO.editAnimalDifficulty(editedAnimal, newValue);
			} else if(option==4) {
				System.out.println("Is the animal social (true or false)?");
				scanner.nextLine();
				boolean newValue = scanner.nextBoolean();
				AnimalDAO.editAnimalSocial(editedAnimal, newValue);
			} else if(option==5) {
				System.out.println("Does this animal prefer freshwater or saltwater?");
				scanner.nextLine();
				String newValue = scanner.nextLine();
				AnimalDAO.editAnimalWater(editedAnimal, newValue);
			}
			logger.info("Animal with ID #"+editedAnimal+" has been edited.");
			System.out.println("The animal has been updated!\n");
		}else if (choose==4) {
			
		}
	}
	
	public static void editAccountsFlow(Scanner scanner) {
		AppUI.printItem(AccountDAO.findAllAccounts());
		System.out.println("\nWould you like to add, remove, or edit an account?\n\n1) Add\n2) Remove\n3) Edit\n4) Return to main menu");
		scanner.nextLine();
		int choose = AppUI.verify1to(scanner.nextInt(), scanner, 4);
		if(choose==1) {
			System.out.println("Type a name for the account you would like to add.");
			scanner.nextLine();
			String newAccountName = scanner.nextLine();
			System.out.println("What is the initial balance for this account?");
			Float newAccountBalance = scanner.nextFloat();
			System.out.println("Select an ID# for this account:");
			int newAccountID = scanner.nextInt();
			System.out.println("Now, create a user for the new account. Enter a username:");
			scanner.nextLine();
			String newUserName = scanner.nextLine();
			System.out.println("Type a password for this user.");
			String newUserPassword = scanner.nextLine();
			System.out.println("Type an email we can send this user's login info to.");
			String newUserEmail = scanner.nextLine();
			System.out.println("Is this user an employee (true or false)?");
			boolean newUserIsEmployee = scanner.nextBoolean();
			System.out.println("Is this user an admin (true or false)?");
			boolean newUserIsAdmin = scanner.nextBoolean();
			String street = null;
			String city = null;
			String state = null;
			int zip = 0;
			int birthday = 0;
			AccountDAO.addAccount(newAccountID, newAccountName, newAccountBalance);
			UserDAO.addUser(newUserName, newAccountID, newUserPassword, true, street, city, state, zip, newUserEmail, birthday, newUserIsEmployee, newUserIsAdmin);
			logger.info("New user "+newUserName+" has been added.");
			System.out.println(newUserName+" has been added!\n");
		}else if (choose==2) {
			scanner.nextLine();
			System.out.println("Type the ID of the account you would like to remove.");
			int removedAccount = scanner.nextInt();
			UserDAO.removeUser(removedAccount);
			AccountDAO.removeAccount(removedAccount);
			logger.info("Account ID #"+removedAccount+" has been removed.");
			System.out.println(removedAccount+" has been removed!\n");
		}else if (choose==3) {
			scanner.nextLine();
			System.out.println("Type the ID of the account you would like to edit.");
			int editedAccount = scanner.nextInt();
			System.out.println("Which feature would you like to edit?\n\n1) Name\n2) Balance");
			int choose2 = scanner.nextInt();
			if(choose2==1) {
				System.out.println("Enter the new name:");
				scanner.nextLine();
				String newValue = scanner.nextLine();
				AccountDAO.editAccountName(editedAccount, newValue);
			} else if(choose2==2) {
				System.out.println("Enter the new balance:");
				scanner.nextLine();
				float newValue = AppUI.verifyPositive(scanner.nextInt(),scanner);
				AccountDAO.editAccountBalance(editedAccount, newValue);
			}
			logger.info("Account ID #"+editedAccount+" has been edited.");
			System.out.println("Account ID #"+editedAccount+" has been updated!\n");
		}
	}
		
	public static void editAccountsFlowE(Scanner scanner) {
		AppUI.printItem(AccountDAO.findAllAccounts());
		System.out.println("\nWould you like to add or remove an account?\n\n1) Add\n2) Remove\n3) Return to main menu");
		scanner.nextLine();
		int choose = AppUI.verify1to(scanner.nextInt(), scanner, 3);
		if(choose==1) {
			System.out.println("Type a name for the account you would like to add.");
			scanner.nextLine();
			String newAccountName = scanner.nextLine();
			System.out.println("What is the initial balance for this account?");
			Float newAccountBalance = scanner.nextFloat();
			System.out.println("Select an ID# for this account:");
			int newAccountID = scanner.nextInt();
			System.out.println("Now, create a user for the new account. Enter a username:");
			scanner.nextLine();
			String newUserName = scanner.nextLine();
			System.out.println("Type a password for this user.");
			String newUserPassword = scanner.nextLine();
			System.out.println("Type an email we can send this user's login info to.");
			String newUserEmail = scanner.nextLine();
			System.out.println("Is this user an employee (true or false)?");
			boolean newUserIsEmployee = scanner.nextBoolean();
			System.out.println("Is this user an admin (true or false)?");
			boolean newUserIsAdmin = scanner.nextBoolean();
			String street = null;
			String city = null;
			String state = null;
			int zip = 0;
			int birthday = 0;
			AccountDAO.addAccount(newAccountID, newAccountName, newAccountBalance);
			UserDAO.addUser(newUserName, newAccountID, newUserPassword, true, street, city, state, zip, newUserEmail, birthday, newUserIsEmployee, newUserIsAdmin);
			logger.info("New user "+newUserName+" has been added.");
			System.out.println(newUserName+" has been added!\n");
		}else if (choose==2) {
			scanner.nextLine();
			System.out.println("Type the ID of the account you would like to remove.");
			int removedAccount = scanner.nextInt();
			UserDAO.removeUser(removedAccount);
			AccountDAO.removeAccount(removedAccount);
			logger.info("Account ID #"+removedAccount+" has been removed.");
			System.out.println(removedAccount+" has been removed!\n");
		}
	}
	public static void editUsersFlow(Scanner scanner) {
		AppUI.printItem(UserDAO.findAllUsers());
		System.out.println("\n\n1) Edit a user\n2) Return to main menu");
		scanner.nextLine();
		int choose = AppUI.verify1to(scanner.nextInt(), scanner, 2);
		if(choose==1) {
			System.out.println("Type the username of the user you'd like to edit:");
			String username = scanner.nextLine();
			System.out.println("Which info do you wish to edit?\n\n1) Username\n2) Password\n3) email\n4) Birthday\n5) Address");
			scanner.nextLine();
			int choose2 = AppUI.verify1to(scanner.nextInt(), scanner, 5);
			if(choose2==1) {
				scanner.nextLine();
				System.out.println("Type their new username.");
				String newUserName = scanner.nextLine();
				UserDAO.editUserName(username, newUserName);
				logger.info(username+"'s username was changed by an Admin.");
				System.out.println("Their username is now "+newUserName+"!\n");
			}else if (choose2==2) {
				scanner.nextLine();
				System.out.println("Type their new password.");
				String newUserPassword = scanner.nextLine();
				UserDAO.editUserPassword(username, newUserPassword);
				logger.info(username+"'s password was changed by an Admin.");
				System.out.println("Their password is now "+newUserPassword+"!\n");
			}else if (choose2==3) {
				scanner.nextLine();
				System.out.println("Type their new email.");
				String newUserEmail = scanner.nextLine();
				UserDAO.editUserEmail(username, newUserEmail);
				logger.info(username+"'s password was changed by an Admin.");
				System.out.println("Their email is now "+newUserEmail+"!\n");
			}else if (choose2==4) {
				scanner.nextLine();
				System.out.println("Enter their birthday (MMDDYYY).");
				int newUserBday = scanner.nextInt();
				UserDAO.editUserBirthday(username, newUserBday);
				logger.info(username+"'s birthday was changed by an Admin.");
				System.out.println("Their birthday has been updated!\n");
			}else if (choose2==5) {
				scanner.nextLine();
				System.out.println("Enter their street.");
				String street = scanner.nextLine();
				System.out.println("Enter their city.");
				String city = scanner.nextLine();
				System.out.println("Enter their state.");
				String state = scanner.nextLine();
				System.out.println("Enter their ZIP.");
				int zip = scanner.nextInt();
				UserDAO.editUserAddress(username, street, city, state, zip);
				logger.info(username+"'s username was changed by an Admin.");
				System.out.println("Their address has been updated!\n");
			}
		}
	}
}
