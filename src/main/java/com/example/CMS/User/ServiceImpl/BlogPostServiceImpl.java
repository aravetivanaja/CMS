package com.example.CMS.User.ServiceImpl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.stereotype.Service;

import com.example.CMS.User.DTO.BlogPostRequest;
import com.example.CMS.User.DTO.PublishRequest;
import com.example.CMS.User.Enums.PostType;
import com.example.CMS.User.Exception.BlogNotFoundByIdException;
import com.example.CMS.User.Exception.BlogPostIsNotPUBLISHEDException;
import com.example.CMS.User.Exception.BlogPostNotFoundBYIdByPostTypeException;
import com.example.CMS.User.Exception.BlogPostNotFoundByIdException;
import com.example.CMS.User.Exception.ScheduleNotFoundException;
import com.example.CMS.User.Exception.ScheduledTimeExpiredException;
import com.example.CMS.User.Exception.UnAuthorizedException;
import com.example.CMS.User.Exception.UserNotFoundByIdException;
import com.example.CMS.User.Model.Blog;
import com.example.CMS.User.Model.BlogPost;
import com.example.CMS.User.Model.Publish;
import com.example.CMS.User.Model.Schedule;
import com.example.CMS.User.Repository.BlogPostRepository;
import com.example.CMS.User.Repository.BlogRepository;
import com.example.CMS.User.Repository.ContributionPanelRepository;
import com.example.CMS.User.Repository.PublishRepository;
import com.example.CMS.User.Repository.ScheduleRepository;
import com.example.CMS.User.Repository.UserRepository;
import com.example.CMS.User.ResponseDTO.BlogPostResponse;
import com.example.CMS.User.ResponseDTO.PublishResponse;
import com.example.CMS.User.Service.BlogPostService;
import com.example.CMS.User.Utility.ResponseStructure;

@Service
public class BlogPostServiceImpl implements BlogPostService{
	
	private BlogPostRepository bpr;
	private BlogRepository br;
	private ResponseStructure<BlogPostResponse> responseStructure;
	private UserRepository ur;
	private ContributionPanelRepository cpr;
	private PublishRepository pr;
	private ScheduleRepository  sr;

	public BlogPostServiceImpl(BlogPostRepository bpr,BlogRepository br, ResponseStructure<BlogPostResponse> responseStructure,UserRepository ur,ScheduleRepository  sr) {

		this.bpr = bpr;
		this.br=br;
		this.responseStructure = responseStructure;
		this.ur=ur;
		this.sr=sr;
		
	}

	@Override
	public ResponseEntity<ResponseStructure<BlogPostResponse>> createDraft(int blogId, BlogPostRequest blogPostReq) {
		
		String email=SecurityContextHolder.getContext().getAuthentication().getName();
		return ur.findByEmail(email).map(user ->{
			
			return br.findById(blogId).map(blog->{
				
				if(!blog.getUser().getEmail().equals(email) && !cpr.existsByPanelIdAndContributors(blog.getContributionPanel().getPanelId(), user))
					throw new BlogNotFoundByIdException("could not create blog draft");
				
				BlogPost blogPost=mapToBlogPostRequest(blogPostReq,new BlogPost());
				blogPost.setPostType(PostType.DRAFT);
				blogPost.setBlog(blog);
				
				return ResponseEntity.ok(responseStructure.setStatusCode(HttpStatus.OK.value())
						.setMessage("draft post created")
						.setData(mapToBlogPostResponse(bpr.save(blogPost))));
				
				
			}).orElseThrow(()-> new BlogNotFoundByIdException("could not crate blog post"));
		}).orElseThrow(()-> new UserNotFoundByIdException("could not create blog post"));
	}
	

	private BlogPost mapToBlogPostRequest(BlogPostRequest blogPostRequest,BlogPost blogPost)
	{
		blogPost.setPostType(blogPostRequest.getPostType());
		blogPost.setSubTitle(blogPostRequest.getSubTitle());
		blogPost.setSummary(blogPostRequest.getSummary());
		blogPost.setTitle(blogPostRequest.getTitle());
		return blogPost;
		
	}
	private BlogPostResponse mapToBlogPostResponse(BlogPost blogPost)
	{
		BlogPostResponse blogPostResponse=new BlogPostResponse();
		blogPostResponse.setPostId(blogPost.getPostId());
		blogPostResponse.setPostType(blogPost.getPostType());
		blogPostResponse.setSubTitle(blogPost.getSubTitle());
		blogPostResponse.setSummary(blogPost.getSummary());
		blogPostResponse.setTitle(blogPost.getTitle());
		if(blogPost.getPublish() != null) blogPostResponse.setPublishResponse(mapToPublishResponse(blogPost.getPublish()));
		return blogPostResponse;
	}

	@Override
	public ResponseEntity<ResponseStructure<BlogPostResponse>> updateDraft(int postId, BlogPostRequest blogPostReq) {
		
			
			String userName=SecurityContextHolder.getContext().getAuthentication().getName();
			
			return bpr.findById(postId).map(prevPost ->{
				
				return ur.findByEmail(userName).map(user->{
					
					if(!prevPost.getBlog().getUser().getEmail().equals(userName) && !cpr.existsByPanelIdAndContributors(prevPost.getBlog().getContributionPanel().getPanelId(), user))
						throw new BlogNotFoundByIdException("cannot update blog post");
					
					BlogPost blogPost=mapToBlogPostRequest(blogPostReq, new BlogPost());
					blogPost.setPostType(PostType.DRAFT);
					blogPost.setPostId(prevPost.getPostId());
					
					return ResponseEntity.ok(responseStructure.setStatusCode(HttpStatus.OK.value())
							.setMessage("draft post updated successfully")
							.setData(mapToBlogPostResponse(bpr.save(blogPost))));
				}).orElseThrow(()-> new UsernameNotFoundException("this is not the owner or contributor"));
				
			}).orElseThrow(()-> new BlogPostNotFoundByIdException("the blog post is not found by given id :"+postId));
				
			
			}

	@Override
	public ResponseEntity<ResponseStructure<BlogPostResponse>> deleteBlogPost(int postId) {
		
		String userName=SecurityContextHolder.getContext().getAuthentication().getName();
		
		return ur.findByEmail(userName).map(owner ->{
			
			return bpr.findById(postId).map(blogPost ->{
				
				if(!blogPost.getBlog().getUser().getEmail().equals(userName) && !cpr.existsByPanelIdAndContributors(postId, owner))
					throw new UnAuthorizedException("illegal accept request");
				bpr.delete(blogPost);
				
				Blog blog = br.findById(blogPost.getBlog().getBlogId()).get();
				blog.getBlogPostList().remove(blogPost);
				br.save(blog);
				
				
			return ResponseEntity.ok(responseStructure.setStatusCode(HttpStatus.OK.value())
					.setMessage("delete post successfully")
					.setData(mapToBlogPostResponse(blogPost)));
			
			}).orElseThrow(() -> new UserNotFoundByIdException("cannot delete user"));
			
		}).orElseThrow(()-> new BlogPostNotFoundByIdException("cannot delete blogpost"));
		
	}

	
	@Override
	public ResponseEntity<ResponseStructure<BlogPostResponse>> findBlogPostById(int postId) {
		

			return bpr.findById(postId).map(blogPost ->{
					return ResponseEntity.ok(responseStructure.setStatusCode(HttpStatus.OK.value())
						.setMessage("blog post found succeessfully")
						.setData(mapToBlogPostResponse(blogPost))
						);
				
			}).orElseThrow(()-> new BlogPostNotFoundByIdException("cannot find blogpost"));
	}

	

	@Override
	public ResponseEntity<ResponseStructure<BlogPostResponse>> findBYIdByPostType(int postId) {
		
		return bpr.findById(postId).map(blogPost->{
			
			if(blogPost.getPostType()!=PostType.PUBLISHED)
				
				throw new BlogPostIsNotPUBLISHEDException("post is not published");
			
			return ResponseEntity.ok(responseStructure.setStatusCode(HttpStatus.OK.value())
					.setMessage("post is found")
					.setData(mapToBlogPostResponse(blogPost)));
				
		}).orElseThrow(()-> new BlogPostNotFoundByIdException("blog post not found"));
	}
		

	@Override
	public ResponseEntity<ResponseStructure<BlogPostResponse>> publishBlogPost(int postId,PublishRequest publishRequest) {
		
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		
		return bpr.findById(postId).map(post -> {
			
			return ur.findByEmail(username).map(user -> {
				
				if(!post.getBlog().getUser().getEmail().equals(username) && !cpr.existsByPanelIdAndContributors(post.getBlog().getContributionPanel().getPanelId(), user))
					throw new UnAuthorizedException("The user do not have access to modify the post");
				post.setPostType(PostType.PUBLISHED);
				
				return ResponseEntity.ok(responseStructure.setStatusCode(HttpStatus.OK.value())
						.setMessage("published blogpost successfully")
						.setData(mapToBlogPostResponse(post)));
				
			}).orElseThrow(() -> new UnAuthorizedException("You do not have the access to create this blog"));
			
		}).orElseThrow(() -> new BlogPostNotFoundByIdException("The blog post id you mentioned is no where to be found"));
	}
	
	@Override
	public ResponseEntity<ResponseStructure<BlogPostResponse>> unPublishBlogPost(int postId) {
		
		return bpr.findById(postId).map(post -> {
			post.setPostType(PostType.DRAFT);
			return ResponseEntity.ok(responseStructure.setStatusCode(HttpStatus.OK.value())
					.setMessage("unpublish blog post")
					.setData(mapToBlogPostResponse(bpr.save(post))));
			
			
		}).orElseThrow(() -> new BlogPostNotFoundByIdException("The blog is not found by the given Id: "+postId));
	}
	
	private PublishResponse mapToPublishResponse(Publish publish)
	{
		PublishResponse publishResponse=new PublishResponse();
		publishResponse.setPublishId(publish.getPublishId());
		publishResponse.setSeoDescription(publish.getSeoDescription());
		publishResponse.setSeoTags(publish.getSeoTags());
		publishResponse.setSeoTitle(publish.getSeoTitle());
		
		return publishResponse;
	}
	
	
//	@Override
//	public ResponseEntity<ResponseStructure<BlogPostResponse>> publishBlogPost(int postId,
//			PublishRequest publishRequest) {
//		
//		String username = SecurityContextHolder.getContext().getAuthentication().getName();
//		return bpr.findById(postId).map(post -> {
//			
//			return ur.findByEmail(username).map(user -> {
//				
//				if(!post.getBlog().getUser().getEmail().equals(username) && !cpr.existsByPanelIdAndContributors(post.getBlog().getContributionPanel().getPanelId(), user))
//					throw new UnAuthorizedException("The user do not have access to modify the post");
//				post.setPostType(PostType.PUBLISHED);
////				Publish publish = null;
////				Schedule schedule = post.getPublish().getSchedule();
////				
////				if(post.getPublish()!=null) {
////					if(publishRequest.getSchedule()==null)
////						throw new ScheduleNotFoundException("There is no schedule present");
////					if(!publishRequest.getSchedule().getDateTime().isAfter(LocalDateTime.now()))
////						throw new ScheduledTimeExpiredException("The published time is already expired");
////					publish = mapToBlogPostRequest(publishRequest, post.getPublish());
////				}
////				else
////					publish = mapToPublishResponse(publishRequest, new Publish());
////				
////				schedule.setDateTime(publishRequest.getSchedule().getDateTime());
////				if(publishRequest.getSchedule()!=null)  {
////					publish.setSchedule(sr.save(schedule));
////					post.setPostType(PostType.PUBLISHED);
////				}
////				else 
////					post.setPostType(PostType.SCHEDULED);
////				
////				publish.setBlogPost(post);
////				
////				pr.save(publish);
////				
////				schedule.setDateTime(publishRequest.getSchedule().getDateTime());
////				sr.save(schedule);
////				
//				return ResponseEntity.ok(responseStructure.setStatusCode(HttpStatus.OK.value())
//						.setMessage("Publish is created Successfully")
//						.setData(mapToBlogPostResponse(bpr.save(post))));
//				
//			}).orElseThrow(() -> new UnAuthorizedException("You do not have the access to create this blog"));
//			
//		}).orElseThrow(() -> new BlogPostNotFoundByIdException("The blog post id you mentioned is no where to be found"));
//	}
	
	private Publish mapToPublishRequest(PublishRequest publishRequest,Publish publish)

	{
		publish.setSchedule(publishRequest.getSchedule());
		publish.setSeoTags(publishRequest.getSeoTags());
		publish.setSeoDescription(publishRequest.getSeoDescription());
		publish.setSeoTitle(publishRequest.getSeoTitle());
		return publish;
	}
	
//	private PublishResponse mapToPublishResponse(Publish publish)
//	{
//		PublishResponse publishResponse=new PublishResponse();
//		publishResponse.setPublishId(publish.getPublishId());
//		publishResponse.setSeoDescription(publish.getSeoDescription());
//		publishResponse.setSeoTags(publish.getSeoTags());
//		publishResponse.setSeoTitle(publish.getSeoTitle());
//		
//		return publishResponse;
//	}
	
}
