package com.example.ecommerce.repositories;

import com.example.ecommerce.entitys.ProductAttributeValues;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductAttributeValueRepository extends JpaRepository<ProductAttributeValues, Long> {
    @Query("select pav from ProductAttributes pa, ProductAttributeValues pav, Products p " +
            "where pa.product.id = p.id and pa.id = pav.productAttribute.id and pav.productAttribute.id  = 1 and p.id = ?1")
    List<ProductAttributeValues> getProductAttributeSizeByProductId(Long id);
//    @Query("select pav from ProductValues pv, ProductAttributeValues pav, Products p " +
//            "where pv.productAttributeValue.id = pav.id and pv.product.id = p.id and" +
//            " pav.productAttribute.id = 2 and p.id = ?1")
//    List<ProductAttributeValues> getProductAttributeColorByProductId(Long id);
//    @Query("select sum(vl.quantity) from ProductValues vl where vl.product.id = ?1")
//    int getSumQuantity(Long id);
//    @Query("select sum(vl.quantity) from ProductValues vl where vl.product.id = ?1 and vl.productAttributeValue.id = ?2")
//    int getSumProductValueBySize(Long id, Long valueid);
}
