package com.project.springboot.web_language.reposity.Implement;

import com.project.springboot.web_language.entity.Role;
import com.project.springboot.web_language.reposity.RoleDao;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class RoleImplement implements RoleDao {

    EntityManager entityManager;
    @Autowired
    public RoleImplement(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(Role role) {
         entityManager.persist(role);
    }
}
