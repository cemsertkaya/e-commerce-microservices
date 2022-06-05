package com.archTech.OrderService.controller;

import com.archTech.OrderService.VO.ResponseTemplateVO;
import com.archTech.OrderService.entity.Order;
import com.archTech.OrderService.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


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
    public ResponseTemplateVO getOrderWithProducts(@PathVariable("id") Long orderId) {
        return orderService.getOrderWithProducts(orderId);
    }
}
