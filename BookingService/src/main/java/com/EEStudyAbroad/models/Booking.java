package com.EEStudyAbroad.models;

import java.util.Objects;

public class Booking {

	private long id;
	private String studentName;
	private long tripID;
	private long date;
	
	//constructor with all fields
	public Booking(long id, String studentName, long tripID, long date) {
		super();
		this.id = id;
		this.studentName = studentName;
		this.tripID = tripID;
		this.date = date;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public long getTripID() {
		return tripID;
	}

	public void setTripID(long tripID) {
		this.tripID = tripID;
	}

	public long getDate() {
		return date;
	}

	public void setDate(long date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "Booking [id=" + id + ", studentName=" + studentName + ", tripID=" + tripID + ", date=" + date + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(date, id, studentName, tripID);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Booking other = (Booking) obj;
		return date == other.date && id == other.id && Objects.equals(studentName, other.studentName)
				&& tripID == other.tripID;
	}
	
	
	
}
