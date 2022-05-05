package com.EEStudyAbroad.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.EEStudyAbroad.soap.service.PaymentService;

@RestController("messageController")
@RequestMapping("/message")
public class MessageController {

	@Autowired
	private PaymentService paymentService;
	
	@GetMapping("/soap-message")
	public Object getSoapMessage() {
		return this.paymentService.findAll();
	}
	
}
