package com.example.ecommerce.entitys;

import javax.persistence.*;
import java.io.Serializable;
import java.security.GeneralSecurityException;

@Entity
@Table(name = "productvalue")
public class ProductValues implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ManyToOne()
    @JoinColumn(name = "productid")
    private Products product;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ManyToOne()
    @JoinColumn(name = "productattributevalueid")
    private ProductAttributeValues productAttributeValue;

    public ProductValues(Products product, ProductAttributeValues productAttributeValue) {
        this.product = product;
        this.productAttributeValue = productAttributeValue;
    }

    public ProductValues() {
    }

    public Products getProduct() {
        return product;
    }

    public void setProduct(Products product) {
        this.product = product;
    }

    public ProductAttributeValues getProductAttributeValue() {
        return productAttributeValue;
    }

    public void setProductAttributeValue(ProductAttributeValues productAttributeValue) {
        this.productAttributeValue = productAttributeValue;
    }
}
