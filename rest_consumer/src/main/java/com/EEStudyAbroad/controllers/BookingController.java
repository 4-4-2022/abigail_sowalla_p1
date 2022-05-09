package com.EEStudyAbroad.controllers;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.EEStudyAbroad.models.Booking;
import com.EEStudyAbroad.models.Trip;

@RestController
public class BookingController {

	@Autowired
	private RestTemplate restTemplate;
	
	@GetMapping("/bookings/all")
	public Booking[] getAllBookings() {
		ResponseEntity<Booking[]> bookings = restTemplate.getForEntity("http://localhost:8002/bookings/all", Booking[].class);
		return bookings.getBody();
	}
	
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
	
	@DeleteMapping("/bookings/delete")
	public String deleteBooking(@PathParam(value="id") long id) {
		restTemplate.delete("http://localhost:8002/bookings/delete/"+id);
		return "Booking at ID#" +id+" has been deleted.";
	}
	
	@PutMapping("/bookings/newduedate")
	public String updateDueDate(@PathParam(value="id") long id, @RequestBody long dueDate) {
		restTemplate.put("http://localhost:8002/bookings/newduedate/"+id, dueDate);
		return "The due date for payment of booking ID#" +id+" has been updated.";
	}
}
