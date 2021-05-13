package com.jeeproject.ecommerce.repository;

import com.jeeproject.ecommerce.model.OrderArticle;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OrderRepo extends JpaRepository<OrderArticle,Long>{

    void deleteOrderByOrderCode(String productCode);

    Optional<OrderArticle> findOrderByOrderCode(String productCode);
}
