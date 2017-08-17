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
@Table(name="discussions")
public class Discussion {
	@Id
	@Column(name="discussion_id")
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private int discussionId;
	
	@Column(name="created_date")
	private Date createdDate;
	
	@ManyToOne
	@JoinColumn(name="user_id")
	@NotNull
	private User user;
	
	@Column(name="subject_line")
	private String subjectLine;
	
	@Column(name="subject_text")
	private String subjectText;
	
	@Column(name="last_posted_date")
	private Date lastPostedDate;
	
	@Column(name="total_posts")
	private int totalPosts;
	
	

	@Column(name="last_posted_by")
	private String lastPostedBy;

	public int getDiscussionId() {
		return discussionId;
	}

	public void setDiscussionId(int discussionId) {
		this.discussionId = discussionId;
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

	public String getSubjectLine() {
		return subjectLine;
	}

	public void setSubjectLine(String subjectLine) {
		this.subjectLine = subjectLine;
	}

	public String getSubjectText() {
		return subjectText;
	}

	public void setSubjectText(String subjectText) {
		this.subjectText = subjectText;
	}

	public Date getLastPostedDate() {
		return lastPostedDate;
	}

	public void setLastPostedDate(Date lastPostedDate) {
		this.lastPostedDate = lastPostedDate;
	}

	public String getLastPostedBy() {
		return lastPostedBy;
	}

	public void setLastPostedBy(String lastPostedBy) {
		this.lastPostedBy = lastPostedBy;
	}
	public int getTotalPosts() {
		return totalPosts;
	}

	public void setTotalPosts(int totalPosts) {
		this.totalPosts = totalPosts;
	}
	
	
	

}
