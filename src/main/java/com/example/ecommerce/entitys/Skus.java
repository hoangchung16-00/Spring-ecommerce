package com.example.ecommerce.entitys;

import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;

@Entity
@Table(name = "sku")
public class Skus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    @JoinColumn(name = "productattributevalueid")
    private ProductAttributeValues productAttributeValue;

    @ManyToOne
    @JoinColumn(name = "skudetailid")
    private SkuDetails skuDetail;


    public Skus(ProductAttributeValues productAttributeValue, SkuDetails skuDetail) {
        this.productAttributeValue = productAttributeValue;
        this.skuDetail = skuDetail;
    }

    public Skus() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ProductAttributeValues getProductAttributeValue() {
        return productAttributeValue;
    }

    public void setProductAttributeValue(ProductAttributeValues productAttributeValue) {
        this.productAttributeValue = productAttributeValue;
    }

    public SkuDetails getSkuDetail() {
        return skuDetail;
    }

    public void setSkuDetail(SkuDetails skuDetail) {
        this.skuDetail = skuDetail;
    }
}
