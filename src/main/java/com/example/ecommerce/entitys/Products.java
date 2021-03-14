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
    @OneToMany(mappedBy = "product")
    private List<ProductDetails> productDetails;


    public Products(String name, String description, Subcategories subcategory, List<ProductDetails> productDetails) {
        this.name = name;
        this.description = description;
        this.subcategory = subcategory;
        this.productDetails = productDetails;
    }

    public Products() {
    }

    public List<ProductDetails> getProductDetails() {
        return productDetails;
    }

    public void setProductDetails(List<ProductDetails> productDetails) {
        this.productDetails = productDetails;
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
