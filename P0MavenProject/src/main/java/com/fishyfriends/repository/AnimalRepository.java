package com.fishyfriends.repository;

import com.fishyfriends.Model.Animal;

public class AnimalRepository {
	
	//create an array
	public Animal[] animals = new Animal[10];
	
	
	
	//a constructor which adds objects to the array
	public AnimalRepository() {
		super();
		
		this.animals[0] = new Animal("Beta Fish", 3.49f, "easy", false, "freshwater");
		this.animals[1] = new Animal("Rabbit Snail", 8.99f, "easy", true, "freshwater");
		this.animals[2] = new Animal("Goldfish", 1.49f, "moderate", true, "freshwater");
		this.animals[3] = new Animal("Cherry Shrimp", 2.99f, "moderate", true, "freshwater");
		this.animals[4] = new Animal("Congo Pufferfish", 249.99f, "hard", false, "freshwater");
		this.animals[5] = new Animal("Goby", 44.99f, "easy", true, "saltwater");
		this.animals[6] = new Animal("Hawkfish", 34.49f, "easy", false, "saltwater");
		this.animals[7] = new Animal("Blenny", 29.99f, "moderate", true, "saltwater");
		this.animals[8] = new Animal("Pipefish", 49.99f, "hard", true, "saltwater");
		this.animals[9] = new Animal("Garden Eel", 39.99f, "hard", true, "saltwater");
	}
	
	//a method which returns the array
	public Animal[] listAllAnimals() {
		return this.animals;
	}
}