package com.locationweb3.services;



import java.util.List;

import com.locationweb3.entity.Location;



public interface LocationsService {
	public  void saveLocation(Location location);
	public List<Location> getLocation();
	public void deleteRegistrationById(long id);
	public Location getRegistrationById(long id);
	public void updateLocation(Location location);
}
