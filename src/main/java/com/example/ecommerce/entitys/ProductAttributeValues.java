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

    @ManyToMany()
    @JoinColumn(name = "productid")
    private List<Products> products;


    public ProductAttributeValues(String value, ProductAttributes productAttribute, List<Products> products) {
        this.value = value;
        this.productAttribute = productAttribute;
        this.products = products;
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

    public List<Products> getProducts() {
        return products;
    }

    public void setProducts(List<Products> products) {
        this.products = products;
    }

    public void setProductAttribute(ProductAttributes productAttribute) {
        this.productAttribute = productAttribute;
    }


}
