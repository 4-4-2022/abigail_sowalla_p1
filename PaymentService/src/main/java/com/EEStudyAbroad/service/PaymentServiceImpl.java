package com.EEStudyAbroad.service;

import java.util.List;
import java.util.Map;

import javax.jws.WebMethod;
import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;

import com.EEStudyAbroad.model.Payment;
import com.EEStudyAbroad.repository.PaymentRepository;

@WebService(endpointInterface="com.EEStudyAbroad.service.PaymentService", name="payment")
public class PaymentServiceImpl implements PaymentService{

	private PaymentRepository paymentRepository;
	
	@Autowired
	public void setPaymentRepository(PaymentRepository paymentRepository) {
		this.paymentRepository=paymentRepository;
	}
	
	@Override
	@WebMethod
	public List<Payment> findAll(){
		return this.paymentRepository.findAll();
	}
	
	@WebMethod
	public void save(Payment payment) {
		this.paymentRepository.save(payment);
	}
	
	@WebMethod
	public void receiveMessage(String message) {
		System.out.println(message);
	}

	@Override
	public void save(Payment payment, Map<String, Integer> items) {
		// TODO Auto-generated method stub
		
	}

	/*
	@Override
	public void contactCupcakeService(String message) {
		// TODO Auto-generated method stub
		
	}
	*/
}
