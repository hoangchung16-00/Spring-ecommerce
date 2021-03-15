package com.example.ecommerce.controllers;

import com.example.ecommerce.entitys.Products;
import com.example.ecommerce.services.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ProductDetailController extends BaseController{
    @Autowired
    private ProductsService productsService;
    @GetMapping("/productdetail/{id}")
    public String getProductDetail(@PathVariable("id") Long id, Model model){
        Products product = productsService.findById(id);
        model.addAttribute("product",product);
        return "productdetail";
    }
}
