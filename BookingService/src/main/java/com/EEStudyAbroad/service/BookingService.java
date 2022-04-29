package com.EEStudyAbroad.service;

import java.util.List;
import java.util.Map;

import javax.jws.WebService;

import com.EEStudyAbroad.model.Booking;

@WebService
public interface BookingService {
	
	List<Booking> findAll();
	void save(Booking booking, Map<String, Integer> items);
	void contactCupcakeService(String message);

}
