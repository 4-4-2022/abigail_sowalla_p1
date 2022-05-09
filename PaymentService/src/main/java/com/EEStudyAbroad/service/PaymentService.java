package com.EEStudyAbroad.service;

import java.util.List;
import java.util.Map;

import javax.jws.WebService;

import com.EEStudyAbroad.model.Payment;

@WebService
public interface PaymentService {
	
	List<Payment> findAll();
	void save(Payment payment, Map<String, Integer> items);
	void delete(Payment payment);

}
