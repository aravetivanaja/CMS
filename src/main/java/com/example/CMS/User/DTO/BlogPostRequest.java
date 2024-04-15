package com.example.CMS.User.DTO;

import com.example.CMS.User.Enums.PostType;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class BlogPostRequest {

	@NotNull
	private String title;
	private String subTitle;
	@Size(min=500 ,message="field must be atleast 500 characters long")
	private String summary;
	private PostType postType;
	
	
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
	public BlogPostRequest(@NotNull String title, String subTitle,
			@Size(min = 500, message = "field must be atleast 500 characters long") String summary, PostType postType) {
		super();
		this.title = title;
		this.subTitle = subTitle;
		this.summary = summary;
		this.postType = postType;
	}
	
	public BlogPostRequest()
	{
		
	}
	

}
