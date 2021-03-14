package com.example.ecommerce.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ProductDetailController extends BaseController{
    @GetMapping("/productdetail/{id}")
    public String getProductDetail(@PathVariable("id") Long id){

        return "productdetail";
    }
}
