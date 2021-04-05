package com.example.ecommerce.repositories;

import com.example.ecommerce.entitys.Skus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface SkuRepository extends JpaRepository<Skus,Long> {
    @Query("select count(s) from Skus s,SkuDetails sd where sd.product.id=?1 and (s.productAttributeValue.id=?2 or s.productAttributeValue=?3)")
    int getCountSkus(Long productId,Long sizeId,Long colorId);
}
