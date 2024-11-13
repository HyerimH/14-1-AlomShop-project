package com.example.project1.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @Column(name = "order_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    LocalDateTime order_at;

    String status;

    Integer quantity;

//    @ManyToOne
//    @JoinColumn(name = "user_id")
//    User user;

    @ManyToOne
    @JoinColumn(name = "product_id")
    Product product;


}
