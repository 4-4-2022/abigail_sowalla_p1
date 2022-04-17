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
import com.fishyfriends.Model.CurrentSession;
import com.fishyfriends.Model.ProgramStage;
import com.fishyfriends.repository.AnimalRepository;

//main method

public class Driver {
	public static void main(String[] args) {		
		
		//initial welcome message
		System.out.println("Welcome to Fishy Friends Aquarium Shop!\nWhat would you like to do?");
		
		//I'm using ProgramStage to tall me what part of the workflow the user is in.
		ProgramStage programStage = ProgramStage.getInstance();
		
		//initialize a scanner with the scope of the main method
		Scanner scanner = new Scanner(System.in);
		
		//set program to continue after first input until user is no longer interested
		boolean isUserInterested = true;
		while(isUserInterested) {
			
			//show user their options
			AppUI.printMenu();

			//scan user input
			int userSelection = scanner.nextInt();
			//scanner.nextLine();
			
			AppUI.chooseSwitch(userSelection);
			
			//determine course of action based on user input
			//AppUI.mainInSwitch(userSelection);
			
			// check if user is still interested
			if (programStage.returnsProgramStage()==0) {
				isUserInterested=false;
			}
		}
		
		//close scanner
		scanner.close();
		
	}
}