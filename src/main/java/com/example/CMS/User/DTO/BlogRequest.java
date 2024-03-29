package com.example.CMS.User.DTO;

import java.util.ArrayList;
import java.util.List;

import com.example.CMS.User.Model.User;

import jakarta.persistence.ManyToMany;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public class BlogRequest {
	
	@Pattern(regexp = "[A-Za-z]" ,message="enter title")
	@NotNull
	private String title;

	private String[] topics;

	private String summary;
	
	@ManyToMany
	private List<User> users=new ArrayList<>();
	

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
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
	
	

}
