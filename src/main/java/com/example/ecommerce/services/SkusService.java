package com.example.ecommerce.services;

import com.example.ecommerce.entities.ProductAttributeValues;
import com.example.ecommerce.entities.SkuDetails;
import com.example.ecommerce.entities.Skus;
import com.example.ecommerce.repositories.SkuDetailRepository;
import com.example.ecommerce.repositories.SkuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SkusService {
    @Autowired
    private SkuRepository skuRepository;
    @Autowired
    private SkuDetailRepository skuDetailRepository;
    @Transactional
    public SkuDetails getSkuDetail(Long productId, String sizeId, String colorId){
        return skuDetailRepository.getsd(productId,
                skuRepository.getSkus(productId,sizeId,colorId).size());
    }

    @Transactional
    public void addSku(ProductAttributeValues productAttributeValue, SkuDetails skuDetail){
        skuRepository.save(new Skus(productAttributeValue,skuDetail));
    }
}
