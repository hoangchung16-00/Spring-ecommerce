package com.example.ecommerce.repositories;

import com.example.ecommerce.entitys.ProductAttributeValues;
import com.example.ecommerce.entitys.Skus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductAttributeValueRepository extends JpaRepository<ProductAttributeValues, Long> {
    @Query("select pav from ProductAttributes pa, ProductAttributeValues pav, Products p " +
            "where pa.product.id = p.id and pa.id = pav.productAttribute.id and pav.productAttribute.id  = 1 and p.id = ?1")
    List<ProductAttributeValues> getProductAttributeSizeByProductId(Long id);
    @Query("Select pav from ProductAttributeValues pav where pav.productAttribute.product.id=?1 and pav.productAttribute.name=?2")
    List<ProductAttributeValues> getSkuSizesByProductId(Long productId, String size);
    @Query("Select pav from ProductAttributeValues pav where pav.productAttribute.product.id=?1 and pav.productAttribute.name=?2")
    List<ProductAttributeValues> getSkuColorsByProductId(Long productId, String color);

}
