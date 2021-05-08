package com.jeeproject.ecommerce.repository;

import com.jeeproject.ecommerce.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepo extends JpaRepository<Order, Long> {
}
