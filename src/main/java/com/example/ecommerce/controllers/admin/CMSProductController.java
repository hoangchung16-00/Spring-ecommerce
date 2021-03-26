
package com.example.ecommerce.controllers.admin;

import com.example.ecommerce.entitys.Products;
import com.example.ecommerce.entitys.Subcategories;
import com.example.ecommerce.forms.AddProductForm;
import com.example.ecommerce.services.ProductService;
import com.example.ecommerce.services.SubcategoriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.ManyToMany;
import javax.validation.Valid;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Controller
public class CMSProductController {
    @Autowired
    private ProductService productService;
    @Autowired
    private SubcategoriesService subcategoriesService;
    @GetMapping("cms/product")
    public String getCMSProduct(Model model){
        List<Products> products = productService.findAll();
        model.addAttribute("products",products);
        return "cms/product";
    }
    @GetMapping("cms/addproduct")
    public String getAddProduct(final Model model){
        List<Subcategories> subcategories = subcategoriesService.findAll();
        model.addAttribute("addProductForm",new AddProductForm());
        model.addAttribute("subcategories",subcategories);
        return "cms/addproduct";
    }
    @PostMapping("cms/addproduct")
    public String postAddProdut(@ModelAttribute("addProductForm")  AddProductForm addProductForm, BindingResult bindingResult,
                                @RequestParam("productImage")MultipartFile productImage, final Model model) throws IOException {
        if (bindingResult.hasErrors())  {
            return "cms/addproduct";
        }
        String filename = productImage.getOriginalFilename();
        if (!filename.contains(".jpg") && !filename.contains(".png")) {
            model.addAttribute("message", "Invalid image file");
            return "cms/addproduct";
        }

        Path imagePath = Paths.get("src/main/resources/static/images/" + filename);
        Files.write(imagePath, productImage.getBytes());
        productService.addProduct(addProductForm.getName(),addProductForm.getDescription(),addProductForm.getQuantity(),addProductForm.getPrice(),
                addProductForm.getImage(),subcategoriesService.findById(addProductForm.getSubcategoryid()),filename);
        return "cms/addproduct";
    }
    }

