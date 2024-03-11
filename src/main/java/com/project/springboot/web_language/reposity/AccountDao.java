package com.project.springboot.web_language.reposity;

import com.project.springboot.web_language.entity.Account;

import java.util.List;


public interface AccountDao {

   List<Account> findAll();

   Account findAccountByUser(String name);

   void save(Account account);

}
