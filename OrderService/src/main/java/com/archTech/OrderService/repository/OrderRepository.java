package com.archTech.OrderService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import javax.persistence.criteria.Order;

public interface OrderRepository extends JpaRepository<Order,Long> {

    Order findByOrderId(Long orderId);
}
