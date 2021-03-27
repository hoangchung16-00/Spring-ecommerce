package com.example.ecommerce.repositories;

import com.example.ecommerce.entitys.ProductAttributeValues;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductAttributeValueRepository extends JpaRepository<ProductAttributeValues, Long> {
    @Query("select pav from ProductValues pv, ProductAttributeValues pav, Products p " +
            "where pv.productAttributeValue.id = pav.id and pv.product.id = p.id and" +
            " pav.productAttribute.id = 1 and p.id = ?1")
    List<ProductAttributeValues> getProductAttributeSizeByProductId(Long id);
    @Query("select pav from ProductValues pv, ProductAttributeValues pav, Products p " +
            "where pv.productAttributeValue.id = pav.id and pv.product.id = p.id and" +
            " pav.productAttribute.id = 2 and p.id = ?1")
    List<ProductAttributeValues> getProductAttributeColorByProductId(Long id);
}
