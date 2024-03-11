package com.project.springboot.web_language.service.Implement;

import com.project.springboot.web_language.entity.Kind_Post;
import com.project.springboot.web_language.reposity.Kind_PostReposity;
import com.project.springboot.web_language.service.Kind_PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Kind_PostServiceImplement implements Kind_PostService {

    Kind_PostReposity kindPostReposity;
    @Autowired
    public Kind_PostServiceImplement(Kind_PostReposity kindPostReposity) {
        this.kindPostReposity = kindPostReposity;
    }

    @Override
    public List<Kind_Post> findAll() {
        return kindPostReposity.findAll();
    }
}
