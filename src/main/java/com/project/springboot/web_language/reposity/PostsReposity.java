package com.project.springboot.web_language.reposity;

import com.project.springboot.web_language.entity.Posts;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostsReposity extends JpaRepository<Posts,Integer> {

}
