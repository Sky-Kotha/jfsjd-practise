package com.example.bankjpa2.Services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bankjpa2.Entities.Transaction;
import com.example.bankjpa2.Entities.User;
import com.example.bankjpa2.Repositories.TransactionRepository;

@Service
public class TransactionService {
    @Autowired
    TransactionRepository transactionRepository;

    public Iterable<Transaction> getAllTransactionsbyUserId(Integer userId) {
        return transactionRepository.findAllByUser_id(userId);
    }

    public void addTransaction(Transaction tr, Integer id) {
        tr.setUser(new User(id, "", "", ""));
        transactionRepository.save(tr);
    }

    public void updateTransaction(Transaction tr) {
        transactionRepository.save(tr);
    }

    public void deleteTransaction(Integer id) {
        transactionRepository.deleteById(id);
    }
}
