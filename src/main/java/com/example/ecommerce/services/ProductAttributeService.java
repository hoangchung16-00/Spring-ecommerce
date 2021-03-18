package com.example.ecommerce.services;

import com.example.ecommerce.entitys.ProductAttributes;
import com.example.ecommerce.repositories.ProductAttributeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class ProductAttributeService {
    @Autowired
    private ProductAttributeRepository productAttributeRepository;
    @Transactional
    public List<ProductAttributes> findByProductId(Long id){
        return productAttributeRepository.findByProductId(id);
    }
}
