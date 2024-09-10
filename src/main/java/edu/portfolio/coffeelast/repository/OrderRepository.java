package edu.portfolio.coffeelast.repository;


import edu.portfolio.coffeelast.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
