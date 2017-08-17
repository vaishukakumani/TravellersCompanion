package com.travellerApp.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.lang.Integer;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.travellerApp.dao.ItineraryDao;
import com.travellerApp.dao.UserDao1;
import com.travellerApp.entities.Itinerary;
import com.travellerApp.entities.User;

@Component("itineraryService")
@Transactional
public class ItinerarySrvcImpl implements ItineraryService {
	@Autowired
	 private UserDao1 userDao;
	
	@Autowired
	private ItineraryDao itineraryDao;
	
		
	public Itinerary createItinerary(Itinerary i){
		User user=userDao.findOne(i.getUser().getUserId());
		i.setUser(user);
		return itineraryDao.save(i);
	}
	public List<Itinerary> fetchItineraries(int userId){
		
			 
		List<Itinerary> itis = itineraryDao.fetchItineraries(userId);
		return itis;
		
	}
	
	public Itinerary updateItinerary(Itinerary i){
		User user= userDao.findOne(i.getUser().getUserId());
		i.setUser(user);
		return itineraryDao.save(i);
	}
}
