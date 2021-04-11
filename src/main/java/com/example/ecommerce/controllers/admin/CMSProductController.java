package com.example.ecommerce.controllers.admin;

import com.example.ecommerce.entitys.Products;
import com.example.ecommerce.forms.AddProductForm;
import com.example.ecommerce.forms.EditProductForm;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;

@Controller
public class CMSProductController extends BaseExtender{

    public static final int PAGE_SIZE = 6;
    @GetMapping("cms/product")
    public String getCMSProduct(Model model, @RequestParam(value = "page", defaultValue = "1") int page){
        Pageable pageable= PageRequest.of(page-1,PAGE_SIZE);
        model.addAttribute("products",productService.getIndexProductPage(pageable));
        model.addAttribute("pageSize",(productService.getTotalProduct()/PAGE_SIZE)+1);
        return "cms/product";
    }
    @GetMapping("cms/addproduct")
    public String getAddProduct(Model model){
        model.addAttribute("addProductForm", new AddProductForm());
        return "cms/addproduct";
    }
    @PostMapping("cms/addproduct")
    public String postAddProduct(Model model, /*@RequestParam("imageProduct") MultipartFile imageProduct,*/ @Valid @ModelAttribute("addProductForm")AddProductForm addProductForm, BindingResult bindingResult) throws IOException {
        if (bindingResult.hasErrors()){

        }
//        String filename = imageProduct.getOriginalFilename();
//        Path imagePath = Paths.get("src/main/resources/static/admin/img/"+filename);
//        Files.write(imagePath,imageProduct.getBytes());
        productService.addProduct(addProductForm.getName(), addProductForm.getDescription(), subcategoriesService.findById(addProductForm.getSubcategoryid()));
        return "redirect:/cms/product";
    }
    @GetMapping("cms/editproduct/{id}")
    public String getCMSEditProduct(@PathVariable("id") Long id, Model model){
        Products products = productService.findById(id);
        model.addAttribute("editProductForm", new EditProductForm(products.getId(),products.getName(),products.getDescription(),products.getSubcategory().getId()));
        return "cms/editproduct";
    }
    @PostMapping("cms/editproduct")
    public String postCMSEditProduct(@Valid @ModelAttribute("editProductForm") EditProductForm editProductForm, BindingResult bindingResult) throws IOException {
        if (bindingResult.hasErrors()){

        }

        productService.editProduct(editProductForm.getId(),editProductForm.getName(), editProductForm.getDescription(), subcategoriesService.findById(editProductForm.getSubcategoryid()));
        return "redirect:/cms/product";
    }
    @GetMapping("cms/deleteproduct/{id}")
    public String getDeleteProduct(@PathVariable("id") Long id,Model model){
        productService.deleteProduct(id);
        return "redirect:/cms/product";
    }


}
