package com.project.springboot.web_language.service;

import com.project.springboot.web_language.entity.Post_Account;
import com.project.springboot.web_language.entity.Posts;

import java.util.List;

public interface Post_AccountService {

    List<Post_Account> findAll();

    Post_Account save(Post_Account post_account);
}
