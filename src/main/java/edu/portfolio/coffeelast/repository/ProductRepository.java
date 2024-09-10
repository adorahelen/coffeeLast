package edu.portfolio.coffeelast.repository;

import edu.portfolio.coffeelast.entity.Category;
import edu.portfolio.coffeelast.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByCategory(Category category);

}