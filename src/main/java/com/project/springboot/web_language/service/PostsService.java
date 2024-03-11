package com.project.springboot.web_language.service;

import com.project.springboot.web_language.entity.Posts;

import java.util.List;

public interface PostsService {

    List<Posts> findAll();

    Posts save(Posts posts);

}
