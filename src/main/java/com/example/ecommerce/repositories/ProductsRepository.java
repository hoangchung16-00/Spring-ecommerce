package com.example.ecommerce.repositories;

import com.example.ecommerce.entitys.Products;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductsRepository extends JpaRepository<Products,Long> {
    @Query("SELECT p FROM Products p,Subcategories sub WHERE p.subcategory.id=sub.id and sub.slug=?1")
    List<Products> getProductsBySubcategorySlug(String subCategorySlug);
    @Query("SELECT p FROM Products p,Subcategories sub,Categories c WHERE p.subcategory.id=sub.id and sub.category.id=c.id and sub.slug=?1 and c.slug=?2")
    List<Products> getProductsBySubcategorySlugAndCategorySlug(String subCategorySlug,String categorySlug,Pageable pageable);
    @Query("SELECT p FROM Products p,Subcategories sub,Categories c WHERE p.subcategory.id=sub.id and sub.category.id=c.id and c.slug=?1")
    List<Products> getProductsByCategorySlug(String categorySlug,Pageable pageable);
    List<Products> findAllBySubcategory_Id(Long id);
}
