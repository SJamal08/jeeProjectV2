package com.jeeproject.ecommerce.services;

import com.jeeproject.ecommerce.Exception.ProductNotFoundException;
import com.jeeproject.ecommerce.model.Product;
import com.jeeproject.ecommerce.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class ProductService {

    private final ProductRepo productRepo;

    @Autowired
    public ProductService(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }

    public Product addProduct(Product product) {
        product.setProductCode("pr-"+ UUID.randomUUID().toString());
        return productRepo.save(product);
    }

    public List<Product> findAllProduct() {
        return productRepo.findAll();
    }

    public Product updateProduct(Product product) {
        return productRepo.save(product);
    }

    public Product findProductByProductCode(String productCode) {
        return productRepo.findProductByProductCode(productCode)
                .orElseThrow(() -> new ProductNotFoundException("Product by code " + productCode + " was not found"));
    }

    public void deleteProduct(String productCode){
        productRepo.deleteProductByProductCode(productCode);
    }
}
