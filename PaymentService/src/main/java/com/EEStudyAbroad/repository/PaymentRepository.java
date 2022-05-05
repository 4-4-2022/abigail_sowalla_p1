package com.EEStudyAbroad.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.EEStudyAbroad.model.Payment;

@Repository("paymentRepository")
public interface PaymentRepository extends JpaRepository<Payment, Integer>{

	<S extends Payment> S save(S entity);
	
}
