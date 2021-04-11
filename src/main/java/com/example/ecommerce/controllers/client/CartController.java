package com.example.ecommerce.controllers.client;

import com.example.ecommerce.entitys.Products;
import com.example.ecommerce.entitys.SkuDetails;
import com.example.ecommerce.services.CartItemsService;
import com.example.ecommerce.services.CartService;
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
    @Autowired
    private CartService cartService;
    @Autowired
    private CartItemsService cartItemsService;
    @GetMapping("/addToCart")
    public String getAddToCart(@RequestParam("productId") Long id, Model model, HttpSession session){
        if(session.getAttribute("color")==null||session.getAttribute("size")==null)
            return "productdetail";
        else{
             String size = (String) session.getAttribute("size");
             String color = (String) session.getAttribute("color");
             Products product = productService.findById(id);
             SkuDetails skuDetail = skusService.getSkuDetail(product.getId(),size,color);
             cartItemsService.addToCart(skuDetail,cartService.findById(3L),1,skuDetail.getPrice()*1);
        }
        return "cart";
    }
}
