package com.example.ecommerce.entitys;

import javax.persistence.*;

@Entity
@Table(name = "cartitems")
public class CartItems {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private int quantity;
    private Double total;
    @ManyToOne
    @JoinColumn(name = "cart_id")
    private Carts cart;
    @OneToOne
    @JoinColumn(name = "product_id")
    private ProductDetails productDetail;

    public CartItems(int quantity, Double total, Carts cart, ProductDetails productDetail) {
        this.quantity = quantity;
        this.total = total;
        this.cart = cart;
        this.productDetail = productDetail;
    }

    public CartItems() {
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

    public ProductDetails getProductDetail() {
        return productDetail;
    }

    public void setProductDetail(ProductDetails productDetail) {
        this.productDetail = productDetail;
    }
}
