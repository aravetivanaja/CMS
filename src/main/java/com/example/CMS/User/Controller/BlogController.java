package com.example.CMS.User.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.CMS.User.DTO.BlogRequest;
import com.example.CMS.User.ResponseDTO.BlogResponse;
import com.example.CMS.User.ResponseDTO.ContributionPanelResponse;
import com.example.CMS.User.Service.BlogService;
import com.example.CMS.User.Utility.ResponseStructure;

@RestController
public class BlogController {
	
	private BlogService bs;
	
	public BlogController(BlogService bs) {
		this.bs = bs;
	}
	public BlogController()
	{
		
	}

	@PostMapping(value="/users/{userId}/blogs")
	public ResponseEntity<ResponseStructure<BlogResponse>> createBlog(@PathVariable int userId,@RequestBody BlogRequest blogReq)
	{
		return bs.createBlog(userId, blogReq);
	}
	
	@GetMapping(value="/titles/{title}/blogs")
	public ResponseEntity<Boolean> checkBlogTitleAvailability(@PathVariable  String title)
	{
		return bs.checkBlogTitleAvailability(title);
	}
	
	@GetMapping("/blogs{blogId}")
	public ResponseEntity<ResponseStructure<BlogResponse>> findBlogById(@PathVariable int blogId)
	{
		return bs.findBlogById(blogId);
	}
	
	@PutMapping("/blogs/{blogId}")
	public ResponseEntity<ResponseStructure<BlogResponse>> updateBlog(@RequestBody BlogRequest blogReq,@PathVariable int blogId)
	{
		return bs.updateBlog(blogReq, blogId);
	}
	
	
	
}
