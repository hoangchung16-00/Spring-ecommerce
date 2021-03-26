package com.example.ecommerce.forms;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

public class EditCategoryForm {
    private Long id;
    @NotBlank(message = "Name can not blank")
    private String name;
    @Min(value = 1, message = "Sorting Invalid")
    private int sorting;

    public EditCategoryForm(Long id, String name, int sorting) {
        this.id = id;
        this.name = name;
        this.sorting = sorting;
    }

    public EditCategoryForm() {
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

    public int getSorting() {
        return sorting;
    }

    public void setSorting(int sorting) {
        this.sorting = sorting;
    }
}
