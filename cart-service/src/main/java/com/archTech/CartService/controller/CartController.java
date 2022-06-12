package com.archTech.CartService.controller;
import com.archTech.CartService.entity.Cart;
import com.archTech.CartService.service.CartService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/carts")
@Slf4j

public class CartController
{
    @Autowired
    private CartService cartService;

    @PostMapping("/addCart")
    public Cart addCart(@RequestBody Cart order)
    {
        return cartService.addCart(order);
    }


    @GetMapping("/")
    public List<Cart> getAllCarts() {return cartService.getAllCarts();};

    @DeleteMapping("/delete")
    public void deleteAllCarts() { cartService.deleteAllCarts();}

}
