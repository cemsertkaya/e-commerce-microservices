package com.archTech.CartService.entity.Order;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order
{
    private Long orderId;
    private Long userId;
    private Set<OrderProduct> addedProducts;
}