package com.example.ecommerce.services;

import com.example.ecommerce.entities.ProductAttributeValues;
import com.example.ecommerce.repositories.ProductAttributeValueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductAttributeValueService {
    @Autowired
    private ProductAttributeValueRepository productAttributeValueRepository;
    @Transactional
    public List<ProductAttributeValues> getSkuSizesByProductId(Long productId){
        return productAttributeValueRepository.getSkuSizesByProductId(productId,"size");
    }
    @Transactional
    public List<ProductAttributeValues> getSkuColorsByProductId(Long productId){
        return productAttributeValueRepository.getSkuColorsByProductId(productId,"color");
    }
    @Transactional
    public ProductAttributeValues findById(Long id){
        return productAttributeValueRepository.findById(id).get();
    }

    @Transactional
    public ProductAttributeValues getSkuSize(Long skuDetailId,Long productId){
        return productAttributeValueRepository.getSkuSize(skuDetailId,"size",productId);
    }
    @Transactional
    public ProductAttributeValues getSkuColor(Long skuDetailId,Long productId){
        return productAttributeValueRepository.getSkuColor(skuDetailId,"color",productId);
    }
    @Transactional
    public ProductAttributeValues getColorByProductId(Long productId, Long colorId){
        return productAttributeValueRepository.getColorByProductId(productId,"color",colorId);
    }
    @Transactional
    public ProductAttributeValues getSizeByProductId(Long productId,Long sizeId){
        return productAttributeValueRepository.getSizeByProductId(productId,"size",sizeId);
    }
}
