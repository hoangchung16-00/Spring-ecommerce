package com.example.ecommerce.entitys;

import javax.persistence.*;

@Entity
@Table(name = "cartitem")
public class CartItems {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    @JoinColumn(name = "skudetailid")
    private SkuDetails skuDetail;
    @ManyToOne
    @JoinColumn(name = "cartid")
    private Carts cart;
    private int quantity;
    private double totalPrice;

    public CartItems() {
    }

    public CartItems(SkuDetails skuDetail, Carts cart, int quantity, double totalPrice) {
        this.skuDetail = skuDetail;
        this.cart = cart;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public SkuDetails getSkuDetail() {
        return skuDetail;
    }

    public void setSkuDetail(SkuDetails skuDetail) {
        this.skuDetail = skuDetail;
    }

    public Carts getCart() {
        return cart;
    }

    public void setCart(Carts cart) {
        this.cart = cart;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }
}
