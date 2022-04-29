package com.EEStudyAbroad.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.EEStudyAbroad.model.Booking;

@Repository("orderRepository")
public interface BookingRepository extends JpaRepository<Booking, Integer>{

	List<Booking> findAll();
	<S extends Booking> S save(S entity);
	
}
