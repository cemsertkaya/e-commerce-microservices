package com.archTech.CartService.VO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cart {
    private Long productId;
    private String productName;
    private String category;
    private Double price;
    private Long amount;
}
