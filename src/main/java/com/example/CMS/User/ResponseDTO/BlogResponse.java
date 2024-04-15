package com.example.CMS.User.ResponseDTO;

import java.util.ArrayList;
import java.util.List;

import com.example.CMS.User.Model.Blog;
import com.example.CMS.User.Model.User;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public class BlogResponse {
	
	private int blogId;
	private String title;
	private String[] topics;
	private String summary;
	
	private User user;
	
	
	public int getBlogId() {
		return blogId;
	}
	public void setBlogId(int blogId) {
		this.blogId = blogId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String[] getTopics() {
		return topics;
	}
	public void setTopics(String[] topics) {
		this.topics = topics;
	}
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	public BlogResponse(int blogId, String title, String[] topics, String summary, User user) {
		super();
		this.blogId = blogId;
		this.title = title;
		this.topics = topics;
		this.summary = summary;
		this.user = user;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	
	public BlogResponse()
	{
		
	}

}
