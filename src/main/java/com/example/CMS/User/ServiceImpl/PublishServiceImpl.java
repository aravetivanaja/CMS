package com.example.CMS.User.ServiceImpl;

import java.time.LocalDateTime;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.CMS.User.DTO.PublishRequest;
import com.example.CMS.User.DTO.ScheduleRequest;
import com.example.CMS.User.Enums.PostType;
import com.example.CMS.User.Exception.BlogPostNotFoundByIdException;
import com.example.CMS.User.Exception.UnAuthorizedException;
import com.example.CMS.User.Model.Publish;
import com.example.CMS.User.Repository.BlogPostRepository;
import com.example.CMS.User.Repository.ContributionPanelRepository;
import com.example.CMS.User.Repository.PublishRepository;
import com.example.CMS.User.Repository.ScheduleRepository;
import com.example.CMS.User.Repository.UserRepository;
import com.example.CMS.User.ResponseDTO.BlogPostResponse;
import com.example.CMS.User.ResponseDTO.PublishResponse;
import com.example.CMS.User.Service.PublishService;
import com.example.CMS.User.Utility.ResponseStructure;

@Service
public class PublishServiceImpl implements PublishService{
	
	private UserRepository ur;
	private ContributionPanelRepository cpr;
	private BlogPostRepository bpr;
	private PublishRepository pr;
	private ScheduleRepository sr;
	

	public PublishServiceImpl(UserRepository ur, ContributionPanelRepository cpr, BlogPostRepository bpr,
			PublishRepository pr, ScheduleRepository sr) {
		super();
		this.ur = ur;
		this.cpr = cpr;
		this.bpr = bpr;
		this.pr = pr;
		this.sr = sr;
	}

	@Override
	public ResponseEntity<ResponseStructure<BlogPostResponse>> unpublishBlogPost(int postId) {
		
		return null;
	}

	@Override
	public ResponseEntity<ResponseStructure<PublishResponse>> publishPost(int postId, PublishRequest publishReq) {
		
		String userName=SecurityContextHolder.getContext().getAuthentication().getName();
//		
return null;
		
	}
		
//		String userName=SecurityContextHolder.getContext().getAuthentication().getName();
//		
//			return ur.findByEmail(userName).map(user -> {
//				
//				return bpr.findById(postId).map(blogPost ->{
//					
//					Publish publish=null;
//					
//					if(!blogPost.getBlog().getUser().getEmail().equals(userName) && !cpr.existsByPanelIdAndContributors(blogPost.getBlog().getContributionPanel().getPanelId(), user))
//						throw new UnAuthorizedException("The user do not have access to modify the post");
//					
//					if(blogPost.getPublish()!=null)
//						
//						publish=mapToPublishRequest(publishReq,blogPost.getPublish());
//					else
//						publish=mapToPublishRequest(publishReq,new Publish());
//					
//					if(publishReq.getSchedule() !=null)
//					{
//						if(!ScheduleRequest.getDateTime().isAfter(LocalDateTime.now()))
//							throw new PublishTimeExpiredException("publish time already expired");
//						
//						publish.setSchedule(sr.save(mapToScheduleRequest(publishReq.getSchedule(),new schedule())));
//						blogPost.setPostType(PostType.SCHEDULED);
//					}
//					else 
//					{
//						blogPost.setPostType(PostType.PUBLISHED);
//					}
//					
//					publish.setBlogPost(blogPost);
//					pr.save(publish);
//					
//				}).orElseThrow(()-> new BlogPostNotFoundByIdException("blogpost is not found"));
//				
//		}).orElseThrow(()-> new UsernameNotFoundException("username not found"));
//	}
	
//	private Publish mapToPublishRequest(PublishRequest publishRequest,Publish publish)
//
//	{
//		publish.setSchedule(publishRequest.getSchedule());
//		publish.setSeoTags(publishRequest.getSeoTags());
//		publish.setSeoDescription(publishRequest.getSeoDescription());
//		publish.setSeoTitle(publishRequest.getSeoTitle());
//		return publish;
//	}
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
