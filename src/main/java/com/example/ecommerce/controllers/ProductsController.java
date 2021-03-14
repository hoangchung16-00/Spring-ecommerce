package com.example.ecommerce.controllers;

import com.example.ecommerce.entitys.Products;
import com.example.ecommerce.services.CategoriesService;
import com.example.ecommerce.services.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

@Controller
public class ProductsController extends BaseController {
    private static final int PAGE_SIZE=10;
    @Autowired
    private CategoriesService categoriesService;
    @Autowired
    private ProductsService productsService;
    @GetMapping("/products/{categorySlug}/{subCategorySlug}")
    public String getProducts(@RequestParam(value = "page",required = false,defaultValue = "1") int page,@PathVariable("categorySlug") String categorySlug, @PathVariable("subCategorySlug") String subCategorySlug, final Model model){
        Pageable pageable = PageRequest.of(page-1,PAGE_SIZE);
        ArrayList<Products> products;

        if(subCategorySlug.equals("all")){
            products = (ArrayList<Products>) productsService.getProductsByCategorySlug(categorySlug,pageable);
            model.addAttribute("currentSubcategorySlug",subCategorySlug);
        } else {
            products = (ArrayList<Products>) productsService.getProductsBySubcategorySlugAndCategorySlug(subCategorySlug,categorySlug,pageable);
            model.addAttribute("currentSubcategorySlug",subcategoriesService.findBySlug(subCategorySlug).getSlug());
        }
        model.addAttribute("currentCategory",categoriesService.findBySlug(categorySlug));
        model.addAttribute("products",products);
        model.addAttribute("totalPage",products.size()/PAGE_SIZE +1);
        return "products";
    }
}
