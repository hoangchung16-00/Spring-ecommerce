package com.example.ecommerce.services;

import com.example.ecommerce.entitys.Subcategories;
import com.example.ecommerce.repositories.SubcategoriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SubcategoriesService {
    @Autowired
    private SubcategoriesRepository subcategoriesRepository;
    @Transactional
    public List<Subcategories> getSubcategories(){
        return subcategoriesRepository.findAll();
    }
    @Transactional
    public Subcategories findBySlug(String slug){
        return subcategoriesRepository.findBySlug(slug);
    }
}
