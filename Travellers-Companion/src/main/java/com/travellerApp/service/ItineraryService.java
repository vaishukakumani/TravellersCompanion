package com.travellerApp.service;

import java.util.Date;
import java.util.List;

import com.travellerApp.entities.Itinerary;

public interface ItineraryService {
	public Itinerary createItinerary(Itinerary i);
	public List<Itinerary> fetchItineraries(int userId);
	public Itinerary updateItinerary(Itinerary i);
}
