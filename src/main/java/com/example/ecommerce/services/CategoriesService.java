package com.example.ecommerce.services;

import com.example.ecommerce.entitys.Subcategories;
import com.example.ecommerce.forms.EditCategoryForm;
import com.example.ecommerce.entitys.Categories;
import com.example.ecommerce.repositories.CategoriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoriesService {
    @Autowired
    private CategoriesRepository categoriesRepository;
    @Transactional
    public List<Categories> getCategories(Pageable pageable){
        return categoriesRepository.getCategories(pageable);
    }
    @Transactional
    public Categories findBySlug(String categorySlug){
        return categoriesRepository.findBySlug(categorySlug);
    }
    @Transactional
    public Categories findById(Long id){
        return categoriesRepository.findById(id).get();
    }
    @Transactional
    public void deleteById(Long id){
        categoriesRepository.deleteById(id);
    }
    @Transactional
    public int getTotalCategories(){
        return categoriesRepository.getTotalCategories();
    }
    @Transactional
    public void editCategoryById(Long id,String name,int sorting){
        String slug = name.toLowerCase().replace(" ","-");
        Categories category = categoriesRepository.findById(id).get();
        category.setName(name);
        category.setSlug(slug);
        category.setSorting(sorting);
        categoriesRepository.save(category);
    }
    @Transactional
    public EditCategoryForm getEditCategoryFormById(Long id){
        Categories category = findById(id);
        EditCategoryForm editCategoryForm = new EditCategoryForm(id,category.getName(),category.getSorting());
        return editCategoryForm;
    }
    @Transactional
    public void addCategory(String name, int sorting){
        String slug = name.toLowerCase().replace(" ", "-");
        categoriesRepository.save(new Categories(name, slug,sorting, new ArrayList<Subcategories>()));
    }
}
