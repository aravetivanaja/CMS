package com.example.CMS.User.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.CMS.User.Enums.PostType;
import com.example.CMS.User.Model.BlogPost;
import com.example.CMS.User.Model.User;

public interface BlogPostRepository extends JpaRepository<BlogPost, Integer>{
	
	Optional<User> findBYIdByPostType(int postId, PostType published);
	
	List<BlogPost> findAllByPublishScheduleDateTimeLessThanEqualAndPostType(LocalDateTime now,
			PostType scheduled);
}
