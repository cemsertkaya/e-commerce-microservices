package com.archTech.OrderService.controller;

import com.archTech.OrderService.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.persistence.criteria.Order;

@RestController
@RequestMapping("/orders")
@Slf4j
public class OrderController
{
    @Autowired
    private OrderService orderService;

    @PostMapping("/")
    public Order addOrder(@RequestBody Order order)
    {
        return orderService.addOrder(order);
    }

    @GetMapping("/{id}")
    public Order getOrderWithId(@PathVariable("id") Long orderId)
    {
        return orderService.findOrderById(orderId);
    }
}
