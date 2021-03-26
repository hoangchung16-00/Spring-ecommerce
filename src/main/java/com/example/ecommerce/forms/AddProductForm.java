package com.example.ecommerce.forms;

public class AddProductForm {
    private Long id;
    private String name;
    private String description;
    private Integer quantity;
    private Float price;
    private  String image;
    private Long subcategoryid;

public AddProductForm(){

}

    public AddProductForm(String name, String description, Integer quantity, Float price, String image, Long subcategoryid) {
        this.name = name;
        this.description = description;
        this.quantity = quantity;
        this.price = price;
        this.image = image;
        this.subcategoryid = subcategoryid;
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

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Long getSubcategoryid() {
        return subcategoryid;
    }

    public void setSubcategoryid(Long subcategoryid) {
        this.subcategoryid = subcategoryid;
    }
}
