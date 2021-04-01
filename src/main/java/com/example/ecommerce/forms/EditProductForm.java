package com.example.ecommerce.forms;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

public class EditProductForm {
    private Long id;
    @NotBlank(message = "Name can not blank")
    private String name;
    @NotBlank
    private String description;


    private Long subcategoryid;

    public EditProductForm(Long id, @NotBlank(message = "Name can not blank") String name, @NotBlank String description, Long subcategoryid) {
        this.id = id;
        this.name = name;
        this.description = description;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public Long getSubcategoryid() {
        return subcategoryid;
    }

    public void setSubcategoryid(Long subcategoryid) {
        this.subcategoryid = subcategoryid;
    }
}
