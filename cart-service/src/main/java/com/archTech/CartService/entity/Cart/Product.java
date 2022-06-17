package com.archTech.CartService.entity.Cart;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Data
@AllArgsConstructor
@NoArgsConstructor

public class Product
{
    private Long productId;
    private String productName;
    private String category;
    private Double price;
    private Long amount;
}

