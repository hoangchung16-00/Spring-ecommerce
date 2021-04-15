package com.example.ecommerce.services;

import com.example.ecommerce.entitys.*;
import com.example.ecommerce.model.ProductDetail;
import com.example.ecommerce.repositories.SkuDetailRepository;
import com.example.ecommerce.repositories.SkuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class SkuDetailService {
    @Autowired
    private SkuDetailRepository skuDetailRepository;
    @Autowired
    private ProductAttributeValueService productAttributeValueService;
    @Transactional
    public List<ProductDetail> getProductDetails(Long productId, List<SkuDetails> skuDetails){
        List<ProductDetail> productDetails = new ArrayList<>();
        for ( SkuDetails skuDetail : skuDetails) {
            productDetails.add(new ProductDetail(skuDetail.getId(),skuDetail.getSkucode(),productId,
                    productAttributeValueService.getSkuSize(skuDetail.getId(),productId).getValue(),
                    productAttributeValueService.getSkuColor(skuDetail.getId(),productId).getValue(),
                    skuDetail.getImage(),skuDetail.getPrice(),skuDetail.getQuantity()));
        }
        return productDetails;
    }
    @Transactional
    public List<SkuDetails> getSkuDetailsByProductId(Long productId){
        return skuDetailRepository.getSkuDetailsByProductId(productId);
    }

    @Transactional
    public void addSkuDetail(int quantity, String skucode, double price, String image, Products product){
        skuDetailRepository.save(new SkuDetails(quantity,skucode,price,image,product));
    }
    @Transactional
    public SkuDetails findBySkuCode(String skuCode){
        return skuDetailRepository.findSkuDetailsBySkucode(skuCode);
    }


}
