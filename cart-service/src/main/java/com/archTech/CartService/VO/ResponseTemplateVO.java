package com.archTech.CartService.VO;

import com.archTech.CartService.entity.Cart;
import com.archTech.product.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseTemplateVO {
    private Cart cart;
    private List<Product> products;
}
