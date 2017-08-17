package com.travellerApp.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="posts")
public class Post {
	 @Id
	  @Column(name="post_id")
	  @GeneratedValue(strategy=GenerationType.SEQUENCE)
	private int postId;
	 
	 @Column(name="created_date")
	private Date createdDate;
	 
	@ManyToOne
	@JoinColumn(name="user_id")
	@NotNull
	private User user;
	
	@ManyToOne
	@JoinColumn(name="discussion_id")
	@NotNull
	private Discussion discussion;
	
	@Column(name="post_text")
	private String postText;

	public int getPostId() {
		return postId;
	}

	public void setPostId(int postId) {
		this.postId = postId;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Discussion getDiscussion() {
		return discussion;
	}

	public void setDiscussion(Discussion discussion) {
		this.discussion = discussion;
	}

	public String getPostText() {
		return postText;
	}

	public void setPostText(String postText) {
		this.postText = postText;
	}
	
	
	
	

}
