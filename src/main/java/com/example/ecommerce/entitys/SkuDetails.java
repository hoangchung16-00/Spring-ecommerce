package com.example.ecommerce.entitys;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "skudetail")
public class SkuDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToMany(mappedBy = "skuDetail",fetch = FetchType.EAGER)
    private List<Skus> skus;
    private int quantity;
    private String skucode;
    private double price;
    private String image;
    @OneToOne(mappedBy = "skuDetail",fetch = FetchType.LAZY)
    private CartItems cartItem;
    @ManyToOne
    @JoinColumn(name = "productid")
    private Products product;

    public SkuDetails(List<Skus> skus, int quantity, String skucode, double price, String image, CartItems cartItem, Products product) {
        this.skus = skus;
        this.quantity = quantity;
        this.skucode = skucode;
        this.price = price;
        this.image = image;
        this.cartItem = cartItem;
        this.product = product;
    }

    public SkuDetails(int quantity, String skucode, double price, String image, Products product) {
        this.quantity = quantity;
        this.skucode = skucode;
        this.price = price;
        this.image = image;
        this.product = product;
    }

    public SkuDetails() {
    }

    public String getSkucode() {
        return skucode;
    }

    public void setSkucode(String skucode) {
        this.skucode = skucode;
    }

    public CartItems getCartItem() {
        return cartItem;
    }

    public void setCartItem(CartItems cartItem) {
        this.cartItem = cartItem;
    }

    public Products getProduct() {
        return product;
    }

    public void setProduct(Products product) {
        this.product = product;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Skus> getSkus() {
        return skus;
    }

    public void setSkus(List<Skus> skus) {
        this.skus = skus;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
