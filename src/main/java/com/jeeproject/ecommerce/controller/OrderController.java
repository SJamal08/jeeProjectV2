package com.jeeproject.ecommerce.controller;

import com.jeeproject.ecommerce.model.OrderArticle;
import com.jeeproject.ecommerce.services.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    private final OrderService orderService;


    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<OrderArticle>> getAllOrders () {
        List<OrderArticle> orderArticles = orderService.findAllOrder();
        return new ResponseEntity<>(orderArticles, HttpStatus.OK);
    }

    @GetMapping("/find/{orderCode}")
    public ResponseEntity<OrderArticle> getOrderByOrderCode (@PathVariable("orderCode") String orderCode) {
        OrderArticle order = orderService.findOrderByOrderCode(orderCode);
        return new ResponseEntity<>(order, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<OrderArticle> addOrder(@RequestBody OrderArticle orderArticle) {
        OrderArticle newOrderArticle = orderService.addOrder(orderArticle);
        return new ResponseEntity<>(newOrderArticle, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<OrderArticle> updateOrder(@RequestBody OrderArticle orderArticle) {
        OrderArticle updateOrderArticle = orderService.updateOrder(orderArticle);
        return new ResponseEntity<>(updateOrderArticle, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{orderCode}")
    public ResponseEntity<?> deleteOrder(@PathVariable("orderCode") String orderCode) {
        orderService.deleteOrder(orderCode);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
