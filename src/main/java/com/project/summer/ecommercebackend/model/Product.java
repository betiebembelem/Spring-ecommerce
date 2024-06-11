package com.project.summer.ecommercebackend.model;

import jakarta.persistence.*;

@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @Column(name = "long_descryption", nullable = false)
    private String longDescryption;

    @Column(name = "short_descryption", nullable = false)
    private String shortDescryption;

    @Column(name = "price", nullable = false)
    private Double price;

    @OneToOne(mappedBy = "product", cascade = CascadeType.REMOVE, optional = false, orphanRemoval = true)
    private Inventory inventory;

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getShortDescryption() {
        return shortDescryption;
    }

    public void setShortDescryption(String shortDescryption) {
        this.shortDescryption = shortDescryption;
    }

    public String getLongDescryption() {
        return longDescryption;
    }

    public void setLongDescryption(String longDescryption) {
        this.longDescryption = longDescryption;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}