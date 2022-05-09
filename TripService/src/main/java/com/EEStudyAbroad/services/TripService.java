package com.EEStudyAbroad.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.EEStudyAbroad.models.Trip;
import com.EEStudyAbroad.repository.TripData;

@Service
public class TripService {
	
	private TripData tripData;
	
	@Autowired
	public TripService(TripData tripData) {
		this.tripData = tripData;
	}
	
	public Trip getTrip(long id) {
		List<Trip> trips = tripData.trip;
		for(Trip trip : trips) {
			if(trip.getId() == id) {
				return trip;
			}
		}
		return null;
	}

	public Trip createTrip(Trip trip) {
		tripData.trip.add(new Trip(tripData.trip.size()+1, trip.getName(), trip.getSemester(), trip.getCost(), trip.getDescription()));
		
		return trip;
	}

	public Trip deleteTrip(long id) {
		List<Trip> trips = tripData.trip;
		for(Trip trip : trips) {
			if(trip.getId() == id) {
				tripData.trip.remove(trip);
				return trip;
			}
		}
		return null;
	}

	public List<Trip> getAllTrips() {
		List<Trip> trips = tripData.trip;
		return trips;
	}

	public Trip updateTripDescription(long id, String desc) {
		List<Trip> trips = tripData.trip;
		for(Trip trip : trips) {
			if(trip.getId() == id) {
				trip.setDescription(desc);
				return trip;
			}
		}
		return null;
	}

	public Trip updateTripCost(long id, double cost) {
		List<Trip> trips = tripData.trip;
		for(Trip trip : trips) {
			if(trip.getId() == id) {
				trip.setCost(cost);
				return trip;
			}
		}
		return null;
	}
	
	//example of a method to convert one object type to another
	/*
	private Trip convertToTrip(SpringTrip springTrip) {
		return new Trip(springTrip.getId(), springTrip.getName(), springTrip.getCountry());
	}
	*/
}
