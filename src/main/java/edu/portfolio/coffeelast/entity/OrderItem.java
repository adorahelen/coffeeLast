package edu.portfolio.coffeelast.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "order_items")
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderItemId;

    // @조인 컬럼 사용시 외래키에 대한 상세 지정 가능, @칼럼도 마찬가지 없어도 되고 있으면 세부 지정 가능
    @ManyToOne(fetch = FetchType.LAZY)
    private Product product;

    @ManyToOne(fetch = FetchType.LAZY)
    private Order order;

    private Category category;
    private int price;
    private int quantity;
}
