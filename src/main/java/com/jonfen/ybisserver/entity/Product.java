package com.jonfen.ybisserver.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
// @Table(name = "products")
public class Product {

    public Product() {

    }

    public Product(String name, String description, int price, String imageUrl, int stock) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.imageUrl = imageUrl;
        this.stock = stock;

    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name="name")
    private String name;

    @Column(name="description")
    private String description;

    @Column(name="price")
    private int price;

    @Column(name="image_url")
    private String imageUrl;

    @Column(name="stock")
    private int stock;

//    @ManyToOne
//    @JoinColumn(name="products")
//    @JsonIgnore
//    private Order order;

//    @ManyToOne
//    @JoinColumn(name = "order_id")
//    private Order order;

}
