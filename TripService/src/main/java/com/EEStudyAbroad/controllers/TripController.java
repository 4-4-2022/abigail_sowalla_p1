package com.EEStudyAbroad.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.EEStudyAbroad.models.Trip;
import com.EEStudyAbroad.services.TripService;

//Rest controller is like a controller, but specifically for Rest
@RestController
@RequestMapping("/trips")
public class TripController {
	
	
	@Autowired
	private TripService tripService;
	
	//mapping to find a springTrip by ID
	@CrossOrigin(origins = "http://localhost:8000")
	@GetMapping("/id/{id}")
	public Trip getTrip(@PathVariable long id) {
		Trip trip = tripService.getTrip(id);
		return trip;
	}
	
	//mapping to create a new booking
	@CrossOrigin(origins = "http://localhost:8000")
	@PostMapping("/new")
	public String createTrip(@RequestBody Trip trip) {
		Trip newTrip = tripService.createTrip(trip);
		return newTrip.getName() + " was added to the catalogue.";
	}
	
	
}
