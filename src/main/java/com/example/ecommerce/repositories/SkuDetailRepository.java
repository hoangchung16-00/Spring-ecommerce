package com.example.ecommerce.repositories;

import com.example.ecommerce.entitys.SkuDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface SkuDetailRepository extends JpaRepository<SkuDetails,Long> {
//    @Query("select sd from SkuDetails sd,Skus s where sd.product.id=?1 and sd.id=s.skuDetail.id and (s.productAttributeValue.id=?2 or s.productAttributeValue.id=?3)")
}
