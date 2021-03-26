package com.example.ecommerce.forms;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

public class EditProductForm {
    private Long id;
    @NotBlank(message = "Name can not blank")
    private String name;
    @Min(value = 1, message = "Sorting Invalid")
    private int quantity;
    @NotBlank
    private String description;
    @Min(value = 1)
    private Double price;

    private Long subcategoryid;

    public EditProductForm(Long id, @NotBlank(message = "Name can not blank") String name, @Min(value = 1, message = "Sorting Invalid") int quantity, @NotBlank String description, @Min(value = 1) Double price, Long subcategoryid) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.description = description;
        this.price = price;
        this.subcategoryid = subcategoryid;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public EditProductForm() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Long getSubcategoryid() {
        return subcategoryid;
    }

    public void setSubcategoryid(Long subcategoryid) {
        this.subcategoryid = subcategoryid;
    }
}
