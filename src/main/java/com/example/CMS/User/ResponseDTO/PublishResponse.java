package com.example.CMS.User.ResponseDTO;

public class PublishResponse {
	
	private int publishId;
	private String seoTitle;
	private String seoDescription;
	private String seoTags;

	
	public int getPublishId() {
		return publishId;
	}
	public void setPublishId(int publishId) {
		this.publishId = publishId;
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
	public PublishResponse(int publishId, String seoTitle, String seoDescription, String seoTags) {
		super();
		this.publishId = publishId;
		this.seoTitle = seoTitle;
		this.seoDescription = seoDescription;
		this.seoTags = seoTags;
	}
	
	public PublishResponse()
	{
		
	}
}
