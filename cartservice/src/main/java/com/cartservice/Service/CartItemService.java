package com.cartservice.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.cartservice.Model.CartItem;
import com.cartservice.Repository.CartItemRepository;
import com.cartservice.dto.Product;

@Service
public class CartItemService {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private CartItemRepository service;

    public CartItem addTicketToCList(int productId, int quantity) {
        Product cust = getProductDetails(productId);
        // double total = product.price() * quantity;
        // CartItem item = new CartItem();
        // item.setPrice(total);
        // item.setProductId(productId);
        // item.setQuantity(quantity);
        // return cartRepo.save(item);

    }

    public List<CartItem> getAllCustomers() {
        return service.findAll();
    }

    private Customer getProductDetails(int productId) {
        Customer customer = restTemplate.getForObject("http://localhost:5100/customer/" + custId,
                Customer.class);

        return customer;

    }

}
