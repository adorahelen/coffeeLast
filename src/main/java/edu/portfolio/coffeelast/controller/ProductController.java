package edu.portfolio.coffeelast.controller;

import edu.portfolio.coffeelast.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    // 처음 들어갔을 떄, 리스트 화면
    @GetMapping("/products")
    public String productsPage(Model model) {
        var products = productService.getAllProducts();
        model.addAttribute("products", products);
        return "product-list";
    }

    // 새로운 상품 입력하기 위한 홈페이지로
    @GetMapping("new-product")
    public String newProductPage() {
        return "new-product";
    }

    // 생성 -> 저장 [리다이렉트] (DTO:Record 사용)
    @PostMapping("/products")
    public String newProduct(CreateProductRequest createProductRequest) {
        productService.createProduct(
                // 레코드라서 호출하는 식으로 진행, 다른 코드들은 어떤식으로 했었는지 비교해볼껏
                createProductRequest.productName(),
                createProductRequest.category(),
                createProductRequest.price(),
                createProductRequest.description());
        return "redirect:/products";
    }
}