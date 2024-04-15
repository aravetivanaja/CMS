package com.example.CMS.User.ResponseDTO;

import java.time.LocalDateTime;

import com.example.CMS.User.Enums.PostType;
import com.example.CMS.User.Model.Blog;

public class BlogPostResponse {
	
	private int postId;
	private String title;
	private String subTitle;
	private String summary;
	private PostType postType;
	
	private PublishResponse publishResponse;
	
	public PublishResponse getPublishResponse() {
		return publishResponse;
	}
	public void setPublishResponse(PublishResponse publishResponse) {
		this.publishResponse = publishResponse;
	}


	private Blog blog;
	
	private LocalDateTime createdAt;
	
	private String createdBy;
	
	private String lastModifiedBy;
	
	private LocalDateTime lastModifiedAt;
	
	public Blog getBlog() {
		return blog;
	}
	public void setBlog(Blog blog) {
		this.blog = blog;
	}
	public LocalDateTime getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public String getLastModifiedBy() {
		return lastModifiedBy;
	}
	public void setLastModifiedBy(String lastModifiedBy) {
		this.lastModifiedBy = lastModifiedBy;
	}
	public LocalDateTime getLastModifiedAt() {
		return lastModifiedAt;
	}
	public void setLastModifiedAt(LocalDateTime lastModifiedAt) {
		this.lastModifiedAt = lastModifiedAt;
	}
	public int getPostId() {
		return postId;
	}
	public void setPostId(int postId) {
		this.postId = postId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getSubTitle() {
		return subTitle;
	}
	public void setSubTitle(String subTitle) {
		this.subTitle = subTitle;
	}
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	public PostType getPostType() {
		return postType;
	}
	public void setPostType(PostType postType) {
		this.postType = postType;
	}
	
	
	
	public BlogPostResponse(int postId, String title, String subTitle, String summary, PostType postType,
			PublishResponse publishResponse, Blog blog, LocalDateTime createdAt, String createdBy,
			String lastModifiedBy, LocalDateTime lastModifiedAt) {
		super();
		this.postId = postId;
		this.title = title;
		this.subTitle = subTitle;
		this.summary = summary;
		this.postType = postType;
		this.publishResponse = publishResponse;
		this.blog = blog;
		this.createdAt = createdAt;
		this.createdBy = createdBy;
		this.lastModifiedBy = lastModifiedBy;
		this.lastModifiedAt = lastModifiedAt;
	}
	public BlogPostResponse()
	{
		
	}
	
}
