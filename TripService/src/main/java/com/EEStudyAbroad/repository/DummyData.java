package com.EEStudyAbroad.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.EEStudyAbroad.entities.SpringTrip;

@Component
public class DummyData {

	public List<SpringTrip> springTrip;
	
	public DummyData() {
		springTrip=new ArrayList<>();
		springTrip.add(new SpringTrip(1, "Rome Romp", "Italy"));
		springTrip.add(new SpringTrip(2, "Buenos Aires Adventure", "Argentina"));
	}
	
}
