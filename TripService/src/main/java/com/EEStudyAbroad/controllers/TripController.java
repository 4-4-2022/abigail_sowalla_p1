package com.EEStudyAbroad.controllers;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.EEStudyAbroad.models.Trip;
import com.EEStudyAbroad.services.TripService;

//Rest controller is like a controller, but specifically for Rest
@RestController
@RequestMapping("/trips")
public class TripController {
	
	
	@Autowired
	private TripService tripService;
	
	//GET Mapping links the url of our localhost to this method
	@GetMapping("/test")
	public String getTrip() {
		Trip trip = new Trip(1, "Rome Romp", "Explore the fascinating artwork this historic city has to offer.");
		return trip.getName();
	}
	
	//this mapping is looking for a path variable
	@GetMapping("/springTrip/{id}")
	public Trip getSpringTrip(@PathVariable long id) {
		Trip springTrip = tripService.getTrip(id);
		return springTrip;
	}
}
