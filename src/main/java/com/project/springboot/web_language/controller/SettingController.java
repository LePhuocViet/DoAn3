package com.project.springboot.web_language.controller;

import com.project.springboot.web_language.entity.Account;
import com.project.springboot.web_language.entity.User;
import com.project.springboot.web_language.service.AccountService;
import com.project.springboot.web_language.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class SettingController {

    AccountService accountService;
    UserService userService;

    public SettingController(AccountService accountService, UserService userService) {
        this.accountService = accountService;
        this.userService = userService;
    }

    @PostMapping("/Setting")
    public String setting(@AuthenticationPrincipal UserDetails userDetails, Model model) {
        if (userDetails != null) {
            String username = userDetails.getUsername();
            model.addAttribute("setting_name", username);
            Account account = accountService.findAccountByUser(username);
            model.addAttribute("sendemail", account.getGmail());
            return "/setting";
        }
        return "redirect:/Home";
    }

}
