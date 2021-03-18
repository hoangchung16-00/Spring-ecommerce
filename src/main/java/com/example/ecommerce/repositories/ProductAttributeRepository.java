package com.example.ecommerce.repositories;

import com.example.ecommerce.entitys.ProductAttributes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductAttributeRepository extends JpaRepository<ProductAttributes,Long> {
    @Query("select pa from ProductAttributes pa,ProductAttributeValues pav,Products p where pa.id=pav.productAttribute.id and p.id=?1")
    List<ProductAttributes> findByProductId(Long id);
}
