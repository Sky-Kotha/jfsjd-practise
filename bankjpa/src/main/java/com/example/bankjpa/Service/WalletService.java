package com.example.bankjpa.Service;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.bankjpa.Entities.Transaction;
import com.example.bankjpa.Entities.User;
import com.example.bankjpa.Entities.Wallet;
import com.example.bankjpa.Repository.TransactionRepository;
import com.example.bankjpa.Repository.WalletRepository;

@Service
public class WalletService {

    @Autowired
    WalletRepository walletRepository;

    @Autowired
    TransactionRepository transactionRepository;

    public float getBalance(Integer userId) {
        return walletRepository.findByUser_id(userId).get().getBalance();
    }

    public Optional<Wallet> getUserWallet(Integer userId) {
        return walletRepository.findByUser_id(userId);
    }

    public void addWallet(Integer userId) {
        walletRepository.save(new Wallet(0, userId));
    }

    public void deposit(Integer userId, float amount) {
        Optional<Wallet> wallet = getUserWallet(userId);
        if (wallet.isPresent()) {
            Wallet w = wallet.get();
            w.setBalance(wallet.get().getBalance() + amount);
            walletRepository.save(w);
            transactionRepository.save(new Transaction(new Date().toString(), "deposit", amount, userId));
        } else {
            throw new RuntimeException("Wallet not found for user with ID: " + userId);
        }

    }

    public ResponseEntity<String> withdraw(Integer userId, float amount) {
        Optional<Wallet> wallet = getUserWallet(userId);
        if (wallet.isPresent()) {
            Wallet w = wallet.get();
            if (w.getBalance() > amount) {
                w.setBalance(wallet.get().getBalance() - amount);
                walletRepository.save(w);
                transactionRepository.save(new Transaction(new Date().toString(), "withdraw", amount, userId));
                return ResponseEntity.ok("withdraw succesful");
            } else {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Your balance is low than amount");
            }
        } else {
            throw new RuntimeException("Wallet not found for user with ID: " + userId);
        }

    }

    public ResponseEntity<String> transfer(Integer fromuserId, Integer touserId, float amount) {
        Optional<Wallet> wallet1 = getUserWallet(fromuserId);
        Optional<Wallet> wallet2 = getUserWallet(touserId);
        if (wallet1.isPresent() && wallet2.isPresent()) {
            Wallet w1 = wallet1.get();
            Wallet w2 = wallet2.get();
            if (w1.getBalance() > amount) {
                w1.setBalance(w1.getBalance() - amount);
                w2.setBalance(w2.getBalance() + amount);

                walletRepository.save(w1);
                walletRepository.save(w2);
                transactionRepository.save(new Transaction(new Date().toString(),
                        "transfer from" + fromuserId + " to " + touserId, amount, fromuserId));
                return ResponseEntity.ok("transfer succesful");
            } else {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Your balance is low than amount");
            }
        } else {
            throw new RuntimeException("Wallet not found for user with ID: " + fromuserId + touserId);

        }

    }

}
