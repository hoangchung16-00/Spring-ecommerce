package com.example.ecommerce.repositories;

import com.example.ecommerce.entitys.Products;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Products, Long> {
    @Query("select c from Products c")
    List<Products> getProducts(Pageable pageable);
    @Query("select count(c) from Products c")
    int getTotalProducts();


}
