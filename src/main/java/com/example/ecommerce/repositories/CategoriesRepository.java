package com.example.ecommerce.repositories;

import com.example.ecommerce.entitys.Categories;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface CategoriesRepository extends JpaRepository<Categories,Long> {
    Categories findBySlug(String categorySlug);
    @Query("SELECT c FROM Categories c ")
    List<Categories> getCategories(Pageable pageable);
    @Query("SELECT count (c) FROM Categories c")
   int getTotalCategories();
}
