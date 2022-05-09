
package com.EEStudyAbroad.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.EEStudyAbroad.models.Payment;
import com.EEStudyAbroad.soap.service.PaymentService;

@RestController("messageController")
@RequestMapping("/payments")
public class MessageController {

	@Autowired
	private PaymentService paymentService;
	
	@GetMapping("/all")
	public Object getSoapMessage() {
		return this.paymentService.findAll();
	}
	
	@PostMapping("/new")
	public String newPayment(Payment payment) {
		this.paymentService.newPayment(payment);
		return "The new payment for booking ID#"+payment.getBookingId()+" has been made.";
	}
	
}
