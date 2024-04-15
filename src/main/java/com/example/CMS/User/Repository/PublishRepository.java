package com.example.CMS.User.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.CMS.User.Model.Publish;

@Repository
public interface PublishRepository extends JpaRepository<Publish, Integer>{

}
