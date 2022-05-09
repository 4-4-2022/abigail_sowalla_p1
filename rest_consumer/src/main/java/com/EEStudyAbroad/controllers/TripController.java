package com.EEStudyAbroad.controllers;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.EEStudyAbroad.models.Trip;

@RestController
public class TripController {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@GetMapping("/trips/all")
	public Trip[] getAllTrips() {
		ResponseEntity<Trip[]> trips = restTemplate.getForEntity("http://localhost:8001/trips/all", Trip[].class);
		return trips.getBody();
	}
	
	@GetMapping("/trips")
	public Trip getTrip(@PathParam(value = "id") long id) {
		ResponseEntity<Trip> trip = restTemplate.getForEntity("http://localhost:8001/trips/id/"+id, Trip.class);
		return trip.getBody();
	}
	
	@PostMapping("/trips/new")
	public String createTrip(@RequestBody Trip trip) {
		ResponseEntity<String> response = restTemplate.postForEntity("http://localhost:8001/trips/new", trip, String.class);
		return response.getBody();
	}
	
	@DeleteMapping("/trips/delete")
	public String deleteTrip(@PathParam(value="id") long id) {
		restTemplate.delete("http://localhost:8001/trips/delete/"+id);
		return "Trip at ID#" +id+" has been deleted.";
	}
	
	@PutMapping("/trips/describe")
	public String updateTripDescription(@PathParam(value="id") long id, @RequestBody String description) {
		restTemplate.put("http://localhost:8001/trips/describe/"+id, description);
		return "Description of trip at ID#" +id+" has been updated.";
	}
	
	@PutMapping("/trips/newcost")
	public String updateTripCost(@PathParam(value="id") long id, @RequestBody double cost) {
		restTemplate.put("http://localhost:8001/trips/newcost/"+id, cost);
		return "Cost of trip at ID#" +id+" has been updated.";
	}
	
}
