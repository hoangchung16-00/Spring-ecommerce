package com.example.ecommerce.controllers.client;

import com.example.ecommerce.entitys.Products;
import com.example.ecommerce.services.SkusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
public class CartController extends BaseExtender {
    @Autowired
    private SkusService skusService;
    @GetMapping("/addToCart")
    public String getAddToCart(@RequestParam("productId") Long id, Model model, HttpSession session){
        if(session.getAttribute("color")==null||session.getAttribute("size")==null)
            return "productdetail";
        else{
             Long sizeId = (Long) session.getAttribute("size");
             Long colorId = (Long) session.getAttribute("color");
             Products product = productService.findById(id);
             if(skusService.getCountSkus(id,sizeId,colorId)>0){

             }
        }
        return "cart";
    }
}
