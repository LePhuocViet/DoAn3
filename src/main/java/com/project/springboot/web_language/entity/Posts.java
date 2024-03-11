package com.project.springboot.web_language.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "baiviet")
public class Posts {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MABV")
    public int mabv;

    @Column(name = "NGAY")
    public Date ngay;

    @Column(name = "TIEUDE")
    public String tieude;

    @Column(name = "NOIDUNG")
    public String noidung;

    @OneToMany(mappedBy = "mabv",
            cascade = {CascadeType.PERSIST,CascadeType.MERGE,CascadeType.DETACH,CascadeType.REFRESH})
    public List<Post_Account> post_Accounts;

    public Posts(int mabv, Date ngay, String tieude, String noidung) {
        this.mabv = mabv;
        this.ngay = ngay;
        this.tieude = tieude;
        this.noidung = noidung;
    }

    public Posts() {

    }

    public int getMabv() {
        return mabv;
    }

    public void setMabv(int mabv) {
        this.mabv = mabv;
    }

    public Date getNgay() {
        return ngay;
    }

    public void setNgay(Date ngay) {
        this.ngay = ngay;
    }

    public String getTieude() {
        return tieude;
    }

    public void setTieude(String tieude) {
        this.tieude = tieude;
    }

    public String getNoidung() {
        return noidung;
    }

    public void setNoidung(String noidung) {
        this.noidung = noidung;
    }

    @Override
    public String toString() {
        return "Posts{" +
                "mabv=" + mabv +
                ", ngay=" + ngay +
                ", tieude='" + tieude + '\'' +
                ", noidung='" + noidung + '\'' +
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

        post_account.setMabv(this);
    }
}
