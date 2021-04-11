package com.example.ecommerce.controllers.admin;

import com.example.ecommerce.forms.AddProductDetailForm;
import com.example.ecommerce.forms.EditProductForm;
import com.example.ecommerce.repositories.ProductAttributeValueRepository;
import com.example.ecommerce.services.ProductAttributeValueService;
import com.example.ecommerce.services.SkuDetailService;
import com.example.ecommerce.services.SkusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Controller
public class ProductDetailController {
    @Autowired
    private SkuDetailService skuDetailService;
    @Autowired
    private SkusService skusService;
    @Autowired
    private ProductAttributeValueService productAttributeValueService;
    @GetMapping("cms/product/detail/{id}")
    public String getCMSProductDetail(@PathVariable("id") Long id, Model model){
        model.addAttribute("productId",id);
        model.addAttribute("productDetails",skuDetailService.getProductDetails(id,skuDetailService.getSkuDetailsByProductId(id)));
        return "cms/product_detail";
    }
    @GetMapping("cms/addskudetail")
    public String getAddSkuDetail(final Model model,@RequestParam(name = "productId",required = false) Long productId){
        model.addAttribute("sizes",productAttributeValueService.getSkuSizesByProductId(productId));
        model.addAttribute("colors",productAttributeValueService.getSkuColorsByProductId(productId));
        model.addAttribute("productId",productId);
        model.addAttribute("addProductDetailForm", new AddProductDetailForm());
        return "cms/addskudetail";
    }
    @PostMapping("cms/addskudetail")
    public String postAddSkuDetail(Model model,@Valid @ModelAttribute("addProductDetailForm") AddProductDetailForm addProductDetailForm,BindingResult bindingResult, @RequestParam("imageSkuDetail") MultipartFile imageSkuDetail,@RequestParam(name = "productId",required = false) Long productId) throws IOException {
        if(bindingResult.hasErrors()){
            return "cms/addskudetail";
        }
        if(skuDetailService.getSkus(productId,addProductDetailForm.getSizeId(),addProductDetailForm.getColorId()).size()==2){
            return "redirect:/cms/addskudetail";
        } else {
           /* String filename = imageSkuDetail.getOriginalFilename();
            Path imagePath = Paths.get("src/main/resources/static/admin/img/" + filename);
            Files.write(imagePath, imageSkuDetail.getBytes());*/

        }
        return "redirect:/cms/product_detail";
    }
}
