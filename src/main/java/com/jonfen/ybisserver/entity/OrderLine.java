package com.jonfen.ybisserver.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIncludeProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "order_lines")
public class OrderLine {

    public OrderLine() {

    }

    public OrderLine(Order order, Product product) {
        this.order = order;
        this.product = product;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    // @JsonIncludeProperties(value = {"order_id"})
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonBackReference
    @JoinColumn(name = "order_id")
    private Order order;

    @Column(name = "amount")
    private Integer amount;

    // @JsonIncludeProperties(value = {"product_id"})
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "product_id")
    private Product product;


}
