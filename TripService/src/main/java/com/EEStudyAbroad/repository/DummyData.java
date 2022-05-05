package com.EEStudyAbroad.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.EEStudyAbroad.models.Trip;

@Component
public class DummyData {

	public List<Trip> trip;
	
	public DummyData() {
		trip=new ArrayList<>();
		trip.add(new Trip(1, "Rome Romp", "Italy"));
		trip.add(new Trip(2, "Buenos Aires Adventure", "Argentina"));
	}
	
}
