package com.archTech.paymentservice.entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Order
{
    private Long userId;
    private Set<AddedProduct> addedProducts;
}