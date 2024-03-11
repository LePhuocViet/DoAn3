package com.project.springboot.web_language.reposity.Implement;

import com.project.springboot.web_language.entity.Account;
import com.project.springboot.web_language.reposity.AccountDao;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AccountDaoImple implements AccountDao {

    EntityManager entityManager;
    @Autowired
    public AccountDaoImple(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Account> findAll() {
        TypedQuery<Account> typedQuery = entityManager.createQuery("From Account",Account.class);
        return typedQuery.getResultList();
    }

    @Override
    public Account findAccountByUser(String name) {
        TypedQuery<Account> typedQuery = entityManager.createQuery(
                "SELECT a FROM Account a "
                + "JOIN FETCH a.user "
                + "WHERE a.user.matk = :theData",Account.class);
        typedQuery.setParameter("theData",name);
        Account account = typedQuery.getSingleResult();
        return account;
    }

    @Override
    @Transactional
    public void save(Account account) {
         entityManager.persist(account);
    }


}
