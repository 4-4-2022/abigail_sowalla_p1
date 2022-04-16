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
import java.sql.SQLException;

//import java features

import java.util.Scanner;

//import classes

import com.fishyfriends.Model.Animal;
import com.fishyfriends.Model.User;
import com.fishyfriends.client.AppUI;
import com.fishyfriends.Model.Account;
import com.fishyfriends.repository.AnimalRepository;

//main method

public class Driver {
	public static void main(String[] args) {

		//connection to a database. Use environment variables for username, password, url
		Connection conn = null;
		try {
		conn = DriverManager.getConnection(System.getenv("db_url"), 
				System.getenv("db_username"), 
				System.getenv("db_password")
				);
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		//fetch animal data
		AnimalRepository animalRepository = new AnimalRepository();
		Animal[] animals = animalRepository.listAllAnimals();
		
		//welcome message
		AppUI.printMainMenu();
		
		//open a scanner, scan user input, close scanner
		Scanner scanner = new Scanner(System.in);
		int userSelection = scanner.nextInt();
		scanner.close();
		
		//determine course of action based on user input
		switch(userSelection) {
		case 1: 
			System.out.println("Sorry, we don't have that feature yet.");
			break;
		case 2: 
			System.out.println("Sorry, we don't have that feature yet.");
			break;
		case 3:
			AppUI.printCatalog(animals);
			break;
		case 4:
			System.out.println("Dive into the fishtank of your dreams!\nFishy Friends provides aquarium enthusiasts with happy, healthy animals. We've hooked over 100 happy customers since 2021.");
			break;
		default: 
			System.out.println("That's not an option. Go fish!");
			
		}
		
	}
}