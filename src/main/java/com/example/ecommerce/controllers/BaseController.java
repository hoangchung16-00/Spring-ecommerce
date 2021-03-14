package com.example.ecommerce.controllers;

import com.example.ecommerce.entitys.Categories;
import com.example.ecommerce.entitys.Subcategories;
import com.example.ecommerce.services.CategoriesService;
import com.example.ecommerce.services.SubcategoriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;

public class BaseController {
    @Autowired
    protected CategoriesService categoriesService;
    @Autowired
    protected SubcategoriesService subcategoriesService;

    @ModelAttribute("categories")
    public List<Categories> getCategories(){
        return categoriesService.getCategories();
    }
}
