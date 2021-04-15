package com.example.ecommerce.repositories;

import com.example.ecommerce.entitys.Carts;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Carts,Long> {

}
