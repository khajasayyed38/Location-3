package com.locationweb3.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.locationweb3.dto.GetLocationData;
import com.locationweb3.entity.Location;
import com.locationweb3.services.LocationsService;
import com.locationweb3.util.Email;

@Controller
public class LocationController {
	
	@Autowired
	private Email email;
	
	@Autowired
	private LocationsService locationService;
	
	@RequestMapping("/showlocation")
	public String showLocationPage() {
		return "saveLocation";
	}
	
	@RequestMapping("/saveLocation")
	public String getLocationData(@ModelAttribute("location") Location location, ModelMap modelMap) {
		locationService.saveLocation(location);
		email.sendEmail("khajasayyed10@gmail.com", "LOcation saved", "Congratulations locations details is saved");
		modelMap.addAttribute("msg", "Location is saved!!!");
		return "saveLocation";
	}
	
	@RequestMapping("/getalllocations")
	public String getAllLocation(ModelMap modelMap) {
		List<Location> locations = locationService.getLocation();
		modelMap.addAttribute("locations", locations);
		
		return "displayLocations";
	}
	
	@RequestMapping("/deleteReg")
	public String deleteRegistration(@RequestParam("id") long id, ModelMap modelMap) {
		locationService.deleteRegistrationById(id);
		List<Location> locations = locationService.getLocation();
		modelMap.addAttribute("locations", locations);
		
		return "displayLocations";
	}
	
	@RequestMapping("/updateReg")
	public String updateRegistration(@RequestParam("id") long id, ModelMap modelMap) {
		Location location = locationService.getRegistrationById(id);
		modelMap.addAttribute("location", location);
		return "updateLocation";
	}
	
	@RequestMapping("/updateLocation")
	public String updateLocation(GetLocationData locationData, ModelMap modelMap) {
		Location location= new Location();
		location.setId(locationData.getId());
		location.setCode(locationData.getCode());
		location.setName(locationData.getName());
		location.setType(locationData.getType());
		locationService.updateLocation(location);
		List<Location> locations = locationService.getLocation();
		modelMap.addAttribute("locations", locations);
		
		return "displayLocations";
	}
	
}

