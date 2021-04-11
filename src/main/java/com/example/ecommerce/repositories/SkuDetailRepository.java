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

    @Query("select s from SkuDetails sd,Skus s where sd.id=?1 and s.skuDetail.id=sd.id and s.productAttributeValue.productAttribute.name=?2 and sd.product.id=?3")
    Skus getSkuSize(Long skuDetailId,String size,Long productId);
    @Query("select s from SkuDetails sd,Skus s where sd.id=?1 and s.skuDetail.id=sd.id and s.productAttributeValue.productAttribute.name=?2 and sd.product.id=?3")
    Skus getSkuColor(Long skuDetailId,String color,Long productId);

    @Query("select sd.skus from SkuDetails sd,Skus s where sd.product.id=?1 and s.skuDetail.id=sd.id and (s.productAttributeValue.id=?1 or s.productAttributeValue.id=?2)")
    List<Skus> getSkus(Long productId,Long sizeId,Long colorId);
}
