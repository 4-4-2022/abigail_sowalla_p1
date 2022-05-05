package com.EEStudyAbroad.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.EEStudyAbroad.models.Booking;
import com.EEStudyAbroad.services.BookingService;

@RestController
@RequestMapping("/bookings")
public class BookingController {

	@Autowired
	private BookingService bookingService;
	
	//mapping to find a booking by its ID
	@CrossOrigin(origins = "http://localhost:8000")
	@GetMapping("/id/{id}")
	public Booking getBooking(@PathVariable long id) {
		Booking booking = bookingService.getBooking(id);
		return booking;
	}
	
	//mapping to create a new booking
	@CrossOrigin(origins = "http://localhost:8000")
	@PostMapping("/new")
	public String createBooking(@RequestBody Booking booking) {
		Booking newBooking = bookingService.createBooking(booking);
		return newBooking.getStudentName()+" has booked a spot on trip ID# "+newBooking.getTripID();
	}
	
}
