package com.EEStudyAbroad;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import com.EEStudyAbroad.models.Trip;
import com.EEStudyAbroad.repository.TripData;
import com.EEStudyAbroad.services.TripService;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
@TestInstance(Lifecycle.PER_CLASS)
class TripServiceApplicationTests {

	@InjectMocks
	private TripService tripService;
	
	@Mock
	private TripData mockTripData;
	private ArrayList<Trip> mockTrips;
	
	@BeforeAll
	public void setup() {
		MockitoAnnotations.openMocks(this);

		this.tripService = new TripService(mockTripData);
		
		this.mockTrips = new ArrayList<>();
		
		this.mockTrips.add(new Trip(1, "Germany", "Spring", 3000.99, "Go to Germany!"));
		this.mockTrips.add(new Trip(2, "China", "Summer", 4000.99, "Go to China!"));
		this.mockTrips.add(new Trip(3, "Brazil", "Fall", 5000.99, "Go to Brazil!"));
		
		List<Trip> trips = mockTripData.trip;
	}
	
	
	@Test
	void contextLoads() {
	}
	
	@Test
	void testGetTrip() {
		Mockito.when(tripService.getTrip(1)).thenReturn(mockTrips.get(0));
		
		//TripData tripData = mockTripData;
		Trip testTrip = tripService.getTrip(1);
		Assertions.assertEquals("Germany", testTrip.getName());
		
	}
	
	

}
