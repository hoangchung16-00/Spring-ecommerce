package com.example.ecommerce.entitys;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "productAttributeValues")
public class ProductAttributeValues {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String value;
    @ManyToMany
    @JoinColumn(name = "productId")
    private List<Products> products;

    @OneToMany(mappedBy ="productAttributeValue")
    private List<CartItems> cartItems;

    @ManyToOne
    @JoinColumn(name = "productAttributeId")
    private ProductAttributes productAttribute;


    public ProductAttributeValues() {
    }

    public ProductAttributeValues(String value, List<Products> products, List<CartItems> cartItems, ProductAttributes productAttribute) {
        this.value = value;
        this.products = products;
        this.cartItems = cartItems;
        this.productAttribute = productAttribute;
    }

    public List<CartItems> getCartItems() {
        return cartItems;
    }

    public void setCartItems(List<CartItems> cartItems) {
        this.cartItems = cartItems;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public List<Products> getProducts() {
        return products;
    }

    public void setProducts(List<Products> products) {
        this.products = products;
    }

    public ProductAttributes getProductAttribute() {
        return productAttribute;
    }

    public void setProductAttribute(ProductAttributes productAttribute) {
        this.productAttribute = productAttribute;
    }
}
