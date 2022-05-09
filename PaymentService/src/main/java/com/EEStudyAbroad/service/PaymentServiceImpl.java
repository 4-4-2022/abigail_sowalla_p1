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
	
	//the method to save a single payment
	@WebMethod
	public void save(Payment payment) {
		this.paymentRepository.save(payment);
	}
	
	@Override
	public void save(Payment payment, Map<String, Integer> items) {
	}
	
	//the method to find all payments
	@Override
	@WebMethod
	public List<Payment> findAll(){
		return this.paymentRepository.findAll();
	}
	
	//the method to delete a payment record
	@Override
	@WebMethod
	public void delete(Payment payment){
		this.paymentRepository.delete(payment);
	}
	
	
	@WebMethod
	public void receiveMessage(String message) {
		System.out.println(message);
	}

}
