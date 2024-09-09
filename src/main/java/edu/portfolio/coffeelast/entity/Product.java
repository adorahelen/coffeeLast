package edu.portfolio.coffeelast.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "products")
public class Product {
    // spring.jpa.hibernate.ddl-auto=update 프로퍼티에 추가 안하면, 테이블 안생김

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;
    private String productName;

    @Enumerated(EnumType.STRING)
    private Category category;

    private int price;
    private String description;

    // 이건 칼럼으로 지정되지 않고, 연관관계를 나타내기 위한 필드이다. (칼럼 저장되면, 안댐, 리스트라 안댈꺼임)
    // Product가 여러 개의 OrderItem과 연결될 수 있으므로 OneToMany 관계 설정
    @OneToMany(mappedBy = "product", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<OrderItem> orderItems = new ArrayList<>();
}
// 	1. @OneToMany(mappedBy = "product"): Product는 여러 OrderItem을 가질 수 있으며,
// 	        OrderItem 엔티티의 product 필드와 연결된다는 의미입니다.