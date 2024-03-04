package com.example.bankjpa2.Repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.bankjpa2.Entities.Transaction;

@Repository
public interface TransactionRepository extends CrudRepository<Transaction, Integer> {

    Iterable<Transaction> findAllByUser_id(Integer userId);

}
