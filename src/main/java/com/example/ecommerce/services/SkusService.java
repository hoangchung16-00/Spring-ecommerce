package com.example.ecommerce.services;

import com.example.ecommerce.repositories.SkuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SkusService {
    @Autowired
    private SkuRepository skuRepository;
    @Transactional
    public int getCountSkus(Long productId,Long sizeId,Long colorId){
        return skuRepository.getCountSkus(productId,sizeId,colorId);
    }
}
