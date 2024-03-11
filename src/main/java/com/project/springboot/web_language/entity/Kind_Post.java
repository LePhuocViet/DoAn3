package com.project.springboot.web_language.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "linhvuc")
public class Kind_Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MALV")
    public int malv;
    @Column(name = "TENLV")
    public String tenlv;
    @Column(name = "MOTA")
    public String mota;

    @OneToMany(mappedBy = "malv",
            cascade = {CascadeType.PERSIST,CascadeType.MERGE,CascadeType.DETACH,CascadeType.REFRESH})
    public List<Post_Account> post_Accounts;

    public Kind_Post(int malv, String tenlv, String mota) {
        this.malv = malv;
        this.tenlv = tenlv;
        this.mota = mota;
    }

    public int getMalv() {
        return malv;
    }

    public void setMalv(int malv) {
        this.malv = malv;
    }

    public String getTenlv() {
        return tenlv;
    }

    public void setTenlv(String tenlv) {
        this.tenlv = tenlv;
    }

    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }

    public Kind_Post() {

    }



    @Override
    public String toString() {
        return "Kind_Post{" +
                "malv=" + malv +
                ", tenlv=" + tenlv +
                ", mota=" + mota +
                '}';
    }

    public List<Post_Account> getPost_Accounts() {
        return post_Accounts;
    }

    public void setPost_Accounts(List<Post_Account> post_Accounts) {
        this.post_Accounts = post_Accounts;
    }

    public void add(Post_Account post_account){
        if(post_Accounts == null){
            post_Accounts = new ArrayList<>();
        }
        post_Accounts.add(post_account);

        post_account.setMalv(this);
    }
}
