package com.archTech.paymentservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaymentBody
{

    private Payment payment;
    private Set<AddedProduct> addedProduct;
}
