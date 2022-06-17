package com.archTech.CartService.entity.Order;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;

@Data
@NoArgsConstructor
@Table(name="orderProduct")
public class OrderProduct
{
    private Long addedProductId;
    private Long productId;
    private Long quantity;
}
