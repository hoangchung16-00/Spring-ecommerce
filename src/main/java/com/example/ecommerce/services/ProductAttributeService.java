package com.example.ecommerce.services;

import com.example.ecommerce.entities.ProductAttributes;
import com.example.ecommerce.repositories.ProductAttributeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductAttributeService {
    @Autowired
    private ProductAttributeRepository productAttributeRepository;
    @Transactional
    public ProductAttributes getSizeAttribute(Long id){
        return productAttributeRepository.getSizeAttribute(id);
    }
    @Transactional
    public ProductAttributes getColorAttribute(Long id){
        return productAttributeRepository.getColorAttribute(id);
    }
}
