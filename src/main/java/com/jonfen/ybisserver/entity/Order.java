package com.jonfen.ybisserver.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "orders")
public class Order {

    public Order() {

    }

    public Order(int customerId, int totalPrice, String customerName, List<OrderLine> orderLines, String purchaseDate) {
        this.customerId = customerId;
        this.totalPrice = totalPrice;
        this.customerName = customerName;
        this.orderLines = orderLines;
        this.purchaseDate = purchaseDate;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name="customer_id")
    private Integer customerId;

    @Column(name="total_price")
    private Integer totalPrice;
    @Column(name="customer_name")
    private String customerName;

//    @OneToMany (mappedBy="order") // (cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//    // @JoinColumn(name="products")
//    private List<Product> products;

//    @OneToMany( mappedBy="order", cascade = CascadeType.ALL, orphanRemoval = true)
//    private List<Product> products = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "order")
    @JsonManagedReference
    // @Fetch(FetchMode.JOIN)
    List<OrderLine> orderLines = new ArrayList<>();

    @Column(name="purchase_date")
    private String purchaseDate;

}
