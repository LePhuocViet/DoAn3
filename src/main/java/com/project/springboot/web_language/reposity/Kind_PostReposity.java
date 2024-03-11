package com.project.springboot.web_language.reposity;

import com.project.springboot.web_language.entity.Kind_Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Kind_PostReposity extends JpaRepository<Kind_Post,Integer> {
}
