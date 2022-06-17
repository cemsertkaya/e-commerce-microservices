package com.archTech.CartService.entity.Payment;
import com.archTech.CartService.entity.Cart.AddedProduct;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaymentPostBody {
    private Payment payment;
    private Set<AddedProduct> addedProduct;
}
