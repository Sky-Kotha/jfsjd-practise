package com.example.bankjpa.Controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.bankjpa.Entities.Wallet;
import com.example.bankjpa.Service.WalletService;

@RestController
public class WalletController {

    @Autowired
    WalletService walletService;

    @GetMapping("/bal/{userId}")
    public float getBalance(@PathVariable Integer userId) {
        return walletService.getBalance(userId);
    }

    @PostMapping("/wallet/{userId}")
    public void addWallet(@PathVariable Integer userId) {
        walletService.addWallet(userId);
    }

    @PostMapping("/deposit/{userId}")
    public void deposit(@PathVariable Integer userId, @RequestParam float amount) {
        // Optional<Wallet> wallet = walletService.getUserWallet(userId);
        // wallet.get().setBalance(wallet.get().getBalance() + amount);
        walletService.deposit(userId, amount);

    }

    @PostMapping("/withdraw/{userId}")
    public ResponseEntity<String> withdraw(@PathVariable Integer userId, @RequestParam float amount) {
        return walletService.withdraw(userId, amount);
    }

    @PostMapping("/transfer/{fromuserId}")
    public ResponseEntity<String> transfer(@PathVariable Integer fromuserId, @RequestParam Integer touserId,
            @RequestParam float amount) {
        return walletService.transfer(fromuserId, touserId, amount);
    }

}
