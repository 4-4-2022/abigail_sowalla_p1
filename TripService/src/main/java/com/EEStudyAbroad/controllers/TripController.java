package com.EEStudyAbroad.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	
	//mapping to find all trips
	@CrossOrigin(origins = "http://localhost:8000")
	@GetMapping("/all")
	public List<Trip> getAllTrips() {
		List<Trip> trips = tripService.getAllTrips();
		return trips;
	}
	
	//mapping to find a trip by ID
	@CrossOrigin(origins = "http://localhost:8000")
	@GetMapping("/id/{id}")
	public Trip getTrip(@PathVariable long id) {
		Trip trip = tripService.getTrip(id);
		return trip;
	}
	
	//mapping to create a new trip
	@CrossOrigin(origins = "http://localhost:8000")
	@PostMapping("/new")
	public String createTrip(@RequestBody Trip trip) {
		Trip newTrip = tripService.createTrip(trip);
		return newTrip.getName() + " was added to the catalogue.";
	}
	
	//mapping to delete a trip
	@CrossOrigin(origins = "http://localhost:8000")
	@DeleteMapping("/delete/{id}")
	public String deleteTrip(@PathVariable long id) {
		Trip newTrip = tripService.deleteTrip(id);
		return newTrip.getName() +" was deleted from the catalogue.";
	}
	
	//mapping to update a trip's description
	@CrossOrigin(origins = "http://localhost:8000")
	@PutMapping("/describe/{id}")
	public String updateTripDescription(@PathVariable long id, @RequestBody String description) {
		Trip newTrip = tripService.updateTripDescription(id, description);
		return "The description of "+newTrip.getName() +" has been updated to: "+newTrip.getDescription();
	}
	
	//mapping to update a trip's cost
	@CrossOrigin(origins = "http://localhost:8000")
	@PutMapping("/newcost/{id}")
	public String updateTripDescription(@PathVariable long id, @RequestBody double cost) {
		Trip newTrip = tripService.updateTripCost(id, cost);
		return "The cost of "+newTrip.getName() +" has been updated to "+newTrip.getCost();
	}
	
}
