package com.archTech.CartService.entity.Payment;


import com.archTech.CartService.entity.Cart.AddedProduct;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaymentInfo
{
    private Long userId;
    private Long creditCardNumber;
    private Double price;
    private Set<AddedProduct> addedProduct;
}
