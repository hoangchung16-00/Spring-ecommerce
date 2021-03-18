package com.example.ecommerce.entitys;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "cartItems")
public class CartItems {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;


    private int quantity;
    private Double total;

    @ManyToOne
    @JoinColumn(name = "cartId")
    private Carts cart;

    @ManyToOne
    @JoinColumn(name = "productAttributeValueId")
    private ProductAttributeValues productAttributeValue;

    public CartItems() {
    }

    public CartItems(int quantity, Double total, Carts cart, ProductAttributeValues productAttributeValue) {
        this.quantity = quantity;
        this.total = total;
        this.cart = cart;
        this.productAttributeValue = productAttributeValue;
    }

    public ProductAttributeValues getProductAttributeValue() {
        return productAttributeValue;
    }

    public void setProductAttributeValue(ProductAttributeValues productAttributeValue) {
        this.productAttributeValue = productAttributeValue;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }


    public Carts getCart() {
        return cart;
    }

    public void setCart(Carts cart) {
        this.cart = cart;
    }

}
