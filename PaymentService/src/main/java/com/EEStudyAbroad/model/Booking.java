package com.EEStudyAbroad.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity

//This class represents the data from when a user books a trip.
@Table
public class Booking {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "order_id_seq")
	@SequenceGenerator(allocationSize = 1, name = "order_id_seq")
	private int id;
	
	@Column(name="user_id")
	private int user_id;
	
	@Column(name="is_paid")
	private boolean is_paid;
	
	@Column(name="trip_id")
	private int trip_id;
	
	public Booking() {
		super();
	}
	
	public Booking(int id, int user_id, boolean is_paid, int trip_id) {
		super();
		this.id=id;
		this.user_id=user_id;
		this.is_paid=is_paid;
		this.trip_id=trip_id;
	}

	//note: alt-shift-s gets you to the add getters & setters & whatever else menu
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public boolean isIs_paid() {
		return is_paid;
	}

	public void setIs_paid(boolean is_paid) {
		this.is_paid = is_paid;
	}

	public int getTrip_id() {
		return trip_id;
	}

	public void setTrip_id(int trip_id) {
		this.trip_id = trip_id;
	}

	@Override
	public String toString() {
		return "Booking [id=" + id + ", user_id=" + user_id + ", is_paid=" + is_paid + ", trip_id=" + trip_id + "]";
	}
	
	
}
