package com.example.ecommerce.repositories;

import com.example.ecommerce.entitys.Categories;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriesRepository extends JpaRepository<Categories,Long> {
    Categories findBySlug(String categorySlug);
}
