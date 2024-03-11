package com.project.springboot.web_language.service;



import com.project.springboot.web_language.entity.User;

import java.util.List;

public interface UserService {

    List<User> findAll();

    User save(User user);



}
