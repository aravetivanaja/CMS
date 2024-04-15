package com.example.CMS.User.Model;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import com.example.CMS.User.Enums.PostType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

@Entity
public class BlogPost {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int postId;
	
	@NotNull(message="title should not be null")
	private String title;
	private String subTitle;
	@Min(value=500 ,message="enter atleast 500 characters ")
	@Max(value=3000 ,message="enter max 3000 characters")
	private String summary;
	@Enumerated(EnumType.STRING)
	private PostType postType;
	
	@CreatedDate
	@Column(updatable=false)
	private LocalDateTime createdAt;
	
	@CreatedBy
	private String createdBy;
	
	@LastModifiedDate
	private LocalDateTime lastModifiedAt;
	
	@LastModifiedBy
	private String lastMdifiedBy;
	
	
	
//	private String seoTitle;
//	private String seoDescription;
//	private String seoTopics;
	
	@ManyToOne
	private Blog blog;
	
	@OneToOne
	private Publish publish;
	
	
	
	public BlogPost(int postId, @NotNull(message = "title should not be null") String title, String subTitle,
			@Min(value = 500, message = "enter atleast 500 characters ") @Max(value = 3000, message = "enter max 3000 characters") String summary,
			PostType postType, LocalDateTime createdAt, String createdBy, LocalDateTime lastModifiedAt,
			String lastMdifiedBy, Blog blog, Publish publish) {
		super();
		this.postId = postId;
		this.title = title;
		this.subTitle = subTitle;
		this.summary = summary;
		this.postType = postType;
		this.createdAt = createdAt;
		this.createdBy = createdBy;
		this.lastModifiedAt = lastModifiedAt;
		this.lastMdifiedBy = lastMdifiedBy;
		this.blog = blog;
		this.publish = publish;
	}
	public Publish getPublish() {
		return publish;
	}
	public void setPublish(Publish publish) {
		this.publish = publish;
	}
	public Blog getBlog() {
		return blog;
	}
	public void setBlog(Blog blog) {
		this.blog = blog;
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
//	public String getSeoTitle() {
//		return seoTitle;
//	}
//	public void setSeoTitle(String seoTitle) {
//		this.seoTitle = seoTitle;
//	}
//	public String getSeoDescription() {
//		return seoDescription;
//	}
//	public void setSeoDescription(String seoDescription) {
//		this.seoDescription = seoDescription;
//	}
//	public String getSeoTopics() {
//		return seoTopics;
//	}
//	public void setSeoTopics(String seoTopics) {
//		this.seoTopics = seoTopics;
//	}
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
	public LocalDateTime getLastModifiedAt() {
		return lastModifiedAt;
	}
	public void setLastModifiedAt(LocalDateTime lastModifiedAt) {
		this.lastModifiedAt = lastModifiedAt;
	}
	public String getLastMdifiedBy() {
		return lastMdifiedBy;
	}
	public void setLastMdifiedBy(String lastMdifiedBy) {
		this.lastMdifiedBy = lastMdifiedBy;
	}
	
	
	public BlogPost()
	{
		
	}
	

}
