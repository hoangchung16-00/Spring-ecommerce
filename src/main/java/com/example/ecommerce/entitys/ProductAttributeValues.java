package com.example.ecommerce.entitys;

import org.springframework.transaction.annotation.Transactional;

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
    @org.springframework.data.annotation.Transient
    @OneToMany(mappedBy = "productAttributeValue",fetch = FetchType.LAZY)
    private List<Skus> skus;




    public ProductAttributeValues() {
    }

    public ProductAttributeValues(String value, ProductAttributes productAttribute, List<Skus> skus) {
        this.value = value;
        this.productAttribute = productAttribute;
        this.skus = skus;
    }

    public List<Skus> getSkus() {
        return skus;
    }

    public void setSkus(List<Skus> skus) {
        this.skus = skus;
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
