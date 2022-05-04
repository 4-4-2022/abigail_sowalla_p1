package com.EEStudyAbroad.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.EEStudyAbroad.entities.SpringTrip;
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
		List<SpringTrip> springTrips = dummyData.springTrip;
		for(SpringTrip springTrip : springTrips) {
			if(springTrip.getId() == id) {
				return convertToTrip(springTrip);
			}
		}
		return null;
	}

	private Trip convertToTrip(SpringTrip springTrip) {
		return new Trip(springTrip.getId(), springTrip.getName(), springTrip.getCountry());
	}
	
}
