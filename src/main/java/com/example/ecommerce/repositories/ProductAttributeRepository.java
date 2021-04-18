package com.example.ecommerce.repositories;

import com.example.ecommerce.entities.ProductAttributes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProductAttributeRepository extends JpaRepository<ProductAttributes,Long> {
    @Query("select pa from ProductAttributes pa where pa.product.id=?1 and pa.name='size'")
    ProductAttributes getSizeAttribute(Long id);
    @Query("select pa from ProductAttributes pa where pa.product.id=?1 and pa.name='color'")
    ProductAttributes getColorAttribute(Long id);
}
