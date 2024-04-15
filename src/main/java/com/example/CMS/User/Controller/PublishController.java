package com.example.CMS.User.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.CMS.User.DTO.PublishRequest;
import com.example.CMS.User.ResponseDTO.PublishResponse;
import com.example.CMS.User.Service.PublishService;
import com.example.CMS.User.Utility.ResponseStructure;



public class PublishController {
	
	
	private PublishService ps;

	public PublishController(PublishService ps) {
		super();
		this.ps = ps;
	}
	
	@PostMapping("/blog-posts/{postId}/publishes")
	public ResponseEntity<ResponseStructure<PublishResponse>> publishPost(@PathVariable int postId,@RequestBody PublishRequest publishReq)
	{
		return ps.publishPost(postId,publishReq);
	}

}
