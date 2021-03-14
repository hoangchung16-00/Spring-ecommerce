package com.example.ecommerce.entitys;

import com.example.ecommerce.Enums.Size;

import javax.persistence.*;

@Entity
@Table(name = "productdetails")
public class ProductDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private Size size;
    private String color;
    private Double price;
    private String image;
    private Double sale;
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Products product;

    @OneToOne(mappedBy = "productDetail")
    private CartItems cartItem;

    public ProductDetails() {
    }

    public ProductDetails(Size size, String color, Double price, String image, Double sale, Products product, CartItems cartItem) {
        this.size = size;
        this.color = color;
        this.price = price;
        this.image = image;
        this.sale = sale;
        this.product = product;
        this.cartItem = cartItem;
    }

    public CartItems getCartItem() {
        return cartItem;
    }

    public void setCartItem(CartItems cartItem) {
        this.cartItem = cartItem;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Double getSale() {
        return sale;
    }

    public void setSale(Double sale) {
        this.sale = sale;
    }

    public Products getProduct() {
        return product;
    }

    public void setProduct(Products product) {
        this.product = product;
    }
}
