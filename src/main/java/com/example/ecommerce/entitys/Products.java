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
    private String image;
    private Double price;
    private int quantity;
    private String description;
    @ManyToOne
    @JoinColumn(name = "subcategoryid")
    private Subcategories subcategory;

    @ManyToMany(mappedBy = "products")
    private List<ProductAttributeValues> productAttributeValues;

    public Products() {
    }

    public Products(String name, String image, Double price, int quantity, String description, Subcategories subcategory, List<ProductAttributeValues> productAttributeValues) {
        this.name = name;
        this.image = image;
        this.price = price;
        this.quantity = quantity;
        this.description = description;
        this.subcategory = subcategory;
        this.productAttributeValues = productAttributeValues;
    }

    public Products(String name, String image, Double price, int quantity, String description, Subcategories subcategory) {
        this.name = name;
        this.image = image;
        this.price = price;
        this.quantity = quantity;
        this.description = description;
        this.subcategory = subcategory;
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
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
