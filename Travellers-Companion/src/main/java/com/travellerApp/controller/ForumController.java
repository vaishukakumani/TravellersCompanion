package com.travellerApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.travellerApp.entities.Discussion;
import com.travellerApp.service.ForumService;

@RestController
@RequestMapping(value="/api/forum")

public class ForumController {
	@Autowired
	private ForumService forumService;
	
	@RequestMapping(value="/discussion", method=RequestMethod.POST,produces="application/json",consumes="application/json")
	@ResponseBody
	public Discussion createDiscussion(@RequestBody Discussion discussion){
		return forumService.createDiscussion(discussion);
	}
	
	@RequestMapping(value="/discussion", method=RequestMethod.GET,produces="application/json")

	public List<Discussion> getDiscussion(){
		return forumService.getDiscussion();
	}
	
	@RequestMapping(value="/api/health", method=RequestMethod.GET )
	public String health(){
		return "RestController";
	}
	
}
