package edu.portfolio.coffeelast.controller.dto;

import java.util.List;

// 뷰에서 넘어오는 데이터를 받아서, 서비스를 거쳐서 , 엔티티로 변환해야 하니까 사용하는 친구
public record CreateOrderRequest(
        String email,
        String address,
        String postcode,
        // List<OrderItem> orderItems
        List<MapOrderItemRequest> orderItems // 레코드 안에 레코드




) {
}
// record는 기본적으로 모든 필드에 대해 getter 메서드를 자동으로 생성
// 따라서 접근시에는  => 필드에 접근하려면 getEmail()이 아니라 email() 메서드를 호출
