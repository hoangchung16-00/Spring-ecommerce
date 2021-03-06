package com.example.ecommerce.repositories;

import com.example.ecommerce.entities.SkuDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SkuDetailRepository extends JpaRepository<SkuDetails,Long> {
    @Query("select sd from SkuDetails sd,Skus s where sd.product.id=?1 and sd.id = s.skuDetail.id and sd.skus.size =?2")
    SkuDetails getsd(Long productId,int listSize);

    @Query("select sd from SkuDetails sd, Skus s where sd.product.id = ?1 and sd.id = s.skuDetail.id and (s.productAttributeValue.id = ?2 or  s.productAttributeValue.id = ?3)")
    SkuDetails getSkuDetailByProductId(Long productId, Long size, Long color);

    @Query("select sd from SkuDetails sd where sd.product.id = ?1")
    List<SkuDetails> getSkuDetailsByProductId (Long id);

    SkuDetails findSkuDetailsBySkucode(String skuCode);

    @Query("select sd from SkuDetails sd,ProductAttributeValues pav, Skus s where sd.id=s.skuDetail.id and s.productAttributeValue.id=pav.id and sd.product.id=?1 and pav.id=?2")
    List<SkuDetails> findSkuDetailsByProductAndPAV(Long productId,Long PAVId);
}
