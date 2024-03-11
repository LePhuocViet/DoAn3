package com.project.springboot.web_language.controller;

import com.project.springboot.web_language.entity.*;
import com.project.springboot.web_language.service.AccountService;
import com.project.springboot.web_language.service.Kind_PostService;
import com.project.springboot.web_language.service.Post_AccountService;
import com.project.springboot.web_language.service.PostsService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class PostsController {

    PostsService postsService;

    Post_AccountService postAccountService;

    AccountService accountService;

    Kind_PostService kindPostService;

    public PostsController(PostsService postsService, Post_AccountService postAccountService, AccountService accountService, Kind_PostService kindPostService) {
        this.postsService = postsService;
        this.postAccountService = postAccountService;
        this.accountService = accountService;
        this.kindPostService = kindPostService;
    }

    @GetMapping("/Post")
    public String post(){
        return "posts";
    }

    @GetMapping("/Up_Post")
    public String uppost(Model model ){
        Posts posts = new Posts();
        model.addAttribute("posts",posts);
        return "posts_up";
    }
    @PostMapping("/Up_Post_Load")
    public String getup(@ModelAttribute("posts") Posts posts,@AuthenticationPrincipal UserDetails userDetails){
        String username = userDetails.getUsername();
        Account accounts = accountService.findAccountByUser(username);
        postsService.save(posts);
        List<Kind_Post> kind_post = kindPostService.findAll();
        Kind_Post kind_post1 = kind_post.get(0);
        Post_Account post_account = new Post_Account(0,posts,accounts,kind_post1);
        postAccountService.save(post_account);
        return "redirect:/Home";
    }
}
