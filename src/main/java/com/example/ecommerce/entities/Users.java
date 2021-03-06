package com.example.ecommerce.entities;

import javax.persistence.*;

@Entity
@Table(name ="users")
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;
    private String name;
    private boolean isadmin;
    private String email;
    private String role;
    @OneToOne(mappedBy = "user",fetch = FetchType.LAZY)
    private Carts cart;
    public Users() {
    }

    public Users(String username, String password, String name, boolean isadmin, String email, String role, Carts cart) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.isadmin = isadmin;
        this.email = email;
        this.role = role;
        this.cart = cart;
    }

    public boolean isIsadmin() {
        return isadmin;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
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

    public boolean getIsadmin() {
        return isadmin;
    }

    public void setIsadmin(boolean isadmin) {
        this.isadmin = isadmin;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Carts getCart() {
        return cart;
    }

    public void setCart(Carts cart) {
        this.cart = cart;
    }
}

