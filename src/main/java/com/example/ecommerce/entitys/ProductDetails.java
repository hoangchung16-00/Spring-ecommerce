package com.example.ecommerce.entitys;

import com.example.ecommerce.Enums.Size;

import javax.persistence.*;
import java.util.List;
@Entity
@Table(name = "product_details")
public class ProductDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;


    @OneToOne
    @JoinColumn(name = "value_id")
    private VariantValues variantValue;


    public ProductDetails() {
    }

    public ProductDetails(VariantValues variantValue) {
        this.variantValue = variantValue;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


}
