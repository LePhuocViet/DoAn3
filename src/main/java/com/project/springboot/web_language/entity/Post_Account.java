package com.project.springboot.web_language.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "baiviet_nd")
public class Post_Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MABN")
    public int mabn;

    @ManyToOne(  cascade = {CascadeType.PERSIST,CascadeType.MERGE,CascadeType.DETACH,CascadeType.REFRESH})
    @JoinColumn(name = "MABV")
    public Posts mabv;

    @ManyToOne(  cascade = {CascadeType.PERSIST,CascadeType.MERGE,CascadeType.DETACH,CascadeType.REFRESH})
    @JoinColumn(name = "MAND")
    public Account account;

    @ManyToOne(  cascade = {CascadeType.PERSIST,CascadeType.MERGE,CascadeType.DETACH,CascadeType.REFRESH})
    @JoinColumn(name = "MALV")
    public Kind_Post malv;

    public Post_Account(int mabn, Posts mabv, Account account, Kind_Post malv) {
        this.mabn = mabn;
        this.mabv = mabv;
        this.account = account;
        this.malv = malv;
    }

    public Post_Account() {

    }

    public int getMabn() {
        return mabn;
    }

    public void setMabn(int mabn) {
        this.mabn = mabn;
    }

    public Posts getMabv() {
        return mabv;
    }

    public void setMabv(Posts mabv) {
        this.mabv = mabv;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Kind_Post getMalv() {
        return malv;
    }

    public void setMalv(Kind_Post malv) {
        this.malv = malv;
    }
}
