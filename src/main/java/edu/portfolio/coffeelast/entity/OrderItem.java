package edu.portfolio.coffeelast.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "order_items")
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderItemId;

    @ManyToOne(fetch = FetchType.LAZY)
    private Product product;

    @ManyToOne(fetch = FetchType.LAZY)
    private Order order;
    // 이렇게 쓰면, 알아서 Order/Product 테이블에서 id를 가져와서 외래키로 삼는다
    // @JoinColumn (name = "order_id", nullable = false)


    @Enumerated(EnumType.STRING) // 이넘형태를 칼럼으로, 오디널은 숫자로, 이건 밸류로 지정 하는 부분 이다.
    private Category category;

    private int price;
    private int quantity;
}
// 1. @Column 은 필수가 아니다. 없어도 자동으로 칼럼을 지정함 (@는 상세 조건 지정 위해서)
// 2. @JoinColumn을 명시하지 않고 다음과 같이 @ManyToOne을 사용하면,
// JPA가 기본적으로 외래 키 컬럼을 생성하고 해당 외래 키가 Order나 Product 테이블의 id 필드를 참조
//     ( 기본적으로 @Id로 지정된 필드를 ) 외래 키 컬럼 이름: product_id와 order_id로 자동 생성.

// Q. 그럼, Product & Order 엔티티에도 무언가를 작성해야 하나?
// 반대 방향(양방향)의 관계 설정이 가능하나(@OneToMany 또는 @OneToOne), 필수는 아니다.
// -> 단 방향으로 써도 상관은 없지만, 양방향을 쓰는 이유는 : One 을 통해서 Many 를 움직일 수 있어서

/*단방향 관계일 경우 - gpt 주석
양방향 관계가 필요하지 않다면,
Order와 Product 엔티티에는 별도로 코드를 작성할 필요가 없습니다.
즉, 단방향으로만 OrderItem에서 Order와 Product를 참조하고,
Order와 Product는 OrderItem을 참조하지 않아도 됩니다.

	•	양방향 관계를 원하면 Order와 Product 엔티티에 @OneToMany 애노테이션을 추가하여
	                                     OrderItem과의 관계를 명시할 수 있습니다.
	•	양방향이 필요 없다면 OrderItem에서만 관계를 설정해도 문제 없이 동작합니다.
* */
