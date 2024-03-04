package com.example.bankjpa2.Entities;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    String date;
    String category;
    float amount;

    @ManyToOne
    User user;

    public Transaction(String date, String category, float amount, Integer userId) {
        this.date = date;
        this.category = category;
        this.amount = amount;
        this.user = new User(userId, "", "", "");
    }

    public Transaction() {

    }

    // public Transaction(Date date2, String category2, float amount2, Integer
    // userId) {
    // // TODO Auto-generated constructor stub
    // this.date = date2;
    // this.category = category2;
    // this.amount = amount2;
    // this.user = new User(userId, "", "", "");
    // }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Transaction [id=" + id + ", date=" + date + ", category=" + category + ", amount=" + amount
                + ", userId=" + user + "]";
    }

}
