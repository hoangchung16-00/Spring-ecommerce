package com.example.ecommerce.repositories;

import com.example.ecommerce.entities.Skus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SkuRepository extends JpaRepository<Skus,Long> {
    @Query("select sd.skus from Skus s, SkuDetails sd where sd.product.id=?1 and sd.id = s.skuDetail.id and (s.productAttributeValue.value=?1 or s.productAttributeValue.value=?2)")
    List<Skus> getSkus(Long productId,String sizeId, String colorId);

}
