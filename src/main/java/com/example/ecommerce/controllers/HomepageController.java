package com.example.ecommerce.controllers;

import com.example.ecommerce.services.CategoriesService;
import com.example.ecommerce.services.SubcategoriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomepageController extends BaseController{
    @Autowired
    private CategoriesService categoriesService;
    @Autowired
    private SubcategoriesService subcategoriesService;
    @GetMapping("/")
    public String getHomepage(final Model model){
        return "index";
    }
}
