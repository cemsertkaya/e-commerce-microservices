package com.archTech.OrderService.entity;

import com.archTech.OrderService.VO.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;
    private Long userId;
    private String productIds;

    @OneToMany(cascade=CascadeType.ALL)
    @JoinColumn(name="orders_id")
    private Set<OrderProduct> addedProducts;
}
