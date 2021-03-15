package com.example.ecommerce.entitys;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "product_attribute_values")
public class ProductAttributeValues {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String value;
    @ManyToOne
    @JoinColumn(name = "product_attribute_id")
    private ProductAttributes productAttribute;
    @ManyToMany(mappedBy = "productAttributeValues")
    private List<ProductVariants> productVariants;

    public ProductAttributeValues(String value, ProductAttributes productAttribute, List<ProductVariants> productVariants) {
        this.value = value;
        this.productAttribute = productAttribute;
        this.productVariants = productVariants;
    }

    public List<ProductVariants> getProductVariants() {
        return productVariants;
    }

    public void setProductVariants(List<ProductVariants> productVariants) {
        this.productVariants = productVariants;
    }

    public ProductAttributeValues() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public ProductAttributes getProductAttribute() {
        return productAttribute;
    }

    public void setProductAttribute(ProductAttributes productAttribute) {
        this.productAttribute = productAttribute;
    }
}
