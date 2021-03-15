package com.example.ecommerce.entitys;

import javax.persistence.*;
import java.util.List;
@Entity
@Table(name = "variants")
public class Variants {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String variant;
    @OneToMany(mappedBy = "variant",fetch = FetchType.EAGER)
    private List<VariantValues> variantValues;

    public Variants() {
    }

    public List<VariantValues> getVariantValues() {
        return variantValues;
    }

    public void setVariantValues(List<VariantValues> variantValues) {
        this.variantValues = variantValues;
    }

    public Variants(String variant) {
        this.variant = variant;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getVariant() {
        return variant;
    }

    public void setVariant(String variant) {
        this.variant = variant;
    }
}
