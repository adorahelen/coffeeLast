package edu.portfolio.coffeelast.controller;

import edu.portfolio.coffeelast.controller.dto.CreateOrderRequest;
import edu.portfolio.coffeelast.controller.dto.MapOrderItemRequest;
import edu.portfolio.coffeelast.entity.*;
import edu.portfolio.coffeelast.service.OrderService;
import edu.portfolio.coffeelast.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;
    private final ProductService productService;

    @PostMapping("/api/v1/orders")
    public Order createOrder(@RequestBody CreateOrderRequest orderRequest) {
        Order order = new Order();
        order.setEmail(orderRequest.email());
        order.setAddress(orderRequest.address());
        order.setPostcode(orderRequest.postcode());
        order.setOrderStatus(OrderStatus.ACCEPTED); // 이걸로 추가
       // order.setOrderItems(orderRequest.orderItems()); 대신 아래에서 진행

        // OrderItem 생성 및 설정
        List<OrderItem> orderItems = new ArrayList<>();
        for (MapOrderItemRequest itemRequest : orderRequest.orderItems()) {
            OrderItem orderItem = new OrderItem();

            // Product 찾기 (ProductService 사용) *외래키 매핑 걸어놨으니까
            Product product = productService.getProductById(itemRequest.productId());
            orderItem.setProduct(product);

            // OrderItem 세부 정보 설정
            orderItem.setCategory(Category.valueOf(itemRequest.category()));
            orderItem.setPrice(itemRequest.price());
            orderItem.setQuantity(itemRequest.quantity());

            // OrderItem을 Order와 연관짓기
            order.addOrderItem(orderItem);

            // OrderItem 리스트에 추가
            orderItems.add(orderItem);
        }

        // Order와 OrderItem 함께 저장
        return orderService.createOrder(order, orderItems);
    }
}

// ERROR
//Network Error
//AxiosError: Network Error
//    at XMLHttpRequest.handleError (http://localhost:3000/static/js/bundle.js:54564:14)
//    at Axios.request (http://localhost:3000/static/js/bundle.js:55014:41)

// -> 아마도 CORS 설정 에러
