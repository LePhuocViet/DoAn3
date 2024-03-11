package com.project.springboot.web_language.service.Implement;

import com.project.springboot.web_language.reposity.AccountDao;
import com.project.springboot.web_language.entity.Account;
import com.project.springboot.web_language.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImplement implements AccountService {

    public AccountDao accountDao;
    @Autowired
    public AccountServiceImplement(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    @Override
    public List<Account> findAll() {
        return accountDao.findAll();
    }

    @Override
    public Account findAccountByUser(String name) {
        return accountDao.findAccountByUser(name);
    }

    @Override

    public void save(Account account) {
         accountDao.save(account);
    }
}
