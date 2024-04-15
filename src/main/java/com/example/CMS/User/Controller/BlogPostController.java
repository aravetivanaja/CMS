package com.example.CMS.User.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RestController;

import com.example.CMS.User.DTO.BlogPostRequest;
import com.example.CMS.User.DTO.PublishRequest;
import com.example.CMS.User.ResponseDTO.BlogPostResponse;
import com.example.CMS.User.Service.BlogPostService;
import com.example.CMS.User.Utility.ResponseStructure;

@RestController
public class BlogPostController {
	
	private BlogPostService bps;
	
	
	public BlogPostController(BlogPostService bps) {
		super();
		this.bps = bps;
	}

	@PostMapping("/blogs/{blogId}/blog-posts")
	public ResponseEntity<ResponseStructure<BlogPostResponse>>createDraft(@PathVariable int blogId,@RequestBody BlogPostRequest blogPostReq)
	{
		return bps.createDraft(blogId,blogPostReq);
	}

	@PutMapping("/blog-posts/{postId}")
	public ResponseEntity<ResponseStructure<BlogPostResponse>> updateDraft(@PathVariable int postId,@RequestBody BlogPostRequest blogPostReq)
	{
		return bps.updateDraft(postId,blogPostReq);
	}
	
	@DeleteMapping("/blog-posts/{postId}")
	public ResponseEntity<ResponseStructure<BlogPostResponse>> deleteBlogPost(@PathVariable int postId)
	{
		return bps.deleteBlogPost(postId);
	}
	
	@PostMapping("/blog-posts/{postId}/publishes")
	public ResponseEntity<ResponseStructure<BlogPostResponse>> publishBlogPost(@PathVariable int postId,@RequestBody PublishRequest publishReq)
	{
		return bps.publishBlogPost(postId,publishReq);
	}
	
	@PostMapping("/blog-posts/{postId}/publishes")
	public ResponseEntity<ResponseStructure<BlogPostResponse>> unpublishBlogPost(int postId) {
		
		return bps.unPublishBlogPost(postId);
	
	}
		
	@GetMapping("/blog-posts/{postId}")
	public ResponseEntity<ResponseStructure<BlogPostResponse>> findBlogPostById(@PathVariable int postId)
	{
		return bps.findBlogPostById(postId);
	}
	
	@GetMapping("/blog-posts/{postId}/{postType}")
	public ResponseEntity<ResponseStructure<BlogPostResponse>> findByIdByPostType(@PathVariable int postId)
	{
		return bps.findBYIdByPostType(postId);
	}
	
	
	
}
