package com.example.ecommerce.controllers.admin;

import com.example.ecommerce.entities.Categories;
import com.example.ecommerce.entities.Subcategories;
import com.example.ecommerce.forms.AddSubCategoryForm;
import com.example.ecommerce.forms.EditSubCategoryForm;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
public class CMSSubcategoryController extends BaseExtender {
    private static final int PAGE_SIZE=6;
    @GetMapping("cms/subcategory")
    public String getCMSSubcategory(final Model model, @RequestParam(value = "page", defaultValue = "1") int page){
        Pageable pageable= PageRequest.of(page-1,PAGE_SIZE);
        model.addAttribute("subcategories",subcategoriesService.getSubCategories(pageable));
        model.addAttribute("pageSize",(subcategoriesService.getTotalSubCategory()/PAGE_SIZE)+1);
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
