package com.example.ecommerce.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CartController extends BaseController{
    @GetMapping("/cart")
    public String getCart(){
        return "cart";
    }
    @GetMapping("/add_to_cart/{id}")
    public String getAddToCart(@PathVariable("id") Long id){
        return "cart";
    }
}
