package com.travellerApp.dao;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.travellerApp.entities.Discussion;
import com.travellerApp.entities.Post;
@Repository
public interface PostDao extends PagingAndSortingRepository<Post, Integer> {

}
