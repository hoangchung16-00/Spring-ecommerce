package com.example.ecommerce.entitys;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "products")
public class Products {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    @ManyToOne
    @JoinColumn(name = "subcategoryid")
    private Subcategories subcategory;

    @OneToMany(mappedBy = "product",fetch = FetchType.LAZY,cascade = CascadeType.ALL,orphanRemoval = true)
    private List<ProductAttributes> productAttributes;

    @OneToMany(mappedBy = "product", fetch = FetchType.LAZY,cascade = CascadeType.ALL,orphanRemoval = true)
    private List<SkuDetails> skuDetails;

    public Products() {
    }

    public Products(String name, String description, Subcategories subcategory, List<ProductAttributes> productAttributes, List<SkuDetails> skuDetails) {
        this.name = name;
        this.description = description;
        this.subcategory = subcategory;
        this.productAttributes = productAttributes;
        this.skuDetails = skuDetails;
    }

    public Products(String name, String description, Subcategories subcategory) {
        this.name = name;
        this.description = description;
        this.subcategory = subcategory;
    }

    public List<ProductAttributes> getProductValues() {
        return productAttributes;
    }

    public void setProductValues(List<ProductAttributes> productAttributes) {
        this.productAttributes = productAttributes;
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
