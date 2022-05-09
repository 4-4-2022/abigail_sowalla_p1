package com.EEStudyAbroad.models;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

public class Booking {

	private long id;
	private String studentName;
	private long tripID;
	private long date;
	private long dueDate;
	
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
	public long getDueDate() {
		return dueDate;
	}
	public void setDueDate(long dueDate) {
		this.dueDate = dueDate;
	}
	public Booking(long id, String studentName, long tripID, long date, long dueDate) {
		super();
		this.id = id;
		this.studentName = studentName;
		this.tripID = tripID;
		this.date = date;
		this.dueDate = dueDate;
	}
	@Override
	public String toString() {
		return "Booking [id=" + id + ", studentName=" + studentName + ", tripID=" + tripID + ", date=" + date
				+ ", Payment due on " + dueDate + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(date, dueDate, id, studentName, tripID);
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
		return date == other.date && dueDate == other.dueDate && id == other.id
				&& Objects.equals(studentName, other.studentName) && tripID == other.tripID;
	}
	
}
