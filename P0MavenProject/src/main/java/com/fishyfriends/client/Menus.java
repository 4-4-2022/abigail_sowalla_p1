package com.fishyfriends.client;

public interface Menus {
	
	//main menu (logged out)
	public static void printMainMenuOut() {
		System.out.println(
				"\n1) Log in"
				+ "\n2) Create an account"
				+ "\n3) Browse our catalog"
				+ "\n4) About Fishy Friends"
				+ "\n5) Exit Fishy Friends"
				+ "\n\nType a number to continue.");
	}
	
	//main menu (logged in, Primary Customer)
	public static void printMainMenuInPC() {
		System.out.println("\n1) Log out"
				+ "\n2) Browse our catalog"
				+ "\n3) About Fishy Friends"
				+ "\n4) Manage Funds"
				+ "\n5) Manage Users"
				+ "\n6) Account Info"
				+ "\n7) Exit Fishy Friends"
				+ "\n\nType a number to continue.");
	}
	
	//main menu (logged in, Secondary Customer)
	public static void printMainMenuInSC() {
		System.out.println("\n1) Log out"
				+ "\n2) Browse our catalog"
				+ "\n3) About Fishy Friends"
				+ "\n4) Manage Funds"
				+ "\n5) Exit Fishy Friends"
				+ "\n\nType a number to continue.");
	}
		
	//main menu (logged in, Admin)
	public static void printMainMenuInA() {
		System.out.println("\n1) Log out"
				+ "\n2) View & Edit Catalog"
				+ "\n3) View & Edit Accounts"
				+ "\n4) View & Edit Users"
				+ "\n5) Exit Fishy Friends"
				+ "\n\nType a number to continue.");
	}
	
	//main menu (logged in, Employee)
		public static void printMainMenuInE() {
			System.out.println("\n1) Log out"
					+ "\n2) View & Edit Catalog"
					+ "\n3) View & Edit Accounts"
					+ "\n4) Exit Fishy Friends"
					+ "\n\nType a number to continue.");
		}
}