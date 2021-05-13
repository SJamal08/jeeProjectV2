package com.jeeproject.ecommerce.services;

import com.jeeproject.ecommerce.Exception.OrderNotFoundException;
import com.jeeproject.ecommerce.model.OrderArticle;
import com.jeeproject.ecommerce.repository.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class OrderService {

    private final OrderRepo orderRepo;

    @Autowired
    public OrderService(OrderRepo orderRepo) {
        this.orderRepo = orderRepo;
    }

    public OrderArticle addOrder(OrderArticle orderArticle) {
        orderArticle.setOrderCode("pr-"+ UUID.randomUUID().toString());
        return orderRepo.save(orderArticle);
    }

    public List<OrderArticle> findAllOrder() {
        return orderRepo.findAll();
    }

    public OrderArticle updateOrder(OrderArticle orderArticle) {
        return orderRepo.save(orderArticle);
    }

    public OrderArticle findOrderByOrderCode(String orderCode) {
        return orderRepo.findOrderByOrderCode(orderCode)
                .orElseThrow(() -> new OrderNotFoundException("Order by code " + orderCode + " was not found"));
    }

    public void deleteOrder(String orderCode){
        orderRepo.deleteOrderByOrderCode(orderCode);
    }
}
