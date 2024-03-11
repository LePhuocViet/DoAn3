package com.project.springboot.web_language.service.Implement;

import com.project.springboot.web_language.reposity.PostsReposity;
import com.project.springboot.web_language.entity.Posts;
import com.project.springboot.web_language.service.PostsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PostsServiceImplement implements PostsService {

    PostsReposity postsReposity;
    @Autowired
    public PostsServiceImplement(PostsReposity postsReposity) {
        this.postsReposity = postsReposity;
    }

    @Override
    public List<Posts> findAll() {
        return postsReposity.findAll();
    }

    @Override
    public Posts save(Posts posts) {
        return postsReposity.save(posts);
    }
}
