package com.example.ecommerce.services;

import com.example.ecommerce.entitys.ProductAttributeValues;
import com.example.ecommerce.entitys.Products;
import com.example.ecommerce.entitys.Subcategories;
import com.example.ecommerce.repositories.ProductAttributeValueRepository;
import com.example.ecommerce.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
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
    @Transactional
    public void addProduct(String name, String description, Subcategories subcategories){
        productRepository.save(new Products(name, description, subcategories));
    }
    @Transactional
    public Products findById(Long id){
        return productRepository.findById(id).get();
    }
    @Transactional
    public void editProduct(Long id, String name, String description, Subcategories subcategories){
        Products products = productRepository.findById(id).get();
        products.setName(name);
        products.setDescription(description);
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
    @Transactional
    public List<Products> getProductBySubCategorySlug(String slug, Pageable pageable){
        return productRepository.getProductsBySubCategorySlug(slug, pageable);
    }
    @Transactional
    public int getTotalProductBySubCategorySlug(String slug){
        return productRepository.getTotalProductBySubCategorySlug(slug);
    }

}

