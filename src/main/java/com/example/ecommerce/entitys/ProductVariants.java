package com.example.ecommerce.entitys;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "product_variants")
public class ProductVariants {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @OneToOne
    @JoinColumn(name = "sku_id")
    private SKUs sku;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @OneToOne
    @JoinColumn(name = "product_attribute_value_id")
    private ProductAttributes productAttribute;

    @ManyToMany
    @JoinColumn(name = "product_attribute_value_id")
    private List<ProductAttributeValues> productAttributeValues;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Products product;

    public ProductVariants(SKUs sku, ProductAttributes productAttribute, List<ProductAttributeValues> productAttributeValues, Products product) {
        this.sku = sku;
        this.productAttribute = productAttribute;
        this.productAttributeValues = productAttributeValues;
        this.product = product;
    }

    public List<ProductAttributeValues> getProductAttributeValues() {
        return productAttributeValues;
    }

    public void setProductAttributeValues(List<ProductAttributeValues> productAttributeValues) {
        this.productAttributeValues = productAttributeValues;
    }

    public ProductVariants() {
    }



    public ProductAttributes getProductAttribute() {
        return productAttribute;
    }

    public void setProductAttribute(ProductAttributes productAttribute) {
        this.productAttribute = productAttribute;
    }



    public Products getProduct() {
        return product;
    }

    public void setProduct(Products product) {
        this.product = product;
    }

    public SKUs getSku() {
        return sku;
    }

    public void setSku(SKUs sku) {
        this.sku = sku;
    }
}
