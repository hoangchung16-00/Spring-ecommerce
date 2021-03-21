package com.example.ecommerce.controllers.admin;

import com.example.ecommerce.services.SubcategoriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CMSSubcategoryController {
    @Autowired
    private SubcategoriesService subcategoriesService;
    @GetMapping("cms/subcategory")
    public String getCMSSubcategory(final Model model){
        model.addAttribute("subcategories",subcategoriesService.getSubcategories());
        return "cms/subcategory";
    }
}
