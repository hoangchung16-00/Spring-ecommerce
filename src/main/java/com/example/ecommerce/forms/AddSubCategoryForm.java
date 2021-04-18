package com.example.ecommerce.forms;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

public class AddSubCategoryForm {
    @NotBlank(message = "Name can not blank")
    private String name;
    @Min(value = 1, message = "Sorting Invalid")
    private int sorting;
    private Long categoryid;

    public AddSubCategoryForm( String name, int sorting, Long categoryid) {
        this.name = name;
        this.sorting = sorting;
        this.categoryid = categoryid;
    }

    public Long getCategoryid() {
        return categoryid;
    }

    public void setCategoryid(Long categoryid) {
        this.categoryid = categoryid;
    }

    public AddSubCategoryForm() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public int getSorting() {
        return sorting;
    }

    public void setSorting(int sorting) {
        this.sorting = sorting;
    }
}
