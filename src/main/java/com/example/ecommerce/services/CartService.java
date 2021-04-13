package com.example.ecommerce.services;

import com.example.ecommerce.entitys.CartItems;
import com.example.ecommerce.entitys.Carts;
import com.example.ecommerce.entitys.SkuDetails;
import com.example.ecommerce.repositories.CartItemRepository;
import com.example.ecommerce.repositories.CartRepository;
import com.example.ecommerce.repositories.SkuDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.beans.Transient;

@Service
public class CartService {
    @Autowired
    private CartRepository cartRepository;

    @Transactional
    public Carts findById(Long cartId){
        return cartRepository.findById(cartId).get();
    }
    @Transactional
    public void updateCart(Carts carts,double total){
        carts.setTotal(total);
        cartRepository.save(carts);
    }
}
