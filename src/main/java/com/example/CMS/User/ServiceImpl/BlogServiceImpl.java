package com.example.CMS.User.ServiceImpl;

import java.util.Arrays;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.CMS.User.DTO.BlogRequest;
import com.example.CMS.User.Exception.BlogAlreadyExistsByTitleException;
import com.example.CMS.User.Exception.BlogNotFoundByIdException;
import com.example.CMS.User.Exception.TopicNotSpecifiedException;
import com.example.CMS.User.Exception.UserNotFoundByIdException;
import com.example.CMS.User.Model.Blog;
import com.example.CMS.User.Repository.BlogRepository;
import com.example.CMS.User.Repository.UserRepository;
import com.example.CMS.User.ResponseDTO.BlogResponse;
import com.example.CMS.User.Service.BlogService;
import com.example.CMS.User.Utility.ResponseStructure;

@Service
public class BlogServiceImpl implements BlogService{
	
	private BlogRepository br;
	private UserRepository ur;
	private ResponseStructure<BlogResponse> responseStructure;

	public BlogServiceImpl(BlogRepository br, UserRepository ur,    ResponseStructure<BlogResponse> responseStructure) {
		super();
		this.br = br;
		this.ur=ur;
		this.responseStructure = responseStructure;
	}

	@Override
	public ResponseEntity<ResponseStructure<BlogResponse>> createBlog(int userId,BlogRequest blogReq) {
		return ur.findById(userId).map(user->{
			if(br.existsByTitle(blogReq.getTitle()))
				throw new BlogAlreadyExistsByTitleException("blog will not create");
			if(blogReq.getTopics().length<1)
				throw new TopicNotSpecifiedException("failed to create blog");
		Blog blog=mapToBlogRequest(blogReq, new Blog());
		blog.setUsersList(Arrays.asList(user));
		br.save(blog);
		return ResponseEntity.ok(responseStructure.setStatusCode(HttpStatus.OK.value())
				.setMessage("blog is created")
				.setData(mapToBlogResponse(blog)));
		}).orElseThrow(()-> new UserNotFoundByIdException("failed to create blog"));
	}
	
	@Override
	public ResponseEntity<Boolean> checkBlogTitleAvailability(String title)
	{
		return new ResponseEntity<Boolean> (br.existsByTitle(title),HttpStatus.FOUND);
	}
	


	
	private Blog mapToBlogRequest(BlogRequest blogReq,Blog blog)
	{
		blog.setTitle(blogReq.getTitle());
		blog.setTopics(blogReq.getTopics());
		blog.setSummary(blogReq.getSummary());
		blog.setUsersList(blogReq.getUsers());
		return blog;
	}
	
	private BlogResponse mapToBlogResponse(Blog blog)
	{
		BlogResponse blogRes=new BlogResponse();
		blogRes.setBlogId(blog.getBlogId());
		blogRes.setTitle(blog.getTitle());
		blogRes.setTopics(blog.getTopics());
		blogRes.setSummary(blog.getSummary());
		return blogRes;
	}

	@Override
	public ResponseEntity<ResponseStructure<BlogResponse>> findBlogById(int blogId) {
		return br.findById(blogId).map(blog ->{
			return ResponseEntity.ok(responseStructure.setStatusCode(HttpStatus.OK.value())
					.setMessage("blog is find by id")
					.setData(mapToBlogResponse(blog)));
		}).orElseThrow(()-> new BlogNotFoundByIdException("blog not found"));

	}

	@Override
	public ResponseEntity<ResponseStructure<BlogResponse>> updateBlog(BlogRequest blogReq,int blogId) {
		
		return br.findById(blogId).map(blog ->{
			
			blog.setTitle(blogReq.getTitle());
			blog.setTopics(blogReq.getTopics());
			blog.setSummary(blogReq.getSummary());
			
			Blog newBlog= br.save(blog);
			return ResponseEntity.ok(responseStructure.setStatusCode(HttpStatus.OK.value())
					.setMessage("blog updated by id")
					.setData(mapToBlogResponse(blog))
					);
			
		}).orElseThrow(()-> new  BlogNotFoundByIdException("invalid blog"));
	}
	
	

}
