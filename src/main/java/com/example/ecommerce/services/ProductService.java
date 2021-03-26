package com.example.ecommerce.services;

import com.example.ecommerce.entitys.Products;
import com.example.ecommerce.entitys.Subcategories;
import com.example.ecommerce.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;
    @Transactional
    public List<Products> findAll(){
        return productRepository.findAll();
    }
    @Transactional
    public void addProduct(String name, String description, Integer quantity, Float price, String image, Subcategories subcategoryid, String filename){
        productRepository.save(new Products(name,description,quantity,price,image));
    }

}
