package com.example.bankjpa2.Controllers;

import org.aspectj.weaver.tools.Traceable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.bankjpa2.Entities.Transaction;
import com.example.bankjpa2.Services.TransactionService;
import com.example.bankjpa2.Services.UserService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class TransactionController {
    @Autowired
    TransactionService transactionService;

    @GetMapping("tr/{userId}")
    public Iterable<Transaction> getAllTransactionsbyUserId(@PathVariable Integer userId) {
        return transactionService.getAllTransactionsbyUserId(userId);
    }

    @PostMapping("tr/{userId}")
    public void addTransaction(@RequestBody Transaction tr, @PathVariable Integer userId) {
        transactionService.addTransaction(tr, userId);
    }

    @PutMapping("tr/{trId}")
    public void updateTransaction(@PathVariable Integer trId, @RequestBody Transaction tr) {
        transactionService.updateTransaction(tr);
    }

    @DeleteMapping("tr/{trId}")
    public void deleteTransaction(@PathVariable Integer trId) {
        transactionService.deleteTransaction(trId);
    }
}
