package com.example.ecommerce.forms;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

public class AddCategoryForm {
    @NotBlank(message = "Name can not blank")
    private String name;
    @Min(value = 1, message = "Sorting Invalid")
    private int sorting;

    public AddCategoryForm(String name, int sorting) {
        this.name = name;
        this.sorting = sorting;
    }

    public AddCategoryForm() {
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
