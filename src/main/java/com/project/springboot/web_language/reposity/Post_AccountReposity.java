package com.project.springboot.web_language.reposity;

import com.project.springboot.web_language.entity.Post_Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Post_AccountReposity extends JpaRepository<Post_Account,Integer> {
}
