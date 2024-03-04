package com.example.bankjpa2.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Wallet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer walletId;
    float balance;

    @OneToOne
    User user;

    public Wallet() {

    }

    public Wallet(float balance, Integer userId) {
        this.balance = balance;
        this.user = new User(userId, "", "", "");
    }

    public float getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Wallet [balance=" + balance + ", user=" + user + "]";
    }

}
