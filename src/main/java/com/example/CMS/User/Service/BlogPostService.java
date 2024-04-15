package com.example.CMS.User.Service;

import org.springframework.http.ResponseEntity;

import com.example.CMS.User.DTO.BlogPostRequest;
import com.example.CMS.User.DTO.PublishRequest;
import com.example.CMS.User.ResponseDTO.BlogPostResponse;
import com.example.CMS.User.Utility.ResponseStructure;

public interface BlogPostService {

	public ResponseEntity<ResponseStructure<BlogPostResponse>> createDraft(int blogId, BlogPostRequest blogPostReq) ;

	public ResponseEntity<ResponseStructure<BlogPostResponse>> updateDraft(int postId, BlogPostRequest blogPostReq);

	public ResponseEntity<ResponseStructure<BlogPostResponse>> deleteBlogPost(int postId);

	public ResponseEntity<ResponseStructure<BlogPostResponse>> findBlogPostById(int postId);

	public ResponseEntity<ResponseStructure<BlogPostResponse>> findBYIdByPostType(int postId);

	public ResponseEntity<ResponseStructure<BlogPostResponse>> publishBlogPost(int postId, PublishRequest publishReq);

	public ResponseEntity<ResponseStructure<BlogPostResponse>> unPublishBlogPost(int postId);

	

	
}
