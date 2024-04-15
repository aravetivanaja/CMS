package com.example.CMS.User.DTO;

import java.time.LocalDateTime;

import com.example.CMS.User.Model.Schedule;

public class PublishRequest {
	
	private String seoTitle;
	private String seoDescription;
	private String seoTags;
	
	private Schedule schedule;
	
	public Schedule getSchedule() {
		return schedule;
	}
	public void setSchedule(Schedule schedule) {
		this.schedule = schedule;
	}
	public String getSeoTitle() {
		return seoTitle;
	}
	public void setSeoTitle(String seoTitle) {
		this.seoTitle = seoTitle;
	}
	public String getSeoDescription() {
		return seoDescription;
	}
	public void setSeoDescription(String seoDescription) {
		this.seoDescription = seoDescription;
	}
	public String getSeoTags() {
		return seoTags;
	}
	public void setSeoTags(String seoTags) {
		this.seoTags = seoTags;
	}
	
	public PublishRequest() {
		super();
	}
	public PublishRequest(String seoTitle, String seoDescription, String seoTags, Schedule schedule) {
		super();
		this.seoTitle = seoTitle;
		this.seoDescription = seoDescription;
		this.seoTags = seoTags;
		this.schedule = schedule;
	}
	
	
	

}
