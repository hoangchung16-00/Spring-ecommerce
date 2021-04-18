package com.example.ecommerce.repositories;

import com.example.ecommerce.entities.Carts;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Carts,Long> {

}
