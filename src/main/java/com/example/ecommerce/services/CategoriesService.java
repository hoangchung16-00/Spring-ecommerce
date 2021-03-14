package com.example.ecommerce.services;

import com.example.ecommerce.entitys.Categories;
import com.example.ecommerce.repositories.CategoriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CategoriesService {
    @Autowired
    private CategoriesRepository categoriesRepository;
    @Transactional
    public List<Categories> getCategories(){
        return categoriesRepository.findAll();
    }
    @Transactional
    public Categories findBySlug(String categorySlug){
        return categoriesRepository.findBySlug(categorySlug);
    }
}
