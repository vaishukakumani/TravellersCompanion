package com.travellerApp.service;


import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.UUID;

import javax.json.Json;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import com.travellerApp.dao.UserDao1;
import com.travellerApp.entities.Itinerary;
import com.travellerApp.entities.User;

@Component("userService")
@Transactional
public class UserSrvcImpl implements UserService{
	@Autowired
	 private UserDao1 userDao;
	public String checkUser(String userName, String password){
		User user = userDao.findByUserName(userName);
		String status;
		String json;
		if(user!=null){
			if(user.getPassword().equals(password))
				status= "UserFound";
			else
				status= "PasswordIncorrect";	
			json = Json.createObjectBuilder()
		            .add("status", status)
		            .add("userName", userName)
		            .add("userId", user.getUserId())
		            .build()
		            .toString();
			return json;
		}
		else{
			status= "UserNotFound";
		json = Json.createObjectBuilder()
	            .add("status", status)
	            .add("userName", userName)
	            .add("userId", 0)
	            .build()
	            .toString();
		return json;
		}
		
	}
	
	public void createUser(){
		User user = new User();
		user.setFirstName("vaishnavi");
		user.setLastName("kakumani");
		user.setPassword("12345678");
		user.setUserName("vaishukakumani");
		userDao.save(user);
		
	}
	
	

}
