package com.example;

public class User {

    String name;

    String phonenumber;

    Float balance;

    public User(String name, String phonenumber, Float balance) {
        this.name = name;
        this.phonenumber = phonenumber;
        this.balance = balance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public Float getBalance() {
        return balance;
    }

    public void setBalance(Float balance) {
        this.balance = balance;
    }

}
