package com.example.ecommerce.entitys;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "productattributes")
public class ProductAttributes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @OneToMany(mappedBy = "productAttribute",fetch = FetchType.EAGER)
    private List<ProductAttributeValues> productAttributeValues;
    @ManyToOne
    @JoinColumn(name = "productid")
    private Products product;
    public ProductAttributes() {
    }

    public ProductAttributes(String name, List<ProductAttributeValues> productAttributeValues, Products product) {
        this.name = name;
        this.productAttributeValues = productAttributeValues;
        this.product = product;
    }

    public List<ProductAttributeValues> getProductAttributeValues() {
        return productAttributeValues;
    }

    public void setProductAttributeValues(List<ProductAttributeValues> productAttributeValues) {
        this.productAttributeValues = productAttributeValues;
    }

    public Products getProduct() {
        return product;
    }

    public void setProduct(Products product) {
        this.product = product;
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
}
