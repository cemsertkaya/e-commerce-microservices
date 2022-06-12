package com.archTech.OrderService.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;




@Data
@Entity
@NoArgsConstructor
@Table(name="orderProduct")
public class OrderProduct
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long addedProductId;
    private Long productId;
    private Long quantity;


    public OrderProduct(Long productId, Long quantity)
    {
        this.productId = productId;
        this.quantity = quantity;
    }

}
