package com.example.ecommerce.forms;

import javax.validation.constraints.NotBlank;

public class AddProductDetailForm {
    @NotBlank(message = "abc")
    private String skuCode;
    private Long sizeId;
    private Long colorId;
    private double price;
    private int quantity;

    public AddProductDetailForm() {
    }

    public AddProductDetailForm(@NotBlank(message = "abc") String skuCode, Long sizeId, Long colorId, double price, int quantity) {
        this.skuCode = skuCode;
        this.sizeId = sizeId;
        this.colorId = colorId;
        this.price = price;
        this.quantity = quantity;
    }

    public String getSkuCode() {
        return skuCode;
    }

    public void setSkuCode(String skuCode) {
        this.skuCode = skuCode;
    }


    public Long getSizeId() {
        return sizeId;
    }

    public void setSizeId(Long sizeId) {
        this.sizeId = sizeId;
    }

    public Long getColorId() {
        return colorId;
    }

    public void setColorId(Long colorId) {
        this.colorId = colorId;
    }


    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
