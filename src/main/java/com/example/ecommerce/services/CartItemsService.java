package com.example.ecommerce.services;

import com.example.ecommerce.entities.CartItems;
import com.example.ecommerce.entities.Carts;
import com.example.ecommerce.entities.SkuDetails;
import com.example.ecommerce.repositories.CartItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CartItemsService {
    @Autowired
    private CartItemRepository cartItemRepository;
    @Transactional
    public void addToCart(SkuDetails skuDetails, Carts carts, int quantity, double totalPrice){
        cartItemRepository.save(new CartItems(skuDetails,carts,quantity,totalPrice));
    }
}
