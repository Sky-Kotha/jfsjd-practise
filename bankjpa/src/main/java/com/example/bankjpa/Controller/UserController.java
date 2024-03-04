package com.example.bankjpa.Controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.bankjpa.Entities.User;
import com.example.bankjpa.Service.UserService;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/users")
    public Iterable<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/users/{id}")
    public Optional<User> getUserById(@PathVariable Integer id) {
        return userService.getUserById(id);
    }

    @PostMapping("/users")
    public void addUser(@RequestBody User user) {
        userService.addUser(user);
    }

    @PutMapping("/user/{id}")
    public void updateUser(@PathVariable Integer id, @RequestBody User user) {
        userService.updateUser(user);
    }

    @DeleteMapping("/user/{id}")
    public void deleteUser(@PathVariable Integer id) {
        userService.deleteUser(id);
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(User user) {
        Iterable<User> users = userService.getAllUsers();
        for (User u : users) {
            if (u.getEmail().equals(user.getEmail())) {
                if (u.getPassword().equals(user.getPassword())) {
                    return ResponseEntity.ok("Login successful. Here's your token.");
                } else {
                    signup(user);
                    return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("UserEmail doesn't exist,sign up");

                }
            }
        }
        // If login fails
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
    }

    @PostMapping("/signup")
    public ResponseEntity<String> signup(@RequestBody User user) {
        Iterable<User> users = userService.getAllUsers();
        for (User u : users) {
            if (u.getEmail().equals(user.getEmail())) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("UserEmail already exists, go for login");
            }
        }
        addUser(user);
        return ResponseEntity.ok("Sign up successful");
    }

}
