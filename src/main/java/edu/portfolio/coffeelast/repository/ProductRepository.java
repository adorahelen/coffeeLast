package edu.portfolio.coffeelast.repository;

import edu.portfolio.coffeelast.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;



public interface ProductRepository extends JpaRepository<Product, Long> {

}