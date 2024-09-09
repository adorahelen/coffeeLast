package edu.portfolio.coffeelast.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;
    private String email;
    private String address;
    private String postcode;
    private String orderItems;
    private OrderStatus orderStatus;
}
