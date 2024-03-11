package com.project.springboot.web_language.service;

import com.project.springboot.web_language.entity.Account;

import java.util.List;

public interface AccountService {

    List<Account> findAll();

    Account findAccountByUser(String name);

    void save(Account account);

}
