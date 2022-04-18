package com.fishyfriends.client;

import java.util.Scanner;

import com.fishyfriends.repository.AnimalDAO;

public interface Flows {
	public static void loginFlow(Scanner scanner) {
		System.out.println("Enter your username:");
		scanner.nextLine();
		String username = scanner.nextLine();
		System.out.println("Enter your Password:");
		String password = scanner.nextLine();
		System.out.println("Welcome back, "+username+"!");
	}
	
	public static void createAccountFlow(Scanner scanner) {
		System.out.println("Enter a username:");
		scanner.nextLine();
		String newUserName = scanner.nextLine();
		System.out.println("Enter a password:");
		String password = scanner.nextLine();
		System.out.println("Enter an email:");
		String email = scanner.nextLine();
		System.out.println("Would you like to enter your birthday? You'll receive special birthday coupons! \n1) Yes \n2) No");
		int confirm = scanner.nextInt();
		if(confirm==1) {
			System.out.println("Enter Birthday (MMDD):");
			scanner.nextLine();
			int Bday = scanner.nextInt();
		}
		System.out.println("Would you like to enter your Address? We'll mail you our fishy newsletter! \n1) Yes \n2) No");
		confirm = scanner.nextInt();
		if(confirm==1) {
			scanner.nextLine();
			System.out.println("Enter your street.");
			String street = scanner.nextLine();
			System.out.println("Enter your city.");
			String city = scanner.nextLine();
			System.out.println("Enter your state.");
			String state = scanner.nextLine();
			System.out.println("Enter your ZIP.");
			int zip = scanner.nextInt();
		}
		System.out.println("Thanks for joining FishyFriends, "+newUserName+"! \nLog in with your new username and password.");
	}
	
	public static void purchaseFlow(Scanner scanner) {
		System.out.println("Which animal would you like to purchase? \nType the ID number for the animal.");
		scanner.nextLine();
		int id = scanner.nextInt();
		System.out.println("How many "+id+" would you like to purchase?");
		int amount = scanner.nextInt();
		System.out.println(amount + " " + id + " will cost you "+(amount*3)+".\nYou have $" + 300 + ".\nConfirm Purchase?\n\n1) Confirm\n2) Cancel");
		int confirm = scanner.nextInt();
		if(confirm==1) {
			System.out.println("Thank you for your purchase!\n");
		}else {
			System.out.println("Purchase cancelled.");
		}
	}
	
	public static void addFundsFlow(Scanner scanner) {
		System.out.println("You have $" + 300 + " in your account.\nHow much would you like to add?");
		scanner.nextLine();
		int toAdd = scanner.nextInt();
		System.out.println("Enter your credit card number (no spaces).");
		double cc = scanner.nextDouble();
		System.out.println("Enter your PIN.");
		int pin = scanner.nextInt();
		System.out.println("Enter your credit card's expiration date (MMYY).");
		int exp = scanner.nextInt();
		System.out.println("You are adding $"+toAdd+" to your account.Confirm?\n\n1) Confirm\n2) Cancel");
		int confirm = scanner.nextInt();
		if(confirm==1) {
			System.out.println("Funds have been added!\n");
		}else {
			System.out.println("Operation cancelled.");
		}
	}
	
	public static void removeFundsFlow(Scanner scanner) {
		System.out.println("You have $" + 300 + " in your account.\nHow much would you like to remove?");
		scanner.nextLine();
		int toAdd = scanner.nextInt();
		System.out.println("Enter your credit card number to upload the funds to (no spaces).");
		double cc = scanner.nextDouble();
		System.out.println("Enter your PIN.");
		int pin = scanner.nextInt();
		System.out.println("Enter your credit card's expiration date (MMYY).");
		int exp = scanner.nextInt();
		System.out.println("You are removing $"+toAdd+" from your account.Confirm?\n\n1) Confirm\n2) Cancel");
		int confirm = scanner.nextInt();
		if(confirm==1) {
			System.out.println("Funds have been removed!\n");
		}else {
			System.out.println("Operation cancelled.");
		}
	}
	
	public static void transferFundsFlow(Scanner scanner) {
		System.out.println("You have $" + 300 + " in your account.\nHow much would you like to transfer?");
		scanner.nextLine();
		int toTransfer = scanner.nextInt();
		System.out.println("Type the username of the account you wish to transfer to.");
		scanner.nextLine();
		String otherUser = scanner.nextLine();
		System.out.println("You are transfering $"+toTransfer+" to "+otherUser+". Confirm?\n\n1) Confirm\n2) Cancel");
		int confirm = scanner.nextInt();
		if(confirm==1) {
			System.out.println("Funds have been transferred!\n");
		}else {
			System.out.println("Operation cancelled.\n");
		}
	}
	
	public static void manageUsersFlow(Scanner scanner) {
		System.out.println("Would you like to add or remove a user?\n\n1) Add\n2) Remove");
		scanner.nextLine();
		int choose = scanner.nextInt();
		if(choose==1) {
			scanner.nextLine();
			System.out.println("Type the username of the user you would like to add.");
			String newUserName = scanner.nextLine();
			System.out.println("Type a password for this user.");
			String newUserPassword = scanner.nextLine();
			System.out.println("Type an email we can send this user's login info to.");
			String newUserEmail = scanner.nextLine();
			System.out.println(newUserName+" has been added!\n");
		}else if (choose==2) {
			scanner.nextLine();
			System.out.println("Type the username of the user you would like to remove.");
			String removedUser = scanner.nextLine();
			System.out.println(removedUser+" has been removed!\n");
		}
	}
	
	public static void editMyAccountFlow(Scanner scanner) {
		System.out.println("Which info do you wish to edit?\n\n1) Username\n2) Password\n3) email\n4) Birthday\n5) Address");
		scanner.nextLine();
		int choose = scanner.nextInt();
		if(choose==1) {
			scanner.nextLine();
			System.out.println("Type your new username.");
			String newUserName = scanner.nextLine();
			System.out.println("Your username is now "+newUserName+"!\n");
		}else if (choose==2) {
			scanner.nextLine();
			System.out.println("Type your new password.");
			String newUserPassword = scanner.nextLine();
			System.out.println("Your password is now "+newUserPassword+"!\n");
		}else if (choose==3) {
			scanner.nextLine();
			System.out.println("Type your new email.");
			String newUserEmail = scanner.nextLine();
			System.out.println("Your email is now "+newUserEmail+"!\n");
		}else if (choose==4) {
			scanner.nextLine();
			System.out.println("Enter your birthday (MMDDYYY).");
			int newUserBday = scanner.nextInt();
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
			String zip = scanner.nextLine();
			System.out.println("Your address has been updated!\n");
		}
	}
	
	public static void editCatalogFlow(Scanner scanner) {
		AppUI.printItem(AnimalDAO.findAllAnimals());
		System.out.println("\nWould you like to add, remove, or edit an animal?\n\n1) Add\n2) Remove\n3) Edit\n4) Return to Main Menu");
		scanner.nextLine();
		int choose = scanner.nextInt();
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
			AnimalDAO.addAnimal(newAnimalName, newAnimalDifficulty, newAnimalSocial, newAnimalWater, newAnimalPrice);
			System.out.println(newAnimalName+" has been added to the catalog!\n");
		}else if (choose==2) {
			scanner.nextLine();
			System.out.println("Type the ID of the animal you would like to remove.");
			int removedAnimal = scanner.nextInt();
			AnimalDAO.removeAnimal(removedAnimal);
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
			System.out.println("The animal has been updated!\n");
		}else if (choose==4) {
			
		}
	}
	
	public static void editAccountsFlow(Scanner scanner) {
		System.out.println("Would you like to add, remove, or edit an account?\n\n1) Add\n2) Remove\n3) Edit");
		scanner.nextLine();
		int choose = scanner.nextInt();
		if(choose==1) {
			System.out.println("Type the username of the user for the account you would like to add.");
			scanner.nextLine();
			String newUserName = scanner.nextLine();
			System.out.println("Type a password for this user.");
			String newUserPassword = scanner.nextLine();
			System.out.println("Type an email we can send this user's login info to.");
			String newUserEmail = scanner.nextLine();
			System.out.println("Is this user an employee (true or false)?");
			String newUserIsEmployee = scanner.nextLine();
			System.out.println("Is this user an admin (true or false)?");
			String newUserIsAdmin = scanner.nextLine();
			System.out.println(newUserName+" has been added!\n");
		}else if (choose==2) {
			scanner.nextLine();
			System.out.println("Type the ID of the account you would like to remove.");
			int removedAccount = scanner.nextInt();
			System.out.println(removedAccount+" has been removed!\n");
		}else if (choose==3) {
			scanner.nextLine();
			System.out.println("Type the ID of the account you would like to edit.");
			int editedAccount = scanner.nextInt();
			System.out.println("Which feature would you like to edit?\n\n1) Name\n2) Balance");
			int choose2 = scanner.nextInt();
			System.out.println("Enter the new value:");
			scanner.nextLine();
			String newValue = scanner.nextLine();
			System.out.println(editedAccount+" has been updated!\n");
		}
	}
}
