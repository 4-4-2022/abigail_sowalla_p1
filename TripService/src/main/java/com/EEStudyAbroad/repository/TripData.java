package com.EEStudyAbroad.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.EEStudyAbroad.models.Trip;

@Component
public class TripData {

	public List<Trip> trip;
	
	public TripData() {
		trip=new ArrayList<>();
		trip.add(new Trip(1, "Rome Romp", "Spring", 9999.89, "Italy"));
		trip.add(new Trip(2, "Buenos Aires Adventure", "Summer", 2099.99, "Argentina"));
	}
	
}
