package com.project.springboot.web_language.service.Implement;

import com.project.springboot.web_language.entity.Role;
import com.project.springboot.web_language.reposity.RoleDao;
import com.project.springboot.web_language.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImplement implements RoleService {
    RoleDao roleDao;
    @Autowired
    public RoleServiceImplement(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    @Override
    public void save(Role role) {
        roleDao.save(role);
    }
}
