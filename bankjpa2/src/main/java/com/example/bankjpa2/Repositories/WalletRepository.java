package com.example.bankjpa2.Repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.bankjpa2.Entities.User;
import com.example.bankjpa2.Entities.Wallet;

@Repository
public interface WalletRepository extends CrudRepository<Wallet, Integer> {

    Optional<Wallet> findByUser_id(Integer userId);

    // Wallet findByBalance(Integer userId);

    // Wallet findAllById(Integer userId);

    // Iterable<Wallet> findAllByUser_id(Integer userId);

}
