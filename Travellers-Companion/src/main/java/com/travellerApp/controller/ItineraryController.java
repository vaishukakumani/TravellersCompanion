package com.travellerApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.travellerApp.entities.Itinerary;
import com.travellerApp.service.ItineraryService;

@org.springframework.web.bind.annotation.RestController
@RequestMapping(value="api/Itinerary")
public class ItineraryController {

	@Autowired
	private ItineraryService itineraryService;
	
	@RequestMapping(method=RequestMethod.PUT,produces="application/json",consumes="application/json" )
	@ResponseBody
	public Itinerary updateItinerary(@RequestBody Itinerary iti){
		return itineraryService.updateItinerary(iti);		
		
		
	}
	
	@RequestMapping(value="/health", method=RequestMethod.GET )
	public String health(){
		return "hello";
	}
	
	
}
