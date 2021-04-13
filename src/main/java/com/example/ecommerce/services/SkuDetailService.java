package com.example.ecommerce.services;

import com.example.ecommerce.entitys.CartItems;
import com.example.ecommerce.entitys.Products;
import com.example.ecommerce.entitys.SkuDetails;
import com.example.ecommerce.entitys.Skus;
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


    @Transactional
    public List<ProductDetail> getProductDetails(Long productId,List<SkuDetails> skuDetails){
        List<ProductDetail> productDetails = new ArrayList<ProductDetail>();
        for ( SkuDetails skuDetail : skuDetails) {
            productDetails.add(new ProductDetail(skuDetail.getId(),skuDetail.getSkucode(),productId,
                    getSkuSize(skuDetail.getId(),productId).getProductAttributeValue().getValue(),
                    getSkuColor(skuDetail.getId(),productId).getProductAttributeValue().getValue(),
                    skuDetail.getImage(),skuDetail.getPrice(),skuDetail.getQuantity()));
        }
        return productDetails;
    }
    @Transactional
    public List<SkuDetails> getSkuDetailsByProductId(Long productId){
        return skuDetailRepository.getSkuDetailsByProductId(productId);
    }
    @Transactional
    public Skus getSkuSize(Long skuDetailId,Long productId){
        return skuDetailRepository.getSkuSize(skuDetailId,"size",productId);
    }
    @Transactional
    public Skus getSkuColor(Long skuDetailId,Long productId){
        return skuDetailRepository.getSkuColor(skuDetailId,"color",productId);
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
