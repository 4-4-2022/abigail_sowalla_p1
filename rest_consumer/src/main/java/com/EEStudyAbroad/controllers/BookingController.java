package com.EEStudyAbroad.controllers;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.EEStudyAbroad.models.Booking;

@RestController
public class BookingController {

	@Autowired
	private RestTemplate restTemplate;
	
	@GetMapping("/bookings")
	public Booking getBooking(@PathParam(value="id") long id) {
		ResponseEntity<Booking> booking = restTemplate.getForEntity("http://localhost:8002/bookings/id/"+id, Booking.class);
		return booking.getBody();
	}
	
	@PostMapping("bookings/new")
	public String createBooking(@RequestBody Booking booking) {
		ResponseEntity<String> response = restTemplate.postForEntity("http://localhost:8002/bookings/new", booking, String.class);
		return response.getBody();
	}
}
