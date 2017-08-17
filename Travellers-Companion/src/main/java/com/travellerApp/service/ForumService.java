package com.travellerApp.service;

import java.util.List;

import com.travellerApp.entities.Discussion;

public interface ForumService {
	public Discussion createDiscussion(Discussion d);
	public List<Discussion> getDiscussion();
}
