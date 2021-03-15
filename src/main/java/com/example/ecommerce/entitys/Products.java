package com.example.ecommerce.entitys;

import javax.persistence.*;
import java.util.List;
@Entity
@Table(name = "products")
public class Products {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String name;
    private String description;

    @ManyToOne
    @JoinColumn(name = "subcategory_id")
    private Subcategories subcategory;
    @OneToMany(mappedBy = "product",fetch = FetchType.LAZY)
    private List<ProductAttributes> productAttributes;
    @OneToMany(mappedBy = "product",fetch = FetchType.LAZY)
    private List<SKUs> skus;
    @OneToMany(mappedBy = "product")
    private List<ProductVariants> productVariants;

    public Products(String name, String description, Subcategories subcategory, List<ProductAttributes> productAttributes, List<SKUs> skus, List<ProductVariants> productVariants) {
        this.name = name;
        this.description = description;
        this.subcategory = subcategory;
        this.productAttributes = productAttributes;
        this.skus = skus;
        this.productVariants = productVariants;
    }

    public List<SKUs> getSkus() {
        return skus;
    }

    public void setSkus(List<SKUs> skus) {
        this.skus = skus;
    }

    public List<ProductVariants> getProductVariants() {
        return productVariants;
    }

    public void setProductVariants(List<ProductVariants> productVariants) {
        this.productVariants = productVariants;
    }

    public List<ProductAttributes> getProductAttributes() {
        return productAttributes;
    }

    public void setProductAttributes(List<ProductAttributes> productAttributes) {
        this.productAttributes = productAttributes;
    }

    public Products() {
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Subcategories getSubcategory() {
        return subcategory;
    }

    public void setSubcategory(Subcategories subcategory) {
        this.subcategory = subcategory;
    }
}
