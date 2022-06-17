package com.archTech.paymentservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@NoArgsConstructor
@AllArgsConstructor

public class AddedProduct
{
    private Long addedProductId;
    private Long productId;
    private Long quantity;
    private  Long userId;
}
