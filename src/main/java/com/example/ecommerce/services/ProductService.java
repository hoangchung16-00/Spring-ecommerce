package com.example.ecommerce.services;

import com.example.ecommerce.entitys.Products;
import com.example.ecommerce.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;
    @Transactional
    public List<Products> findAll(){
        return productRepository.findAll();
    }
}
