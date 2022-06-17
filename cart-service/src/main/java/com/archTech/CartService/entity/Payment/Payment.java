package com.archTech.CartService.entity.Payment;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Payment {

    private Long userId;
    private Long creditCardNumber;
    private Double price;
}
