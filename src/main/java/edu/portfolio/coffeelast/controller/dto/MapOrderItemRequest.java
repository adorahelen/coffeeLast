package edu.portfolio.coffeelast.controller.dto;

public record MapOrderItemRequest(
        Long productId,
        String category,
        int price,
        int quantity
) {}