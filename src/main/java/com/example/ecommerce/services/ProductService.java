package com.example.ecommerce.services;

import com.example.ecommerce.entitys.Products;
import com.example.ecommerce.entitys.Subcategories;
import com.example.ecommerce.forms.AddProductForm;
import com.example.ecommerce.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.net.PortUnreachableException;
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
    public void addProduct(String name, String image, Double price, int quantity, String description, Subcategories subcategories){
        productRepository.save(new Products(name, image,price,quantity, description, subcategories));
    }
    @Transactional
    public Products findById(Long id){
        return productRepository.findById(id).get();
    }
    @Transactional
    public void editProduct(Long id, String name, String image, Double price, int quantity, String description, Subcategories subcategories){
        Products products = productRepository.findById(id).get();
        products.setName(name);
        products.setDescription(description);
        products.setQuantity(quantity);
        products.setPrice(price);
        products.setImage(image);
        products.setSubcategory(subcategories);
        productRepository.save(products);
    }
    @Transactional
    public void deleteProduct(Long id){
        productRepository.deleteById(id);
    }
    @Transactional
    public List<Products> getIndexProductPage(Pageable pageable){
        return productRepository.getProducts(pageable);
    }
    @Transactional
    public int getTotalProduct(){
        return productRepository.getTotalProducts();
    }
}

