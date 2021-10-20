package com.locationweb3.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.locationweb3.entity.Location;
import com.locationweb3.repositories.Locationrepository;

@RestController
public class LoactionRestController {
	
	@Autowired
	private Locationrepository locationRepo;
	
	@RequestMapping("/location/{id}")
	public Location getLocation(@PathVariable("id") long id) {
		Optional<Location> findById = locationRepo.findById(id);
		Location location = findById.get();
		return location;
	}
}
