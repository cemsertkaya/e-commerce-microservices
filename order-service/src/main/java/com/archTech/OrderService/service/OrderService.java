package com.archTech.OrderService.service;

import com.archTech.OrderService.VO.Product;
import com.archTech.OrderService.VO.ResponseTemplateVO;

import com.archTech.OrderService.entity.Order;
import com.archTech.OrderService.VO.repository.OrderRepository;
import com.archTech.OrderService.entity.OrderedProduct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;


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

    public ResponseTemplateVO getOrderWithProducts(Long orderId) {
        ResponseTemplateVO vo = new ResponseTemplateVO();
        Order order = orderRepository.findByOrderId(orderId);

        List<Product> products = new ArrayList<>();
        for (OrderedProduct addedProduct : order.getOrderedProducts()) {
            Product product = restTemplate.getForObject("http://localhost:9001/products/" + addedProduct.getOrderedProductId(), Product.class);
            products.add(product);
        }

        vo.setOrder(order);
        vo.setProducts(products);

        return vo;
    }
}
