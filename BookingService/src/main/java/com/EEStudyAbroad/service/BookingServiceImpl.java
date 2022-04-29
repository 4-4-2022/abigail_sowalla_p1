package com.EEStudyAbroad.service;

import java.util.List;
import java.util.Map;

import javax.jws.WebMethod;
import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;

import com.EEStudyAbroad.model.Booking;
import com.EEStudyAbroad.repository.BookingRepository;

@WebService(endpointInterface="com.EEStudyAbroad.service.BookingService", name="booking")
public class BookingServiceImpl implements BookingService{

	private BookingRepository bookingRepository;
	
	@Autowired
	public void setBookingRepository(BookingRepository bookingrepository) {
		this.bookingRepository=bookingRepository;
	}
	
	@Override
	@WebMethod
	public List<Booking> findAll(){
		return this.bookingRepository.findAll();
	}
	
	@WebMethod
	public void save(Booking booking) {
		this.bookingRepository.save(booking);
	}
	
	@WebMethod
	public void receiveMessage(String message) {
		System.out.println(message);
	}

	@Override
	public void save(Booking booking, Map<String, Integer> items) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void contactCupcakeService(String message) {
		// TODO Auto-generated method stub
		
	}
	
}
