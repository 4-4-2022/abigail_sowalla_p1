package com.fishyfriends.Model;

public class Animal{
	
	//the animal's ID for database connection
	public int id;
	// the species of the animal
	public String species; 
	// the price of the animal
	public float price;
	// how difficult it is to keep this animal as a pet
	public String difficulty;  
	// can this animal be kept with other animals?
	public boolean social;
	// fresh water or salt water
	public String waterType;
	
	public Animal(String species, float price, String difficulty, boolean social, String waterType) {
		
		super();
		
		this.species = species;
		this.price = price;
		this.difficulty = difficulty;
		this.social = social;
		this.waterType = waterType;
	}
	
	public Animal(int id, String species, float price, String difficulty, boolean social, String waterType) {
		
		super();
		
		this.id = id;
		this.species = species;
		this.price = price;
		this.difficulty = difficulty;
		this.social = social;
		this.waterType = waterType;
	}
	
	
	//set how Animals will be printed
	@Override
	public String toString() {
		return "ID#: " + id + ") " + species + ". Price: " + price + ". Difficulty of Care: " + difficulty + ". Social: " + social + ". Water Type: " + waterType + ".";
	}

}
