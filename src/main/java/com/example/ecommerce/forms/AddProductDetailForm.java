package com.example.ecommerce.forms;

import javax.validation.constraints.NotBlank;

public class AddProductDetailForm {
    @NotBlank(message = "abc")
    private String skuCode;
    private Long productId;
    private Long sizeId;
    private Long colorId;
    private String image;
    private double price;
    private int quantity;

    public AddProductDetailForm() {
    }

    public AddProductDetailForm(@NotBlank(message = "abc") String skuCode, Long productId, Long sizeId, Long colorId, String image, double price, int quantity) {
        this.skuCode = skuCode;
        this.productId = productId;
        this.sizeId = sizeId;
        this.colorId = colorId;
        this.image = image;
        this.price = price;
        this.quantity = quantity;
    }

    public String getSkuCode() {
        return skuCode;
    }

    public void setSkuCode(String skuCode) {
        this.skuCode = skuCode;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
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
