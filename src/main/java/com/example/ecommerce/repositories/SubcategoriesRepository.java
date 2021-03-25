package com.example.ecommerce.repositories;

import com.example.ecommerce.entitys.Categories;
import com.example.ecommerce.entitys.Subcategories;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SubcategoriesRepository extends JpaRepository<Subcategories,Long> {
    @Query("SELECT c FROM Subcategories c ")
    List<Subcategories> getSubcategories(Pageable pageable);
    @Query("SELECT count (c) FROM Categories c")
    int getTotalSubCategories();
}
