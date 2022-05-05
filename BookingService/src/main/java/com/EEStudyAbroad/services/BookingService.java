package com.EEStudyAbroad.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.EEStudyAbroad.models.Booking;
import com.EEStudyAbroad.repository.BookingData;

@Service
public class BookingService {

	private BookingData bookingData;
	
	@Autowired
	public BookingService(BookingData bookingData) {
		this.bookingData=bookingData;
	}

	public Booking getBooking(long id) {
		List<Booking> bookings = bookingData.booking;
		for(Booking booking : bookings) {
			if(booking.getId() == id) {
				return booking;
			}
		}
		return null;
	}

	public Booking createBooking(Booking booking) {
		// TODO Auto-generated method stub
		bookingData.booking.add(new Booking(bookingData.booking.size()+1, booking.getStudentName(), booking.getTripID(), booking.getDate()));
		return booking;
	}
	
	
	
}
