package com.EEStudyAbroad.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.EEStudyAbroad.models.Trip;
import com.EEStudyAbroad.repository.DummyData;

@Service
public class TripService {
	
	private DummyData dummyData;
	
	@Autowired
	public TripService(DummyData dummyData) {
		this.dummyData = dummyData;
	}
	
	public Trip getTrip(long id) {
		List<Trip> trips = dummyData.trip;
		for(Trip trip : trips) {
			if(trip.getId() == id) {
				return trip;
			}
		}
		return null;
	}

	public Trip createTrip(Trip trip) {
		// TODO Auto-generated method stub
		dummyData.trip.add(new Trip(dummyData.trip.size()+1, trip.getName(), trip.getDescription()));
		
		return trip;
	}
	
	//example of a method to convert one object type to another
	/*
	private Trip convertToTrip(SpringTrip springTrip) {
		return new Trip(springTrip.getId(), springTrip.getName(), springTrip.getCountry());
	}
	*/
}
