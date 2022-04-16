//Project 0 - "Fishy Friends Aquarium Shop - Supplying All Your Aquarium Needs

/*
 * To push to Github:
 * cd ~
 * cd users
 * cd documents
 * cd rev_training_docs
 * cd "Project 0"
 * Git add .
 * git commit -m "details"
 * git push
 * 
 * Github URL: https://github.com/4-4-2022/abigail_sowalla_p0.git
 * Location: C:\Users\abbys\Documents\rev_training_docs\Project 0
 */

/*
 * This is my project. It simulates an Aquarium shop. Users will be able to make an account with a username and password, have more than one account, add a secondary user to pick up orders, add a second user who can make orders, add funds, remove funds, transfer funds, browse the shop's catalog, and add items to a cart. Employees will be able to view account information (users, user info, funds) and cancel accounts. Admin employees should be able to modify account blances and user info.
*/

//package declaration

package com.fishyfriends;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

//import java features

import java.util.Scanner;

//import classes

import com.fishyfriends.Model.Animal;
import com.fishyfriends.Model.User;
import com.fishyfriends.client.AppUI;
import com.fishyfriends.Model.Account;
import com.fishyfriends.Model.LoggedIn;
import com.fishyfriends.repository.AnimalRepository;

//main method

public class Driver {
	public static void main(String[] args) {		
		
		//initial welcome message
		System.out.println("Welcome to Fishy Friends Aquarium Shop!\nWhat would you like to do?");
		
		//initialize variables to track user status
		boolean isEmployee = false;
		boolean isPrimary = false;
		
		/*
		 * I'm using flowStage to tall me what part of the workflow the user is in.
		 * 
		 * flowstage 0 exits the program.
		 * flowStage 1 is the main menu. 
		 * flowStage 2 is the catalog menu.
		 * 
		 * each flowStage points to a unique menu and switch statement.
		 */
		int flowStage = 1;
		
		//initialize a scanner with the scope of the main method
		Scanner scanner = new Scanner(System.in);
		
		//set program to continue after first input until user is no longer interested
		boolean isUserInterested = true;
		while(isUserInterested) {
			
			//welcome message
			AppUI.printMenu(flowStage, isEmployee, isPrimary);
			
			//scan user input
			int userSelection = scanner.nextInt();
			scanner.nextLine();
			
			//determine course of action based on user input
			flowStage=AppUI.mainInSwitch(userSelection, flowStage);
			
			//Instantiate Singleton "LoggedIn", then log in or log out.
			if(userSelection==1) {
				LoggedIn amILoggedIn = LoggedIn.getInstance();
				amILoggedIn.logInOut();
			}
			
			//AppUI.ChooseSwitch(userSelection, flowStage);
			
			// check if user is still interested
			if (flowStage==0) {
				isUserInterested=false;
			}
		}
		
		//close scanner
		scanner.close();
		
	}
}