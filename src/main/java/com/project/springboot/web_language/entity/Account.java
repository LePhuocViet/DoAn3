package com.project.springboot.web_language.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "nguoidung")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MAND")
    public int mand;

    @Column(name = "HOTEN")
    public String hoten;

    @Column(name = "GIOITINH")
    public String gioitinh;

    @ManyToOne(  cascade = {CascadeType.PERSIST,CascadeType.MERGE,CascadeType.DETACH,CascadeType.REFRESH})
    @JoinColumn(name = "MATK")
    public User user;

    @Column(name = "GMAIL")
    public String gmail;

    @OneToMany(mappedBy = "account",
            cascade = {CascadeType.PERSIST,CascadeType.MERGE,CascadeType.DETACH,CascadeType.REFRESH})
    public List<Post_Account> accounts;
    public Account(int mand, String hoten, String gioitinh, User user, String gmail) {
        this.mand = mand;
        this.hoten = hoten;
        this.gioitinh = gioitinh;
        this.user = user;
        this.gmail = gmail;
    }

    public Account() {

    }

    public int getMand() {
        return mand;
    }

    public void setMand(int mand) {
        this.mand = mand;
    }

    public String getHoten() {
        return hoten;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getGmail() {
        return gmail;
    }

    public void setGmail(String gmail) {
        this.gmail = gmail;
    }

    public String getGioitinh() {
        return gioitinh;
    }

    public void setGioitinh(String gioitinh) {
        this.gioitinh = gioitinh;
    }

    @Override
    public String toString() {
        return "Account{" +
                "mand=" + mand +
                ", hoten='" + hoten + '\'' +
                ", gioitinh='" + gioitinh + '\'' +
                ", gmail='" + gmail + '\'' +
                '}';
    }

    public List<Post_Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Post_Account> accounts) {
        this.accounts = accounts;
    }

    public void add(Post_Account post_account){
        if(accounts == null){
            accounts = new ArrayList<>();
        }
        accounts.add(post_account);

        post_account.setAccount(this);
    }
}
