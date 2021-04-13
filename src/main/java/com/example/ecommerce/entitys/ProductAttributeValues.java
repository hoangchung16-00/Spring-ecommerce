package com.example.ecommerce.entitys;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "productattributevalues")
public class ProductAttributeValues {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String value;
    @ManyToOne
    @JoinColumn(name = "productattributeid")
    private ProductAttributes productAttribute;
    @OneToOne(mappedBy = "productAttributeValue",fetch = FetchType.EAGER)
    private Skus sku;


    public ProductAttributeValues(String value, ProductAttributes productAttribute, Skus sku) {
        this.value = value;
        this.productAttribute = productAttribute;
        this.sku = sku;
    }

    public ProductAttributeValues() {
    }

    public Skus getSku() {
        return sku;
    }

    public void setSku(Skus sku) {
        this.sku = sku;
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
