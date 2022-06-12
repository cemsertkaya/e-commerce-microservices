package com.archTech.CartService.service;

import com.archTech.CartService.entity.AddedProduct;
import com.archTech.CartService.entity.Cart;
import com.archTech.CartService.repository.CartRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

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


    public List<Cart> getAllCarts() {return cartRepository.findAll();}

    public void deleteAllCarts() {cartRepository.deleteAll();}

    public void addProductToCart(AddedProduct addedProduct) {

        Cart cart = cartRepository.findByUserId(addedProduct.getUserId());
        log.info(String.valueOf(addedProduct.getUserId()));
        cart.getAddedProducts().add(addedProduct);
        cartRepository.save(cart);

    }
}
