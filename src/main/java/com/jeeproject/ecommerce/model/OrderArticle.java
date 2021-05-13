package com.jeeproject.ecommerce.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class OrderArticle implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false , updatable = false)
    private Long idOrder;

    @OneToMany(targetEntity =Product.class, mappedBy = "idProduct")
    private List <Product> productList;

    @Column(nullable = false , updatable = false)
    private String userCode;

    private String deliveryAddress;

    @Column(nullable = false , updatable = false)
    private String orderDate;

    @Column(nullable = false , updatable = false)
    private String orderCode;

    public OrderArticle() {
    }

    public OrderArticle(Long idOrder, List<Product> productList, String userCode, String deliveryAddress, String orderDate, String orderCode) {
        this.idOrder = idOrder;
       // this.productList = productList;
        this.userCode = userCode;
        this.deliveryAddress = deliveryAddress;
        this.orderDate = orderDate;
        this.orderCode = orderCode;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }



    public void setIdOrder(Long idOrder) {
        this.idOrder = idOrder;
    }

    public Long getIdOrder() {
        return idOrder;
    }
}
