package com.archTech.OrderService.service;

import com.archTech.OrderService.repository.OrderRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.persistence.criteria.Order;

@Service
@Slf4j
public class OrderService
{
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private RestTemplate restTemplate;

    public Order addOrder(Order order) {return  orderRepository.save(order);}

    public Order findOrderById(Long orderId) {return orderRepository.findByOrderId(orderId);}
}
