package com.example.ecommerce.repositories;

import com.example.ecommerce.entitys.Skus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SkuRepository extends JpaRepository<Skus,Long> {
    @Query("select count(s) from Skus s,SkuDetails sd where sd.product.id=?1 and (s.productAttributeValue.value=?2 or s.productAttributeValue.value=?3)")
    int getCountSkus(Long productId,String sizeValue,String colorValue);
    @Query("select sd.skus from Skus s, SkuDetails sd where sd.product.id=?1 and sd.id = s.skuDetail.id and (s.productAttributeValue.value=?1 or s.productAttributeValue.value=?2)")
    List<Skus> getSkus(Long productId,String sizeId, String colorId);
    @Query("select s from Skus s where s.skuDetail.id=?1 and s.productAttributeValue.productAttribute.name=?2")
    Skus getSkuSize(Long skuDetailId,String size);
    @Query("select s from Skus s where s.skuDetail.id=?1 and s.productAttributeValue.productAttribute.name=?2")
    Skus getSkuColor(Long skuDetailId,String color);

}
