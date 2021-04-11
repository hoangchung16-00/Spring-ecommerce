package com.example.ecommerce.model;

public class ProductDetail {
    private Long id;
    private String skuCode;
    private Long productId;
    private String size;
    private String color;
    private String image;
    private double price;
    private int quantity;

    public ProductDetail() {
    }

    public ProductDetail(Long id, String skuCode, Long productId, String size, String color, String image, double price, int quantity) {
        this.id = id;
        this.skuCode = skuCode;
        this.productId = productId;
        this.size = size;
        this.color = color;
        this.image = image;
        this.price = price;
        this.quantity = quantity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
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

