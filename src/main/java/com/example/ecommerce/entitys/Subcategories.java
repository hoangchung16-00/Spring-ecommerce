package com.example.ecommerce.entitys;

import javax.persistence.*;

@Entity
@Table(name = "subcategories")
public class Subcategories {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String name;
    private String slug;
    private int sorting;
    @ManyToOne
    @JoinColumn(name = "categoryid")
    private Categories category;

    public Subcategories(String name, String slug, int sorting, Categories category) {
        this.name = name;
        this.slug = slug;
        this.sorting = sorting;
        this.category = category;
    }

    public Subcategories() {
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

    public int getSorting() {
        return sorting;
    }

    public void setSorting(int sorting) {
        this.sorting = sorting;
    }

    public Categories getCategory() {
        return category;
    }

    public void setCategory(Categories category) {
        this.category = category;
    }
}
