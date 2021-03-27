package com.example.ecommerce.repositories;

import com.example.ecommerce.entitys.ProductAttributeValues;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductAttributeValueRepository extends JpaRepository<ProductAttributeValues, Long> {
    @Query("select pav from ProductAttributeValues pav,Products p left outer join fetch pav.products where p.id=?1")
    List<ProductAttributeValues> getProductAttributeSizeByProductId(Long id);
    @Query("select pa from Products p, ProductAttributeValues pa where p.id = pa.productAttribute.id and p.id = ?1 and pa.productAttribute.id =2")
    List<ProductAttributeValues> getProductAttributeColorByProductId(Long id);
}
