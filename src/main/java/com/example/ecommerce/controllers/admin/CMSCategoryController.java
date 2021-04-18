package com.example.ecommerce.controllers.admin;

import com.example.ecommerce.entities.Categories;
import com.example.ecommerce.forms.AddCategoryForm;
import com.example.ecommerce.forms.EditCategoryForm;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class CMSCategoryController extends BaseExtender{
    private static final int PAGE_SIZE=6;
    @GetMapping("cms/category")
    public String getCMSCategory(final Model model, @RequestParam(value = "page",defaultValue = "1") int page){
        Pageable pageable= PageRequest.of(page-1,PAGE_SIZE);
        model.addAttribute("categories",categoriesService.getCategories(pageable));
        model.addAttribute("pageSize",(categoriesService.getTotalCategories()/PAGE_SIZE)+1);
        return "cms/category";
    }
    @GetMapping("cms/deleteCategory/{id}")
    public String getDeleteCategory(@PathVariable("id") Long id){
        if(categoriesService.findById(id)==null || id == null){

        } else {
            categoriesService.deleteById(id);
        }
        return "redirect:/cms/category";
    }
    @GetMapping("cms/editcategory/{id}")
    public String getEditCategory(@PathVariable("id") Long id,final Model model){
        Categories category = categoriesService.findById(id);
        if(category==null){

        } else {
            model.addAttribute("editCategoryForm",categoriesService.getEditCategoryFormById(id));
        }
        return "cms/editcategory";
    }
    @PostMapping("cms/editcategory")
    public String postEditCategory(@Valid @ModelAttribute("editCategoryForm") EditCategoryForm editCategoryForm, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "cms/editcategory";
        }
        categoriesService.editCategoryById(editCategoryForm.getId(),editCategoryForm.getName(),editCategoryForm.getSorting());
        return "redirect:/cms/category";
    }
    @GetMapping("cms/addcategory")
    public String getAddCategory(final Model model){
        model.addAttribute("addCategoryForm",new AddCategoryForm());
        return "cms/addcategory";
    }
    @PostMapping("cms/addcategory")
    public String postAddCategory(@ModelAttribute("addCategoryForm") AddCategoryForm addCategoryForm){
        categoriesService.addCategory(addCategoryForm.getName(),addCategoryForm.getSorting());
        return "redirect:/cms/category";
    }
}
