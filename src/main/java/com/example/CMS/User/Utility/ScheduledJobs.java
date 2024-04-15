package com.example.CMS.User.Utility;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.example.CMS.User.Enums.PostType;
import com.example.CMS.User.Model.BlogPost;
import com.example.CMS.User.Repository.BlogPostRepository;

@Component
public class ScheduledJobs {
	
	@Autowired
	private BlogPostRepository bpr;
	
	public ScheduledJobs(BlogPostRepository bpr) {
		super();
		this.bpr = bpr;
	}
	
	@Scheduled(fixedDelay=1000L)
	public void loginLocalDateTime()
	{
		System.out.println(LocalDateTime.now());
	}
	
	@Scheduled(fixedDelay =60*1000l)
	public void publishScheduledBlogPosts()
	{
		
		List<BlogPost> posts=bpr.findAllByPublishScheduleDateTimeLessThanEqualAndPostType(LocalDateTime.now() ,PostType.SCHEDULED)
				.stream()
				.map(post ->{
					post.setPostType(PostType.PUBLISHED);
					return post;
				})
				.collect(Collectors.toList());
		
		bpr.saveAll(posts);
	}
	

}
