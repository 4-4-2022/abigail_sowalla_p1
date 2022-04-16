package com.fishyfriends.client;

//imports

import com.fishyfriends.Model.Animal;

// set up public class, then write methods

public class AppUI {
	
	//welcome menu (logged out)
	public static void printMainMenu() {
	
		System.out.println("Welcome to Fishy Friends Aquarium Shop!\nWhat would you like to do?"
				+ "\n\n1) Log in"
				+ "\n2) Create an account"
				+ "\n3) Browse our catalog"
				+ "\n4) About Fishy Friends"
				+ "\n\nType a number to continue.");
	
	}
	
	public static void printCatalog(Animal[] animals) {
		for(int i=0; i<animals.length; i++ ) {
			System.out.println(animals[i]);
		}
	}

}