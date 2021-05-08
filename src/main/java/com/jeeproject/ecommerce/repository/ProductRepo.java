package com.jeeproject.ecommerce.repository;

import com.jeeproject.ecommerce.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductRepo extends JpaRepository<Product, Long> {

    void deleteProductByProductCode(String productCode);

    Optional<Product> findProductByProductCode(String productCode);
}
