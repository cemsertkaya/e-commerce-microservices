package com.archTech.CartService.controller;
import com.archTech.CartService.VO.ResponseTemplateVO;
import com.archTech.CartService.entity.Cart;
import com.archTech.CartService.service.CartService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/orders")
@Slf4j

public class CartController
{
    @Autowired
    private CartService cartService;

    @PostMapping("/")
    public Cart addCart(@RequestBody Cart order)
    {
        return cartService.addCart(order);
    }
    @GetMapping("/{id}")

    public ResponseTemplateVO getCartWithProducts(@PathVariable("id") Long orderId) {
        return cartService.getCartWithProducts(orderId);
    }
}
