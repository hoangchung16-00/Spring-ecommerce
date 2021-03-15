package com.example.ecommerce.entitys;

import org.hibernate.annotations.Generated;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "product_attributes")
public class ProductAttributes {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String name;
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Products product;
    @OneToMany(mappedBy = "productAttribute")
    private List<ProductAttributeValues> productAttributeValues;
    @OneToOne(mappedBy = "productAttribute")
    private ProductVariants productVariant;
    public ProductAttributes() {
    }

    public ProductAttributes(String name, Products product, List<ProductAttributeValues> productAttributeValues) {
        this.name = name;
        this.product = product;
        this.productAttributeValues = productAttributeValues;
    }

    public List<ProductAttributeValues> getProductAttributeValues() {
        return productAttributeValues;
    }

    public void setProductAttributeValues(List<ProductAttributeValues> productAttributeValues) {
        this.productAttributeValues = productAttributeValues;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Products getProduct() {
        return product;
    }

    public void setProduct(Products product) {
        this.product = product;
    }
}
