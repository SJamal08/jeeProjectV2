package com.jeeproject.ecommerce.model;

import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

//@Entity
public class Order implements Serializable {

 //   @Id
 //  @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false , updatable = false)
    private Long idOrder;
  /*  @OneToMany(fetch =FetchType.LAZY,mappedBy = "idUser")
    private List <Product> productList = new ArrayList<Product>();
    @Column(nullable = false , updatable = false)*/
    private String userCode;
    private String deliveryAddress;
    @Column(nullable = false , updatable = false)
    private String orderDate;
    @Column(nullable = false , updatable = false)
    private String orderCode;

    public Order() {
    }

    /*public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }*/

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

    public void setIdOrder(Long id) {
        this.idOrder = id;
    }

    @Id
    public Long getIdOrder() {
        return idOrder;
    }
}
