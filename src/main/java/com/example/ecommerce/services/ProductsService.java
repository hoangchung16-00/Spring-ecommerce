package com.example.ecommerce.services;

import com.example.ecommerce.entitys.Products;
import com.example.ecommerce.repositories.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductsService {
    @Autowired
    private ProductsRepository productsRepository;

    @Transactional
    public List<Products> getProductsBySubcategorySlugAndCategorySlug(String subCategorySlug,String categorySlug,Pageable pageable){
        return productsRepository.getProductsBySubcategorySlugAndCategorySlug(subCategorySlug,categorySlug,pageable);
    }
    @Transactional
    public List<Products> getProductsByCategorySlug(String categorySlug, Pageable pageable){
        return productsRepository.getProductsByCategorySlug(categorySlug,pageable);
    }
    @Transactional
    public List<Products> getProducts(){
        return productsRepository.findAll();
    }
    @Transactional
    public List<Products> findBySubCategoryId(Long id){
        return productsRepository.findAllBySubcategory_Id(id);
    }
    @Transactional
    public Products findById(Long id){
        return productsRepository.findById(id).get();
    }

}
