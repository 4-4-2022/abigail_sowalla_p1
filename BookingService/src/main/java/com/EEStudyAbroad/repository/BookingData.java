package com.EEStudyAbroad.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.EEStudyAbroad.models.Booking;

@Component
public class BookingData {

	public List<Booking> booking;
	
	public BookingData() {
		booking=new ArrayList<>();
		booking.add(new Booking(1, "Bob Ross", 1, 05042022));
		booking.add(new Booking(2, "James Bond", 2, 05042022));
		booking.add(new Booking(3, "Indiana Jones", 2, 05042022));
	}
	
}
