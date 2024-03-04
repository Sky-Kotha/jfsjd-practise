package com.example.jpademo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.example.jpademo.Entities.User;
import com.example.jpademo.Repository.UserRepository;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public Iterable<User> getAllDetails() {
        return userRepository.findAll();
    }

    public User addUser(User user) {
        return userRepository.save(user);
    }

    public void updateUser(User user) {
        userRepository.save(user);
    }

    public void deletUser(Integer id) {
        userRepository.deleteById(id);
    }

    public void updateNameById(Integer id, String name) {
        userRepository.findById(id).get().setName(name);
        ;
    }
}
