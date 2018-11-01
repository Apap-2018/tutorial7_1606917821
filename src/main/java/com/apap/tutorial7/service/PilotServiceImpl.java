package com.apap.tutorial7.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.apap.tutorial7.model.PilotModel;
import com.apap.tutorial7.repository.PilotDb;

@Service
@Transactional
public class PilotServiceImpl implements PilotService {
	@Autowired
	private PilotDb pilotDb;

	@Override
	public PilotModel getPilotDetailByLicenseNumber(String licenseNumber) {
		return pilotDb.findByLicenseNumber(licenseNumber);
	}

	@Override
	public PilotModel addPilot(PilotModel pilot) {
		pilotDb.save(pilot);
		return pilot;
		
	}

	@Override
	public void deletePilot(PilotModel pilot) {
		pilotDb.deleteById(pilot.getId());
		
	}

	@Override
	public void updatePilot(long pilotId, PilotModel pilot) {
		PilotModel newPilot = pilotDb.findPilotById(pilotId);
		newPilot.setName(pilot.getName());
		newPilot.setFlyHour(pilot.getFlyHour());
		pilotDb.save(newPilot);
	}

	@Override
	public PilotModel getPilotDetailById(Long id) {
		// TODO Auto-generated method stub
		return pilotDb.findPilotById(id);
	}

}