package com.example.ecommerce.services;

import com.example.ecommerce.repositories.CartItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CartItemsService {
    @Autowired
    private CartItemRepository cartItemRepository;
    
}
