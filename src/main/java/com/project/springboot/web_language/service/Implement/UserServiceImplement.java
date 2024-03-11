package com.project.springboot.web_language.service.Implement;


import com.project.springboot.web_language.reposity.UserReposity;
import com.project.springboot.web_language.entity.User;
import com.project.springboot.web_language.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImplement implements UserService {


    private UserReposity userReposity;
    @Autowired
    public UserServiceImplement(UserReposity userReposity) {
        this.userReposity = userReposity;
    }

    @Override
    public List<User> findAll() {
        return userReposity.findAll();
    }

    @Override
    public User save(User user) {
        return userReposity.save(user);
    }


}
