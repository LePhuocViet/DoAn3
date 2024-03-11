package com.project.springboot.web_language.controller;

import com.project.springboot.web_language.entity.Account;
import com.project.springboot.web_language.entity.Role;
import com.project.springboot.web_language.entity.User;
import com.project.springboot.web_language.service.AccountService;
import com.project.springboot.web_language.service.RoleService;
import com.project.springboot.web_language.service.UserService;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Objects;

@Controller
public class RegisterController {
    UserService userService;

    AccountService accountService;

    RoleService roleService;

    public RegisterController(UserService userService, AccountService accountService, RoleService roleService) {
        this.userService = userService;
        this.accountService = accountService;
        this.roleService = roleService;
    }

    @GetMapping("/Register")
    public String register1(Model model){
        User user = new User();
        model.addAttribute("newuser",user);
        return "/register";
    }

    @PostMapping("/Register_checkin")
    public String registercheckin(@ModelAttribute("newuser") User user , HttpServletRequest httpServletRequest, BindingResult bindingResult){
        String password = httpServletRequest.getParameter("rematkhau");

        String gmail = httpServletRequest.getParameter("email");
        if(user.getMatk().length()  <= 4){
            bindingResult.rejectValue("matk", "error.user", "Tài khoản phải lớn hơn 4 ký tự");
            return "register";
        } else if(user.getMatkhau().length() <= 8){
            bindingResult.rejectValue("matkhau", "error.user", "Mật khẩu phải lớn hơn 8 ký tự");
            return "register";
        }

        if(Objects.equals(user.getMatkhau(), password)){
            BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            String encodedPassword = passwordEncoder.encode(password);
            user.setMatkhau("{bcrypt}"+encodedPassword);
            user.setActive(1);
            Account account = new Account(0,"","",user,gmail);
            Role role = new Role(user,"ROLE_MEMBER");
            accountService.save(account);
            userService.save(user);
            roleService.save(role);
            return "redirect:/Login";
        }

        return "redirect:/register";

    }
}
