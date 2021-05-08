package com.jeeproject.ecommerce.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Product implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false , updatable = false)
    private Long idProduct;
    private String title;
    private String imageUrl;
    private Long price;
    private Integer rating;
    @Column(nullable = false , updatable = false)
    private String productCode;

    public Product() {
    }

    public Product(Long idProduct, String title, String imageUrl, Long price, Integer rating, String productCode) {
        this.idProduct = idProduct;
        this.title = title;
        this.imageUrl = imageUrl;
        this.price = price;
        this.rating = rating;
        this.productCode = productCode;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public void setIdProduct(Long id) {
        this.idProduct = id;
    }

    @Id
    public Long getIdProduct() {
        return idProduct;
    }
}
