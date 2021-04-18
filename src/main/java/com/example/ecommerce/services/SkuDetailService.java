package com.example.ecommerce.services;

import com.example.ecommerce.entities.Products;
import com.example.ecommerce.entities.SkuDetails;
import com.example.ecommerce.model.ProductDetail;
import com.example.ecommerce.repositories.SkuDetailRepository;
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

    @Transactional
    public SkuDetails getSkuDetailByProductId(Long productId, Long sizeId, Long colorId){
        return skuDetailRepository.getSkuDetailByProductId(productId,sizeId,colorId);
    }
    @Transactional
    public List<SkuDetails> findSkuDetailsByProductAndPAV(Long productId,Long PAVId){
        return skuDetailRepository.findSkuDetailsByProductAndPAV(productId,PAVId);
    }
    @Transactional
    public Boolean checkSkuDetail(List<SkuDetails> sizes,List<SkuDetails> colors){
        for(SkuDetails size : sizes){
            for(SkuDetails color : colors){
                if(size.getId()==color.getId())
                    return true;
            }
        }
        return false;
    }
    @Transactional
    public SkuDetails getSkuDetailByColorAndSize(List<SkuDetails> sizes,List<SkuDetails> colors){
        for(SkuDetails size : sizes){
            for(SkuDetails color : colors){
                if(size.getId()==color.getId())
                    return size;
            }
        }
        return null;
    }
}
