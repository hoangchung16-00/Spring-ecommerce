package com.example.ecommerce.repositories;

import com.example.ecommerce.entities.Products;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Products, Long> {
    @Query("select c from Products c")
    List<Products> getProducts(Pageable pageable);
    @Query("select count(c) from Products c")
    int getTotalProducts();
    @Query("select p from Products p, Subcategories s where p.subcategory.id = s.id and s.slug = ?1")
    List<Products> getProductsBySubCategorySlug(String slug, Pageable pageable);
    @Query("select count(p) from Products p, Subcategories s where p.subcategory.id = s.id and s.slug = ?1")
    int getTotalProductBySubCategorySlug(String slug);


}
