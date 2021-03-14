package com.example.ecommerce.entitys;

import javax.persistence.*;
import java.util.List;
@Entity
@Table(name = "users")
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String username;
    private String password;
    private String name;
    private boolean is_admin;
    private String email;

    @OneToOne(mappedBy ="user",fetch = FetchType.EAGER)
    private Carts cart;
    @OneToMany(mappedBy = "user")
    private List<Reviews> reviews;

    public Users(String username, String password, String name, boolean is_admin, String email, Carts cart, List<Reviews> reviews) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.is_admin = is_admin;
        this.email = email;
        this.cart = cart;
        this.reviews = reviews;
    }

    public Carts getCart() {
        return cart;
    }

    public List<Reviews> getReviews() {
        return reviews;
    }

    public void setReviews(List<Reviews> reviews) {
        this.reviews = reviews;
    }

    public void setCart(Carts cart) {
        this.cart = cart;
    }

    public Users() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isIs_admin() {
        return is_admin;
    }

    public void setIs_admin(boolean is_admin) {
        this.is_admin = is_admin;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
