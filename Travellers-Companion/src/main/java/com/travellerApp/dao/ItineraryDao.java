package com.travellerApp.dao;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.travellerApp.entities.Itinerary;
import com.travellerApp.entities.User;

@Repository
public interface ItineraryDao extends PagingAndSortingRepository<Itinerary, Integer>{
	
	@Query("select itinerary from Itinerary itinerary where itinerary.user.userId=?1 ")
	public List<Itinerary> fetchItineraries(int userId);

}
