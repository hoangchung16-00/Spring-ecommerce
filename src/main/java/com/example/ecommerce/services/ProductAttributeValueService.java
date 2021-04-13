package com.example.ecommerce.services;

import com.example.ecommerce.entitys.ProductAttributeValues;
import com.example.ecommerce.repositories.ProductAttributeValueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductAttributeValueService {
    @Autowired
    private ProductAttributeValueRepository productAttributeValueRepository;
    @Transactional
    public List<ProductAttributeValues> getSkuSizesByProductId(Long productId){
        return productAttributeValueRepository.getSkuSizesByProductId(productId,"size");
    }
    @Transactional
    public List<ProductAttributeValues> getSkuColorsByProductId(Long productId){
        return productAttributeValueRepository.getSkuColorsByProductId(productId,"color");
    }
    @Transactional
    public ProductAttributeValues findById(Long id){
        return productAttributeValueRepository.findById(id).get();
    }
}
