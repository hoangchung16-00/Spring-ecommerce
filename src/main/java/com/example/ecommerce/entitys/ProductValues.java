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

    private int quantity;
    private Double price;
    private String image;

    public ProductValues() {
    }
    public ProductValues(Products product, ProductAttributeValues productAttributeValue, int quantity, Double price, String image) {
        this.product = product;
        this.productAttributeValue = productAttributeValue;
        this.quantity = quantity;
        this.price = price;
        this.image = image;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
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
