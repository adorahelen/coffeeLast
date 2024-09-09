package edu.portfolio.coffeelast.controller;

import edu.portfolio.coffeelast.entity.Category;
import lombok.Data;

public record CreateProductRequest
        (String productName,
         Category category,
         int price,
         String description)
{
}
/*  <여기서 사용>
@PostMapping("/products")
    public String newProduct(CreateProductRequest createProductRequest) {
        productService.createProduct(
* */
