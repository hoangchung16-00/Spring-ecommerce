package com.example.ecommerce.repositories;

import com.example.ecommerce.entitys.ProductAttributeValues;
import com.example.ecommerce.entitys.Skus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductAttributeValueRepository extends JpaRepository<ProductAttributeValues, Long> {

    @Query("Select pav from ProductAttributeValues pav where pav.productAttribute.product.id=?1 and pav.productAttribute.name=?2")
    List<ProductAttributeValues> getSkuSizesByProductId(Long productId, String size);
    @Query("Select pav from ProductAttributeValues pav where pav.productAttribute.product.id=?1 and pav.productAttribute.name=?2")
    List<ProductAttributeValues> getSkuColorsByProductId(Long productId, String color);
    @Query("select pav from SkuDetails sd,Skus s,ProductAttributeValues pav where s.productAttributeValue.id=pav.id and sd.id=?1 and s.skuDetail.id=sd.id and s.productAttributeValue.productAttribute.name=?2 and sd.product.id=?3")
    ProductAttributeValues getSkuSize(Long skuDetailId,String size,Long productId);
    @Query("select pav from SkuDetails sd,Skus s,ProductAttributeValues pav where s.productAttributeValue.id=pav.id and sd.id=?1 and s.skuDetail.id=sd.id and s.productAttributeValue.productAttribute.name=?2 and sd.product.id=?3")
    ProductAttributeValues getSkuColor(Long skuDetailId,String color,Long productId);
    @Query("select pav from Skus s,ProductAttributeValues pav where s.productAttributeValue.id=pav.id and s.skuDetail.product.id=?1 and s.productAttributeValue.productAttribute.name=?2 and s.productAttributeValue.id=?3")
    ProductAttributeValues getColorByProductId(Long productId,String color,Long colorId);
    @Query("select pav from Skus s,ProductAttributeValues pav where s.productAttributeValue.id=pav.id and s.skuDetail.product.id=?1 and s.productAttributeValue.productAttribute.name=?2 and s.productAttributeValue.id=?3")
    ProductAttributeValues getSizeByProductId(Long productId,String size,Long sizeId);

}
