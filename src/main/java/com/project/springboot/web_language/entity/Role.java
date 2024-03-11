package com.project.springboot.web_language.entity;

import jakarta.persistence.*;

import java.util.ArrayList;

@Entity
@Table(name = "phanquyen")
public class Role {

    @Id
    @ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.MERGE,CascadeType.DETACH,CascadeType.REFRESH})
    @JoinColumn(name = "MATK")
    public User user2;

    @Column(name = "TENPHANQUYEN")
    public String tenphanquyen;

    public Role(User user2, String tenphanquyen) {
        this.user2 = user2;
        this.tenphanquyen = tenphanquyen;
    }
    public Role() {

    }

    public User getUser() {
        return user2;
    }

    public void setUser(User user) {
        this.user2 = user2;
    }

    public String getTenphanquyen() {
        return tenphanquyen;
    }

    public void setTenphanquyen(String tenphanquyen) {
        this.tenphanquyen = tenphanquyen;
    }

    @Override
    public String toString() {
        return "Role{" +
                "user=" + user2 +
                ", tenphanquyen='" + tenphanquyen + '\'' +
                '}';
    }

}
