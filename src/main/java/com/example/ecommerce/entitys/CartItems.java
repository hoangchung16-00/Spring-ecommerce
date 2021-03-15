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
    @JoinColumn(name = "product_variant_id")
    private ProductVariants productVariant;

    public CartItems(int quantity, Double total, Carts cart, ProductVariants productVariant) {
        this.quantity = quantity;
        this.total = total;
        this.cart = cart;
        this.productVariant = productVariant;
    }

    public CartItems() {
    }

    public ProductVariants getProductVariant() {
        return productVariant;
    }

    public void setProductVariant(ProductVariants productVariant) {
        this.productVariant = productVariant;
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
