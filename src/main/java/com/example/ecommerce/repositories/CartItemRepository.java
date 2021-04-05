package com.example.ecommerce.repositories;

import com.example.ecommerce.entitys.CartItems;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartItemRepository extends JpaRepository<CartItems,Long> {
}
