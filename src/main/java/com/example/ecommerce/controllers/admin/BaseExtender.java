package com.example.ecommerce.controllers.admin;

import com.example.ecommerce.entities.Categories;
import com.example.ecommerce.entities.Products;
import com.example.ecommerce.entities.Subcategories;
import com.example.ecommerce.services.CategoriesService;
import com.example.ecommerce.services.ProductService;
import com.example.ecommerce.services.SubcategoriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;

public class BaseExtender {
    @Autowired
    protected ProductService productService;
    @Autowired
    protected SubcategoriesService subcategoriesService;
    @Autowired
    protected CategoriesService categoriesService;
    @ModelAttribute("categories")
    public List<Categories> getCategory(){
        return categoriesService.findAll();
    }
    @ModelAttribute("subcategories")
    public List<Subcategories> getSubCategory(){
        return subcategoriesService.findAll();
    }
    @ModelAttribute("products")
    public List<Products> getProduct(){
        return productService.findAll();
    }


}
