package com.EEStudyAbroad.soap.service;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

import org.springframework.stereotype.Component;

import com.EEStudyAbroad.models.Payment;

@WebService(serviceName="order-service", targetNamespace = "http://service.EEStudyAbroad.com/")
@Component
public interface PaymentService {

	@WebMethod
	public List<Payment> findAll();
	
}
