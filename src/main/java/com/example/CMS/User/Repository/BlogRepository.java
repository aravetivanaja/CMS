package com.example.CMS.User.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.CMS.User.Model.Blog;

public interface BlogRepository extends JpaRepository<Blog, Integer>{

	boolean existsByTitle(String title);

}
