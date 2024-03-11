package com.project.springboot.web_language.service;

import com.project.springboot.web_language.entity.Kind_Post;
import com.project.springboot.web_language.entity.Posts;

import java.util.List;

public interface Kind_PostService {

    List<Kind_Post> findAll();
}
