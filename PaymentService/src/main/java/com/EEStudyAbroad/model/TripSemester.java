package com.EEStudyAbroad.model;

public class TripSemester {
	
	//ID# associated with Trip
	private int id;
	
	//Semester of trip
	private String semester;
	
	//total spots for the trip
	private int spotTotal;
	
	//remaining spots for the trip
	private int spotRemaining;
	
	//constructor
	public TripSemester(int id, String semester, int spotTotal, int spotRemaining) {
		this.setId(id);
		this.setSemester(semester);
		this.setSpotTotal(spotTotal);
		this.setSpotRemaining(spotRemaining);
	}
	
	//set toString
	public String toString() {
		return spotRemaining+" out of "+spotTotal+"spots are open. ";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getSpotTotal() {
		return spotTotal;
	}

	public void setSpotTotal(int spotTotal) {
		this.spotTotal = spotTotal;
	}

	public int getSpotRemaining() {
		return spotRemaining;
	}

	public void setSpotRemaining(int spotRemaining) {
		this.spotRemaining = spotRemaining;
	}

	public String getSemester() {
		return semester;
	}

	public void setSemester(String semester) {
		this.semester = semester;
	}
}
