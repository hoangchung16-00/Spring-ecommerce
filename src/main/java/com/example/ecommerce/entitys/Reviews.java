package com.example.ecommerce.entitys;

import javax.persistence.*;

@Entity
@Table(name = "reviews")
public class Reviews {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String description;
    private int rating;
    @ManyToOne
    @JoinColumn(name = "productId")
    private Products product;
    @ManyToOne
    @JoinColumn(name = "userId")
    private Users user;

    public Reviews(String description, int rating, Products product, Users user) {
        this.description = description;
        this.rating = rating;
        this.product = product;
        this.user = user;
    }

    public Reviews() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public Products getProduct() {
        return product;
    }

    public void setProduct(Products product) {
        this.product = product;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }
}
