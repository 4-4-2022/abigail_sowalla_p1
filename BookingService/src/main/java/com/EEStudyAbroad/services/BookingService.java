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
		bookingData.booking.add(new Booking(bookingData.booking.size()+1, booking.getStudentName(), booking.getTripID(), booking.getDate(), booking.getDueDate()));
		return booking;
	}

	public Booking deleteBooking(long id) {
		List<Booking> bookings = bookingData.booking;
		for(Booking booking : bookings) {
			if(booking.getId() == id) {
				bookingData.booking.remove(booking);
				return booking;
			}
		}
		return null;
	}

	public List<Booking> getAllBookings() {
		List<Booking> bookings = bookingData.booking;
		return bookings;
	}

	public Booking updateDueDate(long id, long dueDate) {
		List<Booking> bookings = bookingData.booking;
		for(Booking booking : bookings) {
			if(booking.getId() == id) {
				booking.setDueDate(dueDate);
				return booking;
			}
		}
		return null;
	}
	
	
	
}
