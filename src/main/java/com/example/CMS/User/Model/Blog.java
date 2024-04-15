package com.example.CMS.User.Model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

@Entity
@Table(name="blogs")
public class Blog {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int blogId;

	private String title;

	private String[] topics;

	private String summary;
	
	@CreatedDate
	private LocalDateTime createdAt;
	
	@LastModifiedDate
	private LocalDateTime modifiedAt;

	//	@ManyToMany
	//	private List<User> usersList=new ArrayList<>();

	@ManyToOne
	private User user;

	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	//	public List<User> getUsersList() {
	//		return usersList;
	//	}
	//	public void setUsersList(List<User> usersList) {
	//		this.usersList = usersList;
	//	}
	
	
	@OneToMany(mappedBy="blog")
	private List<BlogPost> blogPostList=new ArrayList<>();
	
	
	
	public List<BlogPost> getBlogPostList() {
		return blogPostList;
	}
	public void setBlogPostList(List<BlogPost> blogPostList) {
		this.blogPostList = blogPostList;
	}


	@OneToOne
	private ContributionPanel panel;
	
	public ContributionPanel getContributionPanel() {
		return panel;
	}
	public void setContributionPanel(ContributionPanel panel) {
		this.panel = panel;
	}
	
	
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
	public Blog(int blogId, String title, String[] topics, String summary, LocalDateTime createdAt,
			LocalDateTime modifiedAt, User user, List<BlogPost> blogPostList, ContributionPanel panel) {
		super();
		this.blogId = blogId;
		this.title = title;
		this.topics = topics;
		this.summary = summary;
		this.createdAt = createdAt;
		this.modifiedAt = modifiedAt;
		this.user = user;
		this.blogPostList = blogPostList;
		this.panel = panel;
	}
	
	public Blog()
	{
		
	}




}
