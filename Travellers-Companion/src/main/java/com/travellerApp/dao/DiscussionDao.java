package com.travellerApp.dao;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.travellerApp.entities.Discussion;
import com.travellerApp.entities.Itinerary;
@Repository
public interface DiscussionDao extends PagingAndSortingRepository<Discussion, Integer>{
	

}
