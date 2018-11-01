package com.apap.tutorial7.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.apap.tutorial7.model.FlightModel;
import com.apap.tutorial7.repository.FlightDb;

@Service
@Transactional
public class FlightServiceImpl implements FlightService{
	@Autowired
	private FlightDb flightDb;

	@Override
	public FlightModel addFlight(FlightModel flight) {
		flightDb.save(flight);
		return flight;
	}

	@Override
	public void deleteFlight(FlightModel flight) {
		flightDb.deleteById(flight.getId());
	}

	@Override
	public void updateFlight(long id, FlightModel flight) {
		FlightModel newFlight = flightDb.findFlightById(id);
		newFlight.setDestination(flight.getDestination());
		newFlight.setOrigin(flight.getOrigin());
		newFlight.setFlightNumber(flight.getFlightNumber());
		newFlight.setTime(flight.getTime());
		
	}

	@Override
	public FlightModel findFlightByFlightNumber(String flightNumber) {
		return flightDb.findFlightByFlightNumber(flightNumber);
	}

	@Override
	public FlightModel getFlight(long id) {
		return flightDb.findFlightById(id);
	}

	@Override
	public List<FlightModel> allFlight() {
		return flightDb.findAll();
	}
}