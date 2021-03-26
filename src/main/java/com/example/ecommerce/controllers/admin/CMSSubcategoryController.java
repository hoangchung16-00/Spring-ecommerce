package com.example.ecommerce.controllers.admin;

import com.example.ecommerce.entitys.Categories;
import com.example.ecommerce.entitys.Subcategories;
import com.example.ecommerce.forms.AddSubCategoryForm;
import com.example.ecommerce.forms.EditCategoryForm;
import com.example.ecommerce.forms.EditSubCategoryForm;
import com.example.ecommerce.services.CategoriesService;
import com.example.ecommerce.services.SubcategoriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
public class CMSSubcategoryController {
    @Autowired
    private CategoriesService categoriesService;
    @Autowired
    private SubcategoriesService subcategoriesService;
    @GetMapping("cms/subcategory")
    public String getCMSSubcategory(final Model model){
        model.addAttribute("subcategories",subcategoriesService.getSubcategories());
        return "cms/subcategory";
    }
    @GetMapping("cms/deletesubcategory/{id}")
    public String getDeleteSubcategory(@PathVariable("id") Long id, Model model){
        Subcategories subcategories = subcategoriesService.findById(id);
        if(subcategories.getProducts() == null || subcategories.getProducts().isEmpty())
            subcategoriesService.deleteSubcategory(id);
        else
            model.addAttribute("error","Không thể xóa vì Sub đang có Product");
        return "redirect:/cms/subcategory";
    }
    @GetMapping("cms/addsubcategory")
    public String getAddSubCategory(Model model){
        List<Categories> categories = categoriesService.findAll();
        model.addAttribute("categories",categories);
        model.addAttribute("addSubCategoryForm",new AddSubCategoryForm());
        return "cms/addsubcategory";
    }
    @PostMapping("cms/addsubcategory")
    public String postAddSubCategory(@ModelAttribute("addSubCategory") AddSubCategoryForm addSubCategoryForm,Model model){
        subcategoriesService.addSubCategory(addSubCategoryForm.getName(),addSubCategoryForm.getSorting(),
                categoriesService.findById(addSubCategoryForm.getCategoryid()));
        return "redirect:/cms/subcategory";
    }

    @GetMapping("cms/editsubcategory/{id}")
    public String getEditSubCategory(@PathVariable("id") Long id,final Model model){
        Subcategories subcategories = subcategoriesService.findById(id);
        model.addAttribute("categories", categoriesService.findAll());
        if(subcategories==null){

        } else {
            model.addAttribute("editSubCategoryForm",subcategoriesService.getEditSubcategoryFormById(id));
        }
        return "cms/editsubcategory";
    }
    @PostMapping("cms/editsubcategory")
    public String postEditSubCategory(@Valid @ModelAttribute("editSubCategoryForm") EditSubCategoryForm editSubCategoryForm, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "cms/editsubcategory";
        }
        subcategoriesService.editSubCategory(editSubCategoryForm.getId(),editSubCategoryForm.getName(),editSubCategoryForm.getSorting(),editSubCategoryForm.getCategoryid());
        return "redirect:/cms/subcategory";
    }
}
