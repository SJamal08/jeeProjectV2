package com.jeeproject.ecommerce.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Command implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false , updatable = false)
    private Long idCommand;

    @OneToMany(targetEntity =Product.class, mappedBy = "idProduct")
    private List<Product> productList= new ArrayList<Product>();

    @Column(nullable = false , updatable = false)
    private String userCode;

    private String deliveryAddress;

    @Column(nullable = false , updatable = false)
    private String commandDate;

    @Column(nullable = false , updatable = false)
    private String commandCode;

    public Command() {
    }

    public Command(Long idCommand, List<Product> productList, String userCode, String deliveryAddress, String commandDate, String commandCode) {
        this.idCommand = idCommand;
       this.productList = productList;
        this.userCode = userCode;
        this.deliveryAddress = deliveryAddress;
        this.commandDate = commandDate;
        this.commandCode = commandCode;
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

    public String getCommandDate() {
        return commandDate;
    }

    public void setCommandDate(String commandDate) {
        this.commandDate = commandDate;
    }

    public String getCommandCode() {
        return commandCode;
    }

    public void setCommandCode(String commandCode) {
        this.commandCode = commandCode;
    }



    public void setIdCommand(Long idCommand) {
        this.idCommand = idCommand;
    }

    public Long getIdCommand() {
        return idCommand;
    }
}
