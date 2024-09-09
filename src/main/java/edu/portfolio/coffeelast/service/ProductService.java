package edu.portfolio.coffeelast.service;

import edu.portfolio.coffeelast.entity.Category;
import edu.portfolio.coffeelast.entity.Product;
import edu.portfolio.coffeelast.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    } // 뷰를 통해서 (리스트로 반환)

    public Product createProduct(String productName, Category category, int price, String description) {
        var product = new Product(productName, category, price, description, LocalDateTime.now(), LocalDateTime.now());
        return productRepository.save(product);


        // 'Product()' cannot be applied to
        //          '(java.lang.String, edu.portfolio.coffeelast.entity.Category, int, java.lang.String)'

        // 이 에러 메시지는 Product 클래스에 생성자가 제대로 정의되지 않아서 발생하는 문제입니다.
        // JPA 엔티티나 일반 객체에 대해 생성자를 정의할 때, 생성자 파라미터가 일치하지 않으면,
            // 컴파일러는 Product() 생성자를 사용할 수 없다고 경고를 내립니다.
    }

}