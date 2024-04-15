package com.example.CMS.User.Service;

import org.springframework.http.ResponseEntity;

import com.example.CMS.User.DTO.PublishRequest;
import com.example.CMS.User.ResponseDTO.BlogPostResponse;
import com.example.CMS.User.ResponseDTO.PublishResponse;
import com.example.CMS.User.Utility.ResponseStructure;

public interface PublishService {

	ResponseEntity<ResponseStructure<BlogPostResponse>> unpublishBlogPost(int postId);

	ResponseEntity<ResponseStructure<PublishResponse>> publishPost(int postId, PublishRequest publishReq);
	
	

}
