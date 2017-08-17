package com.travellerApp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.travellerApp.dao.DiscussionDao;
import com.travellerApp.entities.Discussion;

@Component("forumService")
@Transactional
public class ForumServiceImpl implements ForumService{
	@Autowired
	private DiscussionDao discussionDao;
	public Discussion createDiscussion(Discussion d){
		
		return discussionDao.save(d);
	}
	
	public List<Discussion> getDiscussion(){
		return (List<Discussion>)discussionDao.findAll();
	}

}
