package com.example.ecommerce.entitys;

import javax.persistence.*;

@Entity
@Table(name = "skus")
public class SKUs {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private double price;
    private int quantity;
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Products product;
    @OneToOne(mappedBy = "sku",fetch = FetchType.LAZY)
    private CartItems cartItem;

    @OneToOne(mappedBy = "sku")
    private ProductVariants productVariant;

    public SKUs(double price, int quantity, Products product, CartItems cartItem, ProductVariants productVariant) {
        this.price = price;
        this.quantity = quantity;
        this.product = product;
        this.cartItem = cartItem;
        this.productVariant = productVariant;
    }

    public SKUs() {
    }

    public ProductVariants getProductVariant() {
        return productVariant;
    }

    public void setProductVariant(ProductVariants productVariant) {
        this.productVariant = productVariant;
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

    public Products getProduct() {
        return product;
    }

    public void setProduct(Products product) {
        this.product = product;
    }
}
