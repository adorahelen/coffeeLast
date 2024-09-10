package edu.portfolio.coffeelast.controller;

import edu.portfolio.coffeelast.entity.Category;
import edu.portfolio.coffeelast.entity.Product;
import edu.portfolio.coffeelast.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
public class ApiProductController {

    private final ProductService productService;

    @RequestMapping("/api/v1/products")
    public List<Product> getAllProducts(@RequestParam Optional<Category> category) {

        return category.map(productService::getProductsByCategory)
                .orElse(productService.getAllProducts());
    }
}