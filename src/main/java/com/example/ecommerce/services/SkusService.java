package com.example.ecommerce.services;

import com.example.ecommerce.entitys.SkuDetails;
import com.example.ecommerce.entitys.Skus;
import com.example.ecommerce.repositories.SkuDetailRepository;
import com.example.ecommerce.repositories.SkuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SkusService {
    @Autowired
    private SkuRepository skuRepository;
    @Autowired
    private SkuDetailRepository skuDetailRepository;
    @Transactional
    public int getCountSkus(Long productId, String sizeId, String colorId){
        return skuRepository.getCountSkus(productId,sizeId,colorId);
    }
    @Transactional
    public SkuDetails getSkuDetail(Long productId,String sizeId, String colorId){
        return skuDetailRepository.getsd(productId,
                skuRepository.getSkus(productId,sizeId,colorId).size());
    }
    @Transactional
    public List<Skus> getSkus(Long productId,String size,String color){
        return skuRepository.getSkus(productId,size,color);
    }
    @Transactional
    public Skus getSkuSize(Long skuDetailId){
        return skuRepository.getSkuSize(skuDetailId,"size");
    }
    @Transactional
    public Skus getSkuColor(Long skuDetailId){
        return skuRepository.getSkuColor(skuDetailId,"color");
    }

}
