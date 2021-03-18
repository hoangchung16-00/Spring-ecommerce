package com.example.ecommerce.controllers;

import com.example.ecommerce.entitys.ProductAttributes;
import com.example.ecommerce.entitys.Products;
import com.example.ecommerce.services.ProductAttributeService;
import com.example.ecommerce.services.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.List;

@Controller
public class ProductDetailController extends BaseController{
    @Autowired
    private ProductsService productsService;
    @Autowired
    private ProductAttributeService productAttributeService;
    @GetMapping("/productdetail/{id}")
    public String getProductDetail(@PathVariable("id") Long id, Model model){
        Products product = productsService.findById(id);
        List<ProductAttributes> productAttributes = productAttributeService.findByProductId(id);
        model.addAttribute("product",product);
        model.addAttribute("productAttrbutes",productAttributes);
        return "productdetail";
    }
}
