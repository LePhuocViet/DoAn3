package com.project.springboot.web_language.reposity;


import com.project.springboot.web_language.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserReposity extends JpaRepository<User,String> {


}
