package com.example.ecommerce.entitys;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "carts")
public class Carts {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double total;
    @OneToMany(mappedBy = "cart",fetch = FetchType.LAZY)
    private List<CartItems> cartItems;
    @OneToOne
    @JoinColumn(name = "userid")
    private Users user;

    public Carts() {
    }

    public Carts(Double total, List<CartItems> cartItems, Users user) {
        this.total = total;
        this.cartItems = cartItems;
        this.user = user;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public List<CartItems> getCartItems() {
        return cartItems;
    }

    public void setCartItems(List<CartItems> cartItems) {
        this.cartItems = cartItems;
    }
}
