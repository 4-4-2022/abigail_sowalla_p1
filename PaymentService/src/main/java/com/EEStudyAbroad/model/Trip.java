package com.EEStudyAbroad.model;

public class Trip {
	
	//ID # for the trip, primary key to match with TripSemester
	private int id;
	
	//Trip name
	private String name;
	
	//price for trip
	private float price;
	
	//semesters available
	private boolean isSpring;
	private boolean isSummer;
	private boolean isFall;
	
	//constructor
	public Trip(int id, String name, float price, boolean isSpring, boolean isSummer, boolean isFall) {
		this.setId(id);
		this.setName(name);
		this.setPrice(price);
		this.setSpring(isSpring);
		this.setSummer(isSummer);
		this.setFall(isFall);
	}
	
	//set toString
	public String toString() {
		return name+"\n     "+"ID# "+id+"\n     "+"Price: "+price+"\n     "+"Semester Options: "+"\n          Spring: "+isSpring+"\n          Summer: "+isSummer+"\n          Fall: "+isFall;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public boolean isSpring() {
		return isSpring;
	}

	public void setSpring(boolean isSpring) {
		this.isSpring = isSpring;
	}

	public boolean isSummer() {
		return isSummer;
	}

	public void setSummer(boolean isSummer) {
		this.isSummer = isSummer;
	}

	public boolean isFall() {
		return isFall;
	}

	public void setFall(boolean isFall) {
		this.isFall = isFall;
	}

}
