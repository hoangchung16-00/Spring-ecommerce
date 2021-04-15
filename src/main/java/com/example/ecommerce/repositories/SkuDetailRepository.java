package com.example.ecommerce.repositories;

import com.example.ecommerce.entitys.SkuDetails;
import com.example.ecommerce.entitys.Skus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SkuDetailRepository extends JpaRepository<SkuDetails,Long> {
    @Query("select sd from SkuDetails sd,Skus s where sd.product.id=?1 and sd.id = s.skuDetail.id and sd.skus.size =?2")
    SkuDetails getsd(Long productId,int listSize);

    @Query("select sd from SkuDetails sd where sd.product.id = ?1")
    List<SkuDetails> getSkuDetailsByProductId (Long id);


    SkuDetails findSkuDetailsBySkucode(String skuCode);
}
