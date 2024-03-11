package com.project.springboot.web_language.controller;


import com.project.springboot.web_language.entity.Posts;
import com.project.springboot.web_language.entity.User;
import com.project.springboot.web_language.service.PostsService;
import jakarta.servlet.http.HttpServletRequest;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;
import java.util.List;

@Controller

public class LanguageController {

    PostsService postsService;


    public LanguageController(PostsService postsService) {
        this.postsService = postsService;
    }

    @GetMapping("/Home")
    public String showHome(Model model, Authentication authentication) {
        boolean loggedIn = authentication != null && authentication.isAuthenticated();
        model.addAttribute("loggedIn", loggedIn);
        List<Posts> postslist = postsService.findAll();
        model.addAttribute("postslist",postslist);

        return "home";
    }

    @GetMapping("/")
    public String detailHome(){
        return "redirect:/Home";
    }
}
