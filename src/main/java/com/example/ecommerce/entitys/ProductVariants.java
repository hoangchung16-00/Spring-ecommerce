package com.example.ecommerce.entitys;

import javax.persistence.*;

@Entity
@Table(name = "product_variants")
public class ProductVariants {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String productVariantName;
    private String sku;
    private Double price;
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Products product;
    @OneToOne(mappedBy ="productVariant",fetch = FetchType.EAGER)
    private CartItems cartItem;

    public ProductVariants(String productVariantName, String sku, Double price, Products product, CartItems cartItem) {
        this.productVariantName = productVariantName;
        this.sku = sku;
        this.price = price;
        this.product = product;
        this.cartItem = cartItem;
    }

    public ProductVariants() {
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

    public String getProductVariantName() {
        return productVariantName;
    }

    public void setProductVariantName(String productVariantName) {
        this.productVariantName = productVariantName;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Products getProduct() {
        return product;
    }

    public void setProduct(Products product) {
        this.product = product;
    }
}
