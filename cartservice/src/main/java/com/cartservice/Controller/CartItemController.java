package com.cartservice.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cartservice.Model.CartItem;
import com.cartservice.Service.CartItemService;

@RestController
public class ServiceController {

    @Autowired
    private CartItemService cartService;

    @PostMapping("/service")
    public CartItem addToCart(@PathVariable int productId,
            @PathVariable int quantity) {
        return cartService.addItemToCart(productId, quantity);
    }

    @GetMapping("/service")
    public List<CartItem> getAllItems() {
        return cartService.getAllItems();
    }

}
