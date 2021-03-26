package com.example.ecommerce.entitys;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "categories")
public class Categories {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String slug;
    private int sorting;
    @OneToMany(mappedBy = "category",fetch = FetchType.LAZY)
    private List<Subcategories> subcategories;

    public Categories() {
    }

    public Categories(String name, String slug, int sorting, List<Subcategories> subcategories) {
        this.name = name;
        this.slug = slug;
        this.sorting = sorting;
        this.subcategories = subcategories;
    }

    public List<Subcategories> getSubcategories() {
        return subcategories;
    }

    public void setSubcategories(List<Subcategories> subcategories) {
        this.subcategories = subcategories;
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
}
