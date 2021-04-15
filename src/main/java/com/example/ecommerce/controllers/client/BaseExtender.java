package com.example.ecommerce.controllers.client;

import com.example.ecommerce.entitys.Categories;
import com.example.ecommerce.entitys.Products;
import com.example.ecommerce.entitys.Subcategories;
import com.example.ecommerce.services.CategoriesService;
import com.example.ecommerce.services.ProductService;
import com.example.ecommerce.services.SubcategoriesService;
import com.mysql.cj.protocol.x.XProtocolDecoder;
import net.bytebuddy.asm.Advice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;

public class BaseExtender {
    @Autowired
    protected CategoriesService categoriesService;
    @Autowired
    protected SubcategoriesService subcategoriesService;
    @Autowired
    protected ProductService productService;
    @ModelAttribute("categories")
    public List<Categories> getCategory(){
        return categoriesService.findAll();
    }
    @ModelAttribute("subcategories")
    public List<Subcategories> getSubcategory(){
        return subcategoriesService.findAll();
    }
    public List<Products> getProduct(){
        return productService.findAll();
    }
}
