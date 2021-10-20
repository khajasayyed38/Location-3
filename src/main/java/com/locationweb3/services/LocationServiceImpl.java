package com.locationweb3.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.locationweb3.entity.Location;
import com.locationweb3.repositories.Locationrepository;


@Service
public class LocationServiceImpl implements LocationsService {
	
	
	@Autowired
	private Locationrepository locationRepo;
	
	@Override
	public void saveLocation(Location location) {
		locationRepo.save(location);
	}

	@Override
	public List<Location> getLocation() {
		List<Location> location = locationRepo.findAll();
		return location;
	}

	@Override
	public void deleteRegistrationById(long id) {
		locationRepo.deleteById(id);
		
	}

	@Override
	public Location getRegistrationById(long id) {
		Location location = locationRepo.getById(id);
		return location;
		
	}

	@Override
	public void updateLocation(Location location) {
		locationRepo.save(location);
		
	}

}
