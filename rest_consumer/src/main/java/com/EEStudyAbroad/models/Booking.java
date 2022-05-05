package com.EEStudyAbroad.models;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Booking {

	private long id;
	private String studentName;
	private long tripId;
	
	public Booking(long id, String studentName, long tripId) {
		super();
		this.id = id;
		this.studentName = studentName;
		this.tripId = tripId;
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

	public long getTripId() {
		return tripId;
	}

	public void setTripId(long tripId) {
		this.tripId = tripId;
	}

	@Override
	public String toString() {
		return "Booking [id=" + id + ", studentName=" + studentName + ", tripId=" + tripId + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, studentName, tripId);
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
		return id == other.id && Objects.equals(studentName, other.studentName) && tripId == other.tripId;
	}
	
	
	
}
