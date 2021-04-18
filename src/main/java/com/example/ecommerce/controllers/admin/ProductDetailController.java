package com.example.ecommerce.controllers.admin;

import com.example.ecommerce.forms.AddProductDetailForm;
import com.example.ecommerce.services.ProductAttributeValueService;
import com.example.ecommerce.services.ProductService;
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
    private ProductService productService;
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
        model.addAttribute("addProductDetailForm", new AddProductDetailForm());
        model.addAttribute("productId",productId);
        return "cms/addskudetail";
    }
    @PostMapping("cms/addskudetail/{productId}")
    public String postAddSkuDetail(Model model,@Valid @ModelAttribute("addProductDetailForm") AddProductDetailForm addProductDetailForm,
                                   BindingResult bindingResult, @RequestParam("imageSkuDetail") MultipartFile imageSkuDetail,
                                   @PathVariable("productId") Long productId) throws IOException {
        model.addAttribute("productId", productId);
        model.addAttribute("sizes",productAttributeValueService.getSkuSizesByProductId(productId));
        model.addAttribute("colors",productAttributeValueService.getSkuColorsByProductId(productId));
        if(bindingResult.hasErrors()){
            return "cms/addskudetail";
        }
        if(productAttributeValueService.getColorByProductId(productId,addProductDetailForm.getColorId())!=null
                &&productAttributeValueService.getSizeByProductId(productId,addProductDetailForm.getSizeId())!=null
                &&skuDetailService.checkSkuDetail(skuDetailService.findSkuDetailsByProductAndPAV(productId,productAttributeValueService.getSizeByProductId(productId,addProductDetailForm.getSizeId()).getId()),
                skuDetailService.findSkuDetailsByProductAndPAV(productId,productAttributeValueService.getColorByProductId(productId,addProductDetailForm.getColorId()).getId()))
                ){
            return "cms/addskudetail";
        } else {
            String filename = addProductDetailForm.getSkuCode()+imageSkuDetail.getOriginalFilename();
            Path imagePath = Paths.get("src/main/resources/static/admin/img/" + filename);
            Files.write(imagePath, imageSkuDetail.getBytes());
            skuDetailService.addSkuDetail(addProductDetailForm.getQuantity(),addProductDetailForm.getSkuCode(),addProductDetailForm.getPrice(),filename,productService.findById(productId));
            skusService.addSku(productAttributeValueService.findById(addProductDetailForm.getSizeId()),skuDetailService.findBySkuCode(addProductDetailForm.getSkuCode()));
            skusService.addSku(productAttributeValueService.findById(addProductDetailForm.getColorId()),skuDetailService.findBySkuCode(addProductDetailForm.getSkuCode()));
        }
        return "redirect:/cms/product/detail/"+productId;
    }
}
