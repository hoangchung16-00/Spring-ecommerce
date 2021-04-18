package com.example.ecommerce.services;

import com.example.ecommerce.entities.Carts;
import com.example.ecommerce.repositories.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
