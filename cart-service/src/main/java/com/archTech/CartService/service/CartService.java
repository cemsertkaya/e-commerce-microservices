package com.archTech.CartService.service;

import com.archTech.CartService.entity.Cart;
import com.archTech.CartService.repository.CartRepository;
import com.archTech.product.entity.Product;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.ArrayList;
import java.util.List;


@Service
@Slf4j
public class CartService
{
    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private RestTemplate restTemplate;

    public Cart addCart(Cart cart) {return  cartRepository.save(cart);}

    public Cart findCartById(Long cartId) {return cartRepository.findByCartId(cartId);}

    public List<Cart> getAllCarts() {return cartRepository.findAll();}

    public void deleteAllCarts() {cartRepository.deleteAll();}
}
