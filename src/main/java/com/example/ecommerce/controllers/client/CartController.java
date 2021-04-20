package com.example.ecommerce.controllers.client;

import com.example.ecommerce.entities.Products;
import com.example.ecommerce.entities.SkuDetails;
import com.example.ecommerce.services.CartItemsService;
import com.example.ecommerce.services.CartService;
import com.example.ecommerce.services.SkuDetailService;
import com.example.ecommerce.services.SkusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class CartController extends BaseExtender {
    @Autowired
    private SkusService skusService;
    @Autowired
    private CartService cartService;
    @Autowired
    private CartItemsService cartItemsService;
    @Autowired
    private SkuDetailService skuDetailService;

    @GetMapping("/addToCart")
    public String getAddToCart(@RequestParam("productId") Long id, Model model, HttpSession session){
        if(session.getAttribute("color")==null||session.getAttribute("size")==null)
            return "productdetail";
        else{
             Long sizeId = (Long) session.getAttribute("size");
             Long colorId = (Long) session.getAttribute("color");
             Products product = productService.findById(id);
             List<SkuDetails> sizes = skuDetailService.findSkuDetailsByProductAndPAV(id,sizeId);
             List<SkuDetails> colors = skuDetailService.findSkuDetailsByProductAndPAV(id,colorId);
             cartItemsService.addToCart(skuDetailService.getSkuDetailByColorAndSize(sizes,colors),cartService.findById(3L),3,skuDetailService.getSkuDetailByColorAndSize(sizes,colors).getPrice()*3);
        }
        return "cart";
    }
}
