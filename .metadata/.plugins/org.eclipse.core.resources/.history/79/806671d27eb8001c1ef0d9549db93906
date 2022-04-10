//Project 0 - "Fishy Friends Aquarium Shop - Supplying All Your Aquarium Needs"
/*
This is my project. It simulates an Aquarium shop. Users will be able to make an account with a username and password, have more than one account, add a secondary user to pick up orders, add a second user who can make orders, add funds, remove funds, transfer funds, browse the shop's catalog, and add items to a cart. Employees will be able to view account information (users, user info, funds) and cancel accounts. Admin employees should be able to modify account blances and user info.
*/
package com.fishyfriends;

import com.fishyfriends.Model.Animal;
import java.util.Scanner;

public class Driver {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		//welcome message
		System.out.println("Welcome to Fishy Friends Aquarium Shop!\nWhat would you like to do?\n\n1) Log into your account\n2) Create an account\n3) Browse our catalog \n4) About Fishy Friends\n\nType a number to continue.");
		
		//create an animal
		Animal beta = new Animal("Beta Fish", "easy", false, "freshwater");
		
		//scan user input
		int userSelection = scanner.nextInt();
		
		//determine course of action based on user input
		switch(userSelection) {
		case 1: 
			System.out.println("Sorry, we don't have that feature yet.");
			break;
		case 2: 
			System.out.println("Sorry, we don't have that feature yet.");
			break;
		case 3:
			System.out.println("Species: " + beta.species + ". Difficulty: " + beta.difficulty);
			break;
		case 4:
			System.out.println("Dive into the fishtank of your dreams!\nFishy Friends provides aquarium enthusiasts with quality animals and supplies. We've hooked over 100 happy customers since 2021.");
			break;
		default: 
			System.out.println("That's not an option. Go fish!");
			
		}
		
	}
}