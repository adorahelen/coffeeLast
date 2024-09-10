package edu.portfolio.coffeelast.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "orders")
@Setter
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
    @JsonIgnore
    @OneToMany(mappedBy = "order", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<OrderItem> orderItems = new ArrayList<>();
    // ### cascade = CascadeType.ALL: Order를 저장할 때, 연관된 OrderItem들도 함께 저장됩니다.
    // ### LAZY 로딩은 연관된 엔티티를 처음부터 로드하지 않고, 해당 엔티티에 실제로 접근할 때(즉, getOrderItems()를 호출할 때) 데이터를 로드

    // 추가 메서드로 양방향 관계를 관리 <->
    public void addOrderItem(OrderItem orderItem) {
        this.orderItems.add(orderItem);
        orderItem.setOrder(this);  // OrderItem과의 관계 설정
        // 	•	addOrderItem 메서드를 통해 OrderItem을 추가할 때, Order와의 관계도 설정합니다 (orderItem.setOrder(this)).
    }

    // 성공하면 지울 코드 =============================
    // 수정해야 하자만 동시 저장 되는 예시 코드
    // Order 생성
    // {
//    Order order = new Order();
//order.setEmail("customer@example.com");
//order.setAddress("123 Coffee Street");
//order.setPostcode("12345");
//
//    // OrderItem 생성
//    OrderItem item1 = new OrderItem();
//item1.setProductName("Espresso");
//item1.setCategory("Coffee");
//item1.setPrice(3000);
//item1.setQuantity(2);
//
//    OrderItem item2 = new OrderItem();
//item2.setProductName("Cappuccino");
//item2.setCategory("Coffee");
//item2.setPrice(4000);
//item2.setQuantity(1);
//
//// Order에 OrderItem 추가
//order.addOrderItem(item1);
//order.addOrderItem(item2);
//
//// Order 저장 (OrderItem도 함께 저장됨)
//orderRepository.save(order);
    // } =======================================



}

// 양방한 관계가 필요한이 이유, 원투매니 하고 한번에 저장되게 설정하고, 원을 저장하면 매니도 저장하게끔

// 	1/ @OneToMany(mappedBy = "order"): Order는 여러 OrderItem을 가질 수 있으므로 @OneToMany로 설정합니다.
// 	    mappedBy = "order"는 OrderItem 엔티티에서 Order 필드에 의해 관계가 정의된다는 의미입니다.
//	    •	이 관계를 설정하면 Order 엔티티에서 OrderItem 목록을 조회할 수 있습니다.

// Order를 생성할 때, OrderItem도 함께 저장하려면
//  CascadeType.ALL 또는 CascadeType.PERSIST를 사용해 OrderItem도 자동으로 저장되도록 설정할 수 있습니다.
//  또한 Order 엔티티와 OrderItem 간의 양방향 관계가 잘 설정되어 있어야 합니다.


/*
* OrderItem 엔티티와 Order 엔티티간 연관관계가 있는데,
*  controller에서  Member엔티티를 JSON으로 반환하는 과정에서 알수없는 에러가 발생했다.


원인 -> 연관관계 매핑 OnetoMany <-> ManyToOne에서 발생
Order엔티티에서 Fetch.Lazy를 적용해도 엔티티를
* JSON으로 변경하는 중 serialize(직렬화) 과정을 거치는데,
* 이때 OrderItem에 order가 있으니까 order를 참조하고,
* order에 있는 OrderItem를 참조하면서 무한 재귀가 발생한다. => 나도 맥시멈 뭐시기 나옸음



해결
방법1. 참조하는 엔티티에서 재귀를 일으키는 필드에 @JsonIgnore를 붙여준다. -> 이걸로 해결

방법2. RestController에서 엔티티를 바로 반환하지 않고, DTO를 사용한다. ->이미 적용되어있었음

-해당 에러는 엔티티를 바로 반환하지 않고 DTO를 사용하는 이유이기도 함.
* */