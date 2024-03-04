package com.example.bankjpa.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bankjpa.Entities.User;
import com.example.bankjpa.Entities.Wallet;
import com.example.bankjpa.Repository.UserRepository;
import com.example.bankjpa.Repository.WalletRepository;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    WalletRepository walletRepository;

    public Iterable<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> getUserById(Integer id) {
        return userRepository.findById(id);
    }

    public void addUser(User user) {
        userRepository.save(user);
        walletRepository.save(new Wallet(0, user.getId()));

    }

    public void updateUser(User user) {
        userRepository.save(user);
    }

    public void deleteUser(Integer id) {
        userRepository.deleteById(id);
    }

    // public Iterable<User> login() {
    // return userRepository.findAll();
    // }
}
