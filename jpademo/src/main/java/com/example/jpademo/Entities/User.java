package com.example.jpademo.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    String name;

    String location;

    User() {

    }

    public User(Integer id, String name, String location) {
        this.id = id;
        this.name = name;
        this.location = location;
    }

    public User(String name, String location) {
        this.name = name;
        this.location = location;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "User [id=" + id + ", name=" + name + ", location=" + location + "]";
    }

}
// public record User(@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
// Integer id,
// String name,
// String location) {

// public User(String name, String location) {
// this(null, name, location);
// }

// public User() {
// //User();
// User(String name,String location);

// }

// }
