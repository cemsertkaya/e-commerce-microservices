package com.archTech.OrderService.VO.repository;




import com.archTech.OrderService.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;


public interface OrderRepository extends JpaRepository<Order,Long>
{
    Order findByOrderId(Long orderId);
}
