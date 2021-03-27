package com.example.ecommerce.controllers.client;

import com.example.ecommerce.services.CategoriesService;
import com.fasterxml.jackson.databind.ser.Serializers;
import org.dom4j.rule.Mode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomepageController extends BaseExtender {
public static final int PAGE_SIZE = 2;
    @GetMapping("/")
    public String getHomepage(final Model model){
        return "index";
    }

    @GetMapping("/products/{categoryslug}/{subcategoryslug}")
    public String getListProduct(Model model, @PathVariable("subcategoryslug") String slug, @RequestParam(value = "page", defaultValue = "1") int page){
        Pageable pageable = PageRequest.of(page - 1, PAGE_SIZE);
        model.addAttribute("pagesize", (productService.getTotalProductBySubCategorySlug(slug)/PAGE_SIZE)+1);
        model.addAttribute("productsBySlug", productService.getProductBySubCategorySlug(slug, pageable));
        return "products";
    }
    @GetMapping("/productdetail/{id}")
    public String getProductDetail(@PathVariable("id") Long id, Model model){
        model.addAttribute("productAttributeSize", productService.getProductAttributeSizeByProductId(id));
        model.addAttribute("productAttributeColor",productService.getProductAttributeColorByProductId(id));
        model.addAttribute("productDetail", productService.findById(id));
        return "productdetail";
    }
}
