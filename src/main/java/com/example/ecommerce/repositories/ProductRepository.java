package com.example.ecommerce.repositories;

import com.example.ecommerce.entitys.Products;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Products, Long> {

}
