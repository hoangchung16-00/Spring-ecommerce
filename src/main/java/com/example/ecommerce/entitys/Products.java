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

    @OneToMany(mappedBy = "product")
    private List<ProductValues> productValues;

    public Products() {
    }

    public Products(String name, String description, Subcategories subcategory, List<ProductValues> productValues) {
        this.name = name;
        this.description = description;
        this.subcategory = subcategory;
        this.productValues = productValues;
    }

    public Products(String name, String description, Subcategories subcategory) {
        this.name = name;
        this.description = description;
        this.subcategory = subcategory;
    }

    public List<ProductValues> getProductValues() {
        return productValues;
    }

    public void setProductValues(List<ProductValues> productValues) {
        this.productValues = productValues;
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
