package com.example.ecommerce.repositories;

import com.example.ecommerce.entitys.Subcategories;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface SubcategoriesRepository extends JpaRepository<Subcategories,Long> {

}
