package edu.portfolio.coffeelast.service;

import edu.portfolio.coffeelast.entity.Order;
import edu.portfolio.coffeelast.entity.OrderItem;
import edu.portfolio.coffeelast.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {
    final OrderRepository orderRepository;

    // 양방향 매핑된 [Order <-> OrderItem] 을 한꺼번에 저장하는 메소드
    public Order createOrder(Order order, List<OrderItem> orderItems) {
        // Order 와 OrderItem 간의 관계 설정
        for (OrderItem orderItem : orderItems) {
            order.addOrderItem(orderItem);  // 양방향 관계 설정
        }

        // Order 와 OrderItem 을 함께 저장
        return orderRepository.save(order);
    }
    // Order와 OrderItem 간의 관계를 설정하고,
    // orderRepository.save(order)를 호출하면,
    // CascadeType.ALL 덕분에 Order와 함께 OrderItem도 자동으로 저장됩니다.

	//•	addOrderItem 메서드를 통해 양방향 관계를 관리하여
    //              OrderItem이 Order와 올바르게 연관될 수 있도록 합니다.

}
