package com.project.springboot.web_language.entity;


import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "taikhoan")
public class User {
    @Id
    @Column(name = "MATK")
    public String matk;

    @Column(name = "MATKHAU")
    public String matkhau;


    @Column(name = "active")
    public int active;

    @OneToMany(mappedBy = "user",
    cascade = {CascadeType.PERSIST,CascadeType.MERGE,CascadeType.DETACH,CascadeType.REFRESH})
    public List<Account> accounts;

    @OneToMany(mappedBy = "user2",
            cascade = {CascadeType.PERSIST,CascadeType.MERGE,CascadeType.DETACH,CascadeType.REFRESH})
    public List<Role> roles;

    public User(String matk, String matkhau, int active) {
        this.matk = matk;
        this.matkhau = matkhau;
        this.active = active;
    }

    public User() {

    }

    public String getMatk() {
        return matk;
    }

    public void setMatk(String matk) {
        this.matk = matk;
    }

    public String getMatkhau() {
        return matkhau;
    }

    public void setMatkhau(String matkhau) {
        this.matkhau = matkhau;
    }

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return "User{" +
                "matk='" + matk + '\'' +
                ", matkhau='" + matkhau + '\'' +
                ", active='" + active + '\'' +
                '}';
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public void add(Account account){
        if(accounts == null){
            accounts = new ArrayList<>();
        }
        accounts.add(account);

        account.setUser(this);
    }

    public void add(Role role){
        if(roles == null){
            roles = new ArrayList<>();
        }
        roles.add(role);

        role.setUser(this);
    }
}
