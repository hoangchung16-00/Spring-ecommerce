package com.example.ecommerce.entitys;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "subcategories")
public class Subcategories {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String name;
    private String slug;
    private Integer sorting;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Categories category;
    @OneToMany(mappedBy = "subcategory",fetch = FetchType.EAGER)
    private List<Products> products;

    public Categories getCategory() {
        return category;
    }

    public void setCategory(Categories category) {
        this.category = category;
    }

    public List<Products> getProducts() {
        return products;
    }

    public void setProducts(List<Products> products) {
        this.products = products;
    }

    public Subcategories() {
    }

    public Subcategories(String name, String slug, Integer sorting) {
        this.name = name;
        this.slug = slug;
        this.sorting = sorting;
    }

    public Subcategories(Long id, String name, String slug, Integer sorting, Categories category) {
        this.id = id;
        this.name = name;
        this.slug = slug;
        this.sorting = sorting;
        this.category = category;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public Integer getSorting() {
        return sorting;
    }

    public void setSorting(Integer sorting) {
        this.sorting = sorting;
    }
}
