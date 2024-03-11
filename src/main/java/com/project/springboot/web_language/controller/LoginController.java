package com.project.springboot.web_language.controller;

import com.project.springboot.web_language.entity.Posts;
import com.project.springboot.web_language.entity.User;
import com.project.springboot.web_language.service.PostsService;
import com.project.springboot.web_language.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@Controller

public class LoginController {

    UserService userService;
    PostsService postsService;


    public LoginController(UserService userService, PostsService postsService) {
        this.userService = userService;
        this.postsService = postsService;
    }

    @GetMapping("/Login")
    public String showLogin(Model model){

        return "login";
    }


}
