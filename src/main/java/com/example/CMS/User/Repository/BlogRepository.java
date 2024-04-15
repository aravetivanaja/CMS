package com.example.CMS.User.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.CMS.User.Model.Blog;
import com.example.CMS.User.Model.ContributionPanel;
import com.example.CMS.User.Model.User;

@Repository
public interface BlogRepository extends JpaRepository<Blog, Integer>{

	boolean existsByTitle(String title);
	boolean existsByUserAndPanel(User user, ContributionPanel panel);

}
