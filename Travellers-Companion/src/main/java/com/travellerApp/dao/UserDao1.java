package com.travellerApp.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.travellerApp.entities.User;

@Repository
public interface UserDao1 extends PagingAndSortingRepository<User, Integer>{
	
	//@Query("select user from User user where user.userName=?1")
	public User findByUserName(String userName);
		
	
}
