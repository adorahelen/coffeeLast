package edu.portfolio.coffeelast.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;
    private String email;
    private String address;
    private String postcode;

    // private String orderItems; 스트링으로 하는게 아닌게 맞겠지?

    @Enumerated(EnumType.STRING) // 이넘형태를 칼럼으로, 오디널은 숫자로, 이건 밸류로 지정 하는 부분 이다.
    private OrderStatus orderStatus;

    // Order가 여러 개의 OrderItem을 가질 수 있으므로 OneToMany 관계 설정
    @OneToMany(mappedBy = "order", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<OrderItem> orderItems = new ArrayList<>();
}

// 양방한 관계가 필요한이 이유, 원투매니 하고 한번에 저장되게 설정하고, 원을 저장하면 매니도 저장하게끔

// 	1/ @OneToMany(mappedBy = "order"): Order는 여러 OrderItem을 가질 수 있으므로 @OneToMany로 설정합니다.
// 	    mappedBy = "order"는 OrderItem 엔티티에서 Order 필드에 의해 관계가 정의된다는 의미입니다.
//	    •	이 관계를 설정하면 Order 엔티티에서 OrderItem 목록을 조회할 수 있습니다.