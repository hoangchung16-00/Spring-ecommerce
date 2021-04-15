package com.example.ecommerce.forms;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

public class AddProductForm {
    @NotBlank(message = "Name can not blank")
    private String name;
    @NotBlank
    private String description;
    @Min(value = 1)

    private Long subcategoryid;

    public AddProductForm(@NotBlank(message = "Name can not blank") String name,  @NotBlank String description, Long subcategoryid) {
        this.name = name;
        this.description = description;
        this.subcategoryid = subcategoryid;
    }

    public AddProductForm() {
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
