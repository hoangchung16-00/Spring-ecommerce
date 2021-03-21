package com.example.ecommerce.controllers.client;

import com.example.ecommerce.services.CategoriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomepageController {
    @Autowired
    private CategoriesService categoriesService;

    @GetMapping("/")
    public String getHomepage(final Model model){
        return "index";
    }
}
