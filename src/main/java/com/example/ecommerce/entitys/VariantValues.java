package com.example.ecommerce.entitys;

import javax.persistence.*;

@Entity
@Table(name = "variant_value")
public class VariantValues {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String value;
    @ManyToOne
    @JoinColumn(name = "variant_id")
    private Variants variant;
    @OneToOne(mappedBy ="variantValue",fetch = FetchType.EAGER)
    private ProductDetails productDetail;

    public VariantValues(String value, Variants variant) {
        this.value = value;
        this.variant = variant;
    }

    public VariantValues() {
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

    public Variants getVariant() {
        return variant;
    }

    public void setVariant(Variants variant) {
        this.variant = variant;
    }
}
