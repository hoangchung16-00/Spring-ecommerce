package com.example.ecommerce.entitys;

import org.eclipse.jdt.internal.compiler.ast.FalseLiteral;

import javax.persistence.*;
import java.util.List;
@Entity
@Table(name = "cart")
public class Carts {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private int quantity;
    private Double total;
    @OneToOne
    @JoinColumn(name = "user_id")
    private Users user;
    @OneToMany(mappedBy = "cart",fetch = FetchType.EAGER)
    private List<CartItems> cartItems;

    public Carts(int quantity, Double total, Users user, List<CartItems> cartItems) {
        this.quantity = quantity;
        this.total = total;
        this.user = user;
        this.cartItems = cartItems;
    }

    public List<CartItems> getCartItems() {
        return cartItems;
    }

    public void setCartItems(List<CartItems> cartItems) {
        this.cartItems = cartItems;
    }

    public Carts() {
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

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }
}
