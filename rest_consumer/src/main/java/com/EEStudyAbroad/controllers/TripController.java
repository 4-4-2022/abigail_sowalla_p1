package com.EEStudyAbroad.controllers;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.EEStudyAbroad.models.Trip;

@RestController
public class TripController {
	
	@Autowired
	private RestTemplate restTemplate;
	
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
}
