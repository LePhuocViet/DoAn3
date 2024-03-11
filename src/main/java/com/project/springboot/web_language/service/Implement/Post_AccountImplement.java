package com.project.springboot.web_language.service.Implement;

import com.project.springboot.web_language.entity.Post_Account;
import com.project.springboot.web_language.reposity.Post_AccountReposity;
import com.project.springboot.web_language.service.Post_AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Post_AccountImplement implements Post_AccountService {
    Post_AccountReposity postAccountReposity;
    @Autowired
    public Post_AccountImplement(Post_AccountReposity postAccountReposity) {
        this.postAccountReposity = postAccountReposity;
    }

    @Override
    public List<Post_Account> findAll() {
        return postAccountReposity.findAll();
    }

    @Override
    public Post_Account save(Post_Account post_account) {
        return postAccountReposity.save(post_account);
    }
}
