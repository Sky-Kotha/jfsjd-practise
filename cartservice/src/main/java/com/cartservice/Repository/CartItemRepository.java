package com.cartservice.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cartservice.Model.CartItem;

public interface CartItemRepository extends JpaRepository<CartItem, Integer> {

}