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
import java.util.ArrayList;
import java.util.List;

@Controller

public class LanguageController {

    PostsService postsService;


    public LanguageController(PostsService postsService) {
        this.postsService = postsService;
    }

    @GetMapping("/Home")
    public String showHome(Model model, Authentication authentication,HttpServletRequest httpServletRequest, Principal principal) {
        String search = httpServletRequest.getParameter("search");
        boolean loggedIn = authentication != null && authentication.isAuthenticated();
        boolean notnull = principal == null;
        model.addAttribute("loggedIn", loggedIn);
        if(search != null && !search.isEmpty()){
            List<Posts> posts = postsService.findAll();
            List<Posts> postsList2 = new ArrayList<>();
            for(int i = 0 ; i < posts.size();i++){
                if(posts.get(i).getTieude().contains(search)){
                    postsList2.add(posts.get(i));
                }
            }
            model.addAttribute("notnull", notnull);
            model.addAttribute("searchpost",postsList2);
        } else {
            List<Posts> postslist = postsService.findAll();
            model.addAttribute("postslist",postslist);
        }
        return "home";

    }

    @GetMapping("/")
    public String detailHome(){
        return "redirect:/Home";
    }


}
