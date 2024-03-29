package com.example.CMS.User.Service;

import org.springframework.http.ResponseEntity;

import com.example.CMS.User.DTO.BlogRequest;
import com.example.CMS.User.ResponseDTO.BlogResponse;
import com.example.CMS.User.Utility.ResponseStructure;

public interface BlogService {

	public ResponseEntity<ResponseStructure<BlogResponse>> createBlog(int userId,BlogRequest blogReq);

	public ResponseEntity<Boolean> checkBlogTitleAvailability(String title);

	public ResponseEntity<ResponseStructure<BlogResponse>> findBlogById(int blogId);

	public ResponseEntity<ResponseStructure<BlogResponse>> updateBlog(BlogRequest blogReq,int blogId);
}