package com.travellerApp;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;

import java.io.StringReader;
import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.servlet.http.HttpServletRequest;

//import org.json.JSONObject;

import com.travellerApp.entities.Itinerary;
import com.travellerApp.entities.User;
import com.travellerApp.service.ItineraryService;
import com.travellerApp.service.UserService;

//@SpringBootApplication(scanBasePackages={"/com"})
@org.springframework.web.bind.annotation.RestController
public class RestController {
@Autowired
private UserService userService;
@Autowired
private ItineraryService itineraryService;

 @RequestMapping(value="/api/login/checkUser",method=RequestMethod.GET)
 @ResponseBody
  public String checkUser(@RequestParam String userName,@RequestParam String password) {
	
	 System.out.println("user is:"+userName);
	 System.out.println("password is:"+password);
	 String json= userService.checkUser(userName, password);
	return json;
 }
 
 @RequestMapping(value="/api/createUser", method=RequestMethod.GET)
 public String createUser(){
 userService.createUser();
 
 return "success";
 
} 
 
	@RequestMapping(value="/api/Itinerary/viewItinerary",method=RequestMethod.POST,produces="application/json")
	@ResponseBody
	public List<Itinerary> fetchItineraries(@RequestBody String userId){
		return itineraryService.fetchItineraries(Integer.parseInt(userId));
		
	}
 

	
}
