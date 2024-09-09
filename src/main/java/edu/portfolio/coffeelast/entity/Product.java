package edu.portfolio.coffeelast.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "products")
public class Product {
    // spring.jpa.hibernate.ddl-auto=update 프로퍼티에 추가 안하면, 테이블 안생김

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;
    private String productName;
    private Category category;
    private int price;
    private String description;
}
