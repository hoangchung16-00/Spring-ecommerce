package com.example.ecommerce.entitys;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "skudetail")
public class SkuDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToMany(mappedBy = "skuDetail")
    private List<Skus> skus;
    private int quantity;
    private double price;
    private String image;
    @OneToOne(mappedBy = "skuDetail")
    private CartItems cartItem;
    @ManyToOne
    @JoinColumn(name = "productid")
    private Products product;

    public SkuDetails(List<Skus> skus, int quantity, double price, String image, CartItems cartItem, Products product) {
        this.skus = skus;
        this.quantity = quantity;
        this.price = price;
        this.image = image;
        this.cartItem = cartItem;
        this.product = product;
    }

    public SkuDetails() {
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
