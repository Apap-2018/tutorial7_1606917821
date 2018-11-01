package com.apap.tutorial7.service;

import java.util.List;

import com.apap.tutorial7.model.FlightModel;

public interface FlightService {
	FlightModel addFlight(FlightModel flight);
	void deleteFlight(FlightModel flight);
	void updateFlight (long id, FlightModel flight);
	FlightModel findFlightByFlightNumber (String flightNumber);
	FlightModel getFlight (long id);
	List<FlightModel> allFlight();
}