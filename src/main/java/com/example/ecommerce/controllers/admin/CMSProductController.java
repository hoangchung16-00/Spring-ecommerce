package com.example.ecommerce.controllers.admin;

import com.example.ecommerce.entitys.Products;
import com.example.ecommerce.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class CMSProductController {
    @Autowired
    private ProductService productService;
    @GetMapping("cms/product")
    public String getCMSProduct(Model model){
        List<Products> products = productService.findAll();
        model.addAttribute("products",products);
        return "cms/product";
    }
    @GetMapping("cms/editproduct/{id}")
    public String getCMSEditProduct(@PathVariable("id") Long id){

        return "redirect:/cms/product";
    }
}
