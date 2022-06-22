package com.archTech.CartService.entity.Cart;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="addedProduct")
public class AddedProduct
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long addedProductId;
    private Long productId;
    private Long quantity;
    private Long userId;
    private String productName;
    private Double price;
}
